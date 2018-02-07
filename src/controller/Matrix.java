/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MatrixFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Scott
 */
public class Matrix {

    /**
     * A two dimensional array of numbers designed to hold rows and columns of a
     * matrix. The sizes are defined in the constructor.
     */
    private int[][] numbers;
    /**
     * The number of rows in the matrix
     */
    private int r;
    /**
     * The number of columns in the matrix
     */
    private int c;

    public Matrix(String input) throws MatrixFormatException {
        //get the lines of the user input
        String[] inputRows = input.split(System.getProperty("line.separator"));
        if (inputRows.length == 0) {
            System.out.println("Please write the matrix in the box");
            return;
        }
        //get the number of rows
        r = inputRows.length;
        //get the number of colums in row 1
        c = getNumberOfColumns(inputRows[0]);
        //initialize numbers
        numbers = new int[r][c];
        //fill in numbers
        fillNumbers(inputRows);
    }
    
    /**
     * Takes the input numbers (the rows from the user input matrix) and adds
     * the numbers to the {@link numbers} array.
     * @param inputRows An array of strings representing the rows
     * @throws MatrixFormatException if a row has more or fewer numbers
     * than the first row.
     */
    private void fillNumbers(String[] inputRows) throws MatrixFormatException {
        Pattern p = Pattern.compile("[-0-9]+");
        //loop through the rows in inputRows (and in numbers)
        for (int row = 0; row < r; row++) {
            try {
                //fill in the current row
                numbers[row] = fillRow(p, inputRows[row]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new MatrixFormatException("Please make sure all rows"
                        + " have the same number of columns.");
            }
        }
    }
    
    /**
     * Places the numbers within the given row into an integer array. 
     * @param p
     * @param inputRow
     * @return An array holding the numbers in the row
     */
    private int[] fillRow(Pattern p, String inputRow) {
        //start matching inputRow
        Matcher m = p.matcher(inputRow);
        //this keeps track of the current column in the row
        int col = 0;
        //this holds the row numbers as they are found
        int[] rowNumbers = new int[c];
        //while we are finding more numbers
        while (m.find()) {
            //get the current number
            String stringNumber = m.group();
            //convert the sringNumber to an integer
            int number = Integer.parseInt(stringNumber);
            //add the number to the current column in the row
            rowNumbers[col] = number;
            //increment column number
            col += 1;
        }
        //return the numbers in the row
        return rowNumbers;
    }
    
    private int getNumberOfColumns(String rowOne) {
        //match any numbers (negative or positive) of one or more digits
        Pattern p = Pattern.compile("[-0-9]+");
        //get the numbers in the row
        int[] rowOneNumbers = fillRow(p, rowOne);
        //return the number of numbers in the row
        return rowOneNumbers.length;
    }
    
    /**
     * add first times constant to second and replace second
     * @param constant
     * @param firstRowNumber
     * @param secondRowNumber 
     * @return A text representation of the addition step in matrix notation
     */
    public String addRows(int constant, int firstRowNumber, int secondRowNumber) {
        int [] firstRow = numbers[firstRowNumber - 1];
        int [] secondRow = numbers[secondRowNumber - 1];
        for (int col = 0; col < c; col++) {
            //calculate the new number
            int newNumber = constant*firstRow[col] + secondRow[col];
            //replace the old number with the new number
            secondRow[col] = newNumber;
        }
        return constant + "R" + firstRowNumber + " + R" + secondRowNumber
                + " -> R" + secondRowNumber;
    }
    
    /**
     * Swap two rows
     * @param firstRowNumber
     * @param secondRowNumber
     * @return A text representation of the swap step in matrix notation
     */
    public String swapRows(int firstRowNumber, int secondRowNumber) {
        int [] firstRow = numbers[firstRowNumber - 1];
        int [] secondRow = numbers[secondRowNumber - 1];
        numbers[firstRowNumber - 1] = secondRow;
        numbers[secondRowNumber - 1] = firstRow;
        return "R" + firstRowNumber + " <-> R" + secondRowNumber;
    }
    
    public String multiplyRow(int constant, int rowNumber) {
        //get the row to be multiplied
        int [] row = numbers[rowNumber - 1];
        for (int col = 0; col < c; col++) {
            //get the new number
            int newNumber = constant*row[col];
            //replace the old number
            row[col] = newNumber;
        }
        return constant + "R" + rowNumber + "-> R" + rowNumber;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int row = 0; row < r; row++) {
            s.append("|");
            for (int col = 0; col < c; col++) {
                s.append(numbers[row][col]);
                //if this is not the last column
                if (col < c - 1) {
                    s.append("\t"); //spaces between columns
                }
            }
            s.append("|\n"); //new line for new row
        }
        return s.toString();
    }

}