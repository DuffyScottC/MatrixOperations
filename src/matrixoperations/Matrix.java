/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperations;

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

    public Matrix(String input) {
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
    
    private void fillNumbers(String[] inputRows) {
        Pattern p = Pattern.compile("[-0-9]+");
        //loop through the rows in inputRows (and in numbers)
        for (int row = 0; row < r; row++) {
            Matcher m = p.matcher(inputRows[row]);
            int col = 0;
            while (m.find()) {
                //get the current number
                String stringNumber = m.group();
                //convert the sringNumber to an integer
                int number = Integer.parseInt(stringNumber);
                //add the number to the numbers column
                numbers[row][col] = number;
                //increment column number
                col += 1;
            }
        }
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