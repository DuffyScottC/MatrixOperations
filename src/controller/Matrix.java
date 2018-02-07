/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MatrixFormatException;
import exceptions.MatrixInvalidRowNumberException;
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
    
    /**
     * 
     * @param input
     * @throws MatrixFormatException if the matrix input by the user is not in
     * the right format. This ensures for the rest of the methods that all rows
     * have the same number of columns, etc.
     */
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
            //fill in the current row
            numbers[row] = fillRow(p, inputRows[row]);
        }
    }
    
    /**
     * Places the numbers within the given row into an integer array. 
     * @param p
     * @param inputRow
     * @return An array holding the numbers in the row
     * @throws MatrixFormatException if a row has more or fewer numbers
     * than the first row.
     */
    private int[] fillRow(Pattern p, String inputRow) throws MatrixFormatException {
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
            try {
                //add the number to the current column in the row
                rowNumbers[col] = number;
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new MatrixFormatException("Please make sure all rows"
                        + " have the same number of columns.");
            }
            //increment column number
            col += 1;
        }
        //if there are fewer elements in rowNumbers than there should be
        if (col < c-1) {
            throw new MatrixFormatException("Please make sure all rows"
                        + " have the same number of columns.");
        }
        //return the numbers in the row
        return rowNumbers;
    }
    
    private int getNumberOfColumns(String rowOne) {
        Pattern p = Pattern.compile("[-0-9]+");
        Matcher m = p.matcher(rowOne);
        //counts the number of columns
        int count = 0;
        //loop through occurances
        while (m.find()) {
            //count each occurance
            count += 1;
        }
        //return the number of columns
        return count;
    }
    
    /**
     * add first times constant to second and replace second
     * @param constant
     * @param firstRowNumber
     * @param secondRowNumber 
     * @return A text representation of the addition step in matrix notation
     * @throws MatrixInvalidRowNumberException if the input row numbers are
     * out of the bounds of the matrix's number of rows.
     */
    public String addRows(int constant, int firstRowNumber, int secondRowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(firstRowNumber);
        validateRowNumber(secondRowNumber);
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
     * @throws MatrixInvalidRowNumberException if the input row numbers are
     * out of the bounds of the matrix's number of rows.
     */
    public String swapRows(int firstRowNumber, int secondRowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(firstRowNumber);
        validateRowNumber(secondRowNumber);
        int [] firstRow = numbers[firstRowNumber - 1];
        int [] secondRow = numbers[secondRowNumber - 1];
        numbers[firstRowNumber - 1] = secondRow;
        numbers[secondRowNumber - 1] = firstRow;
        return "R" + firstRowNumber + " <-> R" + secondRowNumber;
    }
    
    /**
     * Multiply the specified row by the specified constant and replace that
     * row with its new version.
     * @param constant
     * @param rowNumber
     * @return A text representation of the multiply step in matrix notation
     * @throws MatrixInvalidRowNumberException if the input row numbers are
     * out of the bounds of the matrix's number of rows.
     */
    public String multiplyRow(int constant, int rowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(rowNumber);
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
    
    /**
     * Divide the specified row by the specified constant and replace that
     * row with its new version.
     * @param constant
     * @param rowNumber
     * @return A text representation of the divide step in matrix notation
     * @throws MatrixInvalidRowNumberException if the input row numbers are
     * out of the bounds of the matrix's number of rows.
     */
    public String divideRow(int constant, int rowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(rowNumber);
        //get the row to be divided
        int [] row = numbers[rowNumber - 1];
        for (int col = 0; col < c; col++) {
            //get the new number
            int newNumber = row[col]/constant;
            //replace the old number
            row[col] = newNumber;
        }
        return "(1/" + constant + ")R" + rowNumber + "-> R" + rowNumber;
    }
    
    /**
     * Checks to make sure the row is within the range of 1-{@link r}.
     * @param row
     * @throws MatrixInvalidRowNumberException If the input row is not within
     * the range of 1-{@link r}
     */
    private void validateRowNumber(int row) throws MatrixInvalidRowNumberException {
        //if the row is out of the bounds
        if (row < 1 || row > r) {
            throw new MatrixInvalidRowNumberException("Please use a row"
                    + "number between 1 and " + r);
        }
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