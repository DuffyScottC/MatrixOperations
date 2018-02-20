/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MatrixFormatException;
import exceptions.MatrixInvalidRowNumberException;
import java.util.Stack;
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
    private double[][] numbers;
    /**
     * The number of rows in the matrix
     */
    private int r;
    /**
     * The number of columns in the matrix
     */
    private int c;
    private final Stack<double[][]> undoNumbersStack = new Stack();
    private final Stack<String> undoStepDescStack = new Stack();
    
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
            throw new MatrixFormatException("Please write a matrix in the box");
        }
        //get the number of rows
        r = inputRows.length;
        //get the number of colums in row 1
        c = getNumberOfColumns(inputRows[0]);
        //initialize numbers
        numbers = new double[r][c];
        //fill in numbers
        fillNumbers(inputRows);
    }
    
    /**
     * Replace the current numbers with the newly inserted matrix
     * @param input The user inserted matrix
     * @return A string representation of the insert step
     * @throws MatrixFormatException if the matrix input by the user is not in
     * the right format. This ensures for the rest of the methods that all rows
     * have the same number of columns, etc.
     */
    public String insert(String input) throws MatrixFormatException {
        //get the lines of the user input
        String[] inputRows = input.split(System.getProperty("line.separator"));
        if (inputRows.length == 0) {
            throw new MatrixFormatException("Please write a matrix in the box");
        }
        //get the number of rows
        double newR = inputRows.length;
        //check if the number of rows is the same as the original matrix
        if (newR != r) {
            throw new MatrixFormatException("Please write " + r + "rows to"
                    + "match the current matrix.");
        }
        //get the number of colums in row 1
        double newC = getNumberOfColumns(inputRows[0]);
        //check if the number of rows is the same as the original matrix
        if (newC != c) {
            throw new MatrixFormatException("Please write " + c + "columns to"
                    + "match the current matrix.");
        }
        String step = "Insert Matrix";
        storeCurrentState(step); //store current state of numbers
        //initialize numbers to be a new empty double[][] array
        numbers = new double[r][c];
        //fill in numbers
        fillNumbers(inputRows);
        //output the text representation of the insert step
        return step;
    }
    
    /**
     * Undo the last operation.
     * @return A text description of the undo step.
     * @throws Exception If there is nothing to undo.
     */
    public String undo() throws Exception {
        if (undoNumbersStack.isEmpty()) {
            throw new Exception("Nothing to undo.");
        }
        //pop the last version of numbers
        double[][] oldNumbers = undoNumbersStack.pop();
        //replace the current numbers with the old numbers
        numbers = oldNumbers;
        //pop the last step description
        String oldStep = undoStepDescStack.pop();
        //return the text description of the undo step
        return "Undo " + oldStep;
    }
    
    private void storeCurrentState(String step) {
        double[][] currentNumbersCopy = new double[r][c];
        //loop through currentNumbersCopy row by row and column by column
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                //set the currentNumbersCopy num to the matching one in numbers
                currentNumbersCopy[row][col] = numbers[row][col];
            }
        }
        //add the currentNumbersCopy to the undoNumbersStack
        undoNumbersStack.add(currentNumbersCopy);
        undoStepDescStack.add(step);
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
     * Places the numbers within the given row into an double array. 
     * @param p
     * @param inputRow
     * @return An array holding the numbers in the row
     * @throws MatrixFormatException if a row has more or fewer numbers
     * than the first row.
     */
    private double[] fillRow(Pattern p, String inputRow) throws MatrixFormatException {
        //start matching inputRow
        Matcher m = p.matcher(inputRow);
        //this keeps track of the current column in the row
        int col = 0;
        //this holds the row numbers as they are found
        double[] rowNumbers = new double[c];
        //while we are finding more numbers
        while (m.find()) {
            //get the current number
            String stringNumber = m.group();
            //convert the sringNumber to an double
            double number = Integer.parseInt(stringNumber);
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
    public String addRows(double constant, int firstRowNumber, int secondRowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(firstRowNumber);
        validateRowNumber(secondRowNumber);
        String step = constant + "R" + firstRowNumber + " + R" + secondRowNumber
                + " -> R" + secondRowNumber;
        storeCurrentState(step); //store current state of numbers
        double [] firstRow = numbers[firstRowNumber - 1];
        double [] secondRow = numbers[secondRowNumber - 1];
        for (int col = 0; col < c; col++) {
            //calculate the new number
            double newNumber = constant*firstRow[col] + secondRow[col];
            //replace the old number with the new number
            secondRow[col] = newNumber;
        }
        return step;
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
        String step = "R" + firstRowNumber + " <-> R" + secondRowNumber;
        storeCurrentState(step); //store current state of numbers
        double [] firstRow = numbers[firstRowNumber - 1];
        double [] secondRow = numbers[secondRowNumber - 1];
        numbers[firstRowNumber - 1] = secondRow;
        numbers[secondRowNumber - 1] = firstRow;
        return step;
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
    public String multiplyRow(double constant, int rowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(rowNumber);
        String step = constant + "R" + rowNumber + "-> R" + rowNumber;
        storeCurrentState(step); //store current state of numbers
        //get the row to be multiplied
        double [] row = numbers[rowNumber - 1];
        for (int col = 0; col < c; col++) {
            //get the new number
            double newNumber = constant*row[col];
            //replace the old number
            row[col] = newNumber;
        }
        return step;
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
    public String divideRow(double constant, int rowNumber) 
            throws MatrixInvalidRowNumberException {
        validateRowNumber(rowNumber);
        String step = "(1/" + constant + ")R" + rowNumber + "-> R" + rowNumber;
        storeCurrentState(step); //store current state of numbers
        //get the row to be divided
        double [] row = numbers[rowNumber - 1];
        for (int col = 0; col < c; col++) {
            //get the new number
            double newNumber = row[col]/constant;
            //replace the old number
            row[col] = newNumber;
        }
        return step;
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