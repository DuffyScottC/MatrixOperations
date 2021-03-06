/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MatrixFormatException;
import exceptions.MatrixInvalidRowNumberException;
import views.MatrixFrame;
import views.NewMatrixDialog;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MatrixOperations {

    private final MatrixFrame frame = new MatrixFrame();
    private Matrix matrix = null;
    private NewMatrixDialog newMatrixDialog = new  NewMatrixDialog(frame, true);
    private JComboBox operationComboBox = frame.getOperationComboBox();
    private JPanel operationCardPanel = frame.getOparationCardPanel();
    private CardLayout operationCardLayout 
            = (CardLayout) operationCardPanel.getLayout();
    
    /**
     * These serve as both the names shown to the user in the operationComboBox
     * and as the cardNames of the panels that match the operation.
     */
    private final String[] operationsList = {
            "Add",
            "Swap",
            "Multiply",
            "Divide"
        };
    
    public MatrixOperations() {
        frame.setTitle(getClass().getSimpleName());
        frame.setLocationRelativeTo(null);
        // frame.setSize(600, 500);
        
        JTextArea outputTextArea = frame.getOutputTextArea();
        
        addActionListenersToTextFields();
        
        setUpComboBox();
        
        operationComboBox.addActionListener((ActionEvent e) -> {
            int selectedIndex = operationComboBox.getSelectedIndex();
            String panel = operationsList[selectedIndex];
            operationCardLayout.show(operationCardPanel, panel);
        });
        
        newMatrixDialog.getAddButton().addActionListener((ActionEvent e) -> {
            //get the user input
            String input = newMatrixDialog.getNewMatrixTextArea().getText();
            String step = "Starting Matrix";
            try {
                //if this is the first time we are adding a matrix
                if (matrix == null) {
                    //assign the matrix
                    matrix = new Matrix(input);
                } else { //if we are currently working on a matrix
                    step = matrix.insert(input);
                }
            } catch (MatrixFormatException ex) {
                //tell the user what went wrong
                JOptionPane.showMessageDialog(frame, ex.getMessage());
                //leave the method and allow the user to try again
                return;
            }
            //add the matrix to the output window
            addStepToOutput(step);
            newMatrixDialog.setVisible(false);
        });
        
        frame.getInsertButton().addActionListener((ActionEvent e) -> {
            showAddMatrixDialog();
        });
        
        frame.getUndoButton().addActionListener((ActionEvent e) -> {
            String step;
            try {
                step = matrix.undo();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                //leave
                return;
            }
            //update the output
            addStepToOutput(step);
        });
        
        frame.getAddButton().addActionListener((ActionEvent e) -> {
            //get the constant
            String constantString = frame.getAddConstantTextField().getText();
            double constant = 1;
            if (!constantString.equals("")) {
                constant = Double.parseDouble(constantString);
            }
            
            //get the first row number
            String firstString = frame.getAddFirstRowTextField().getText();
            int firstRowNumber = Integer.parseInt(firstString);
            
            //get the second row number
            String secondString = frame.getAddSecondRowTextField().getText();
            int secondRowNumber = Integer.parseInt(secondString);
            
            String step;
            
            try {
                //perform the operation
                step = matrix.addRows(constant, firstRowNumber, secondRowNumber);
            } catch (MatrixInvalidRowNumberException ex) {
                //tell the user what went wrong
                JOptionPane.showMessageDialog(frame, ex.getMessage());
                //leave the method and allow the user to try again
                return;
            }
            //update the output
            addStepToOutput(step);
        });
        
        frame.getSwapButton().addActionListener((ActionEvent e) -> {
            //get the first row number
            String firstString = frame.getSwapFirstRowTextField().getText();
            int firstRowNumber = Integer.parseInt(firstString);
            
            //get the second row number
            String secondString = frame.getSwapSecondRowTextField().getText();
            int secondRowNumber = Integer.parseInt(secondString);
            
            String step;
            try {
                //perform the operation
                step = matrix.swapRows(firstRowNumber, secondRowNumber);
            } catch (MatrixInvalidRowNumberException ex) {
                //tell the user what went wrong
                JOptionPane.showMessageDialog(frame, ex.getMessage());
                //leave the method and allow the user to try again
                return;
            }
            //update the output
            addStepToOutput(step);
        });
        
        frame.getMultiplyButton().addActionListener((ActionEvent e) -> {
            //get the constant
            String constantString = frame.getMultiplyConstantTextField().getText();
            double constant = 1;
            if (!constantString.equals("")) {
                constant = Double.parseDouble(constantString);
            }
            
            //get the row number
            String rowNumberString = frame.getMultiplyRowTextField().getText();
            int rowNumber = Integer.parseInt(rowNumberString);
            
            String step;
            try {
                //perform the operation
                step = matrix.multiplyRow(constant, rowNumber);
            } catch (MatrixInvalidRowNumberException ex) {
                //tell the user what went wrong
                JOptionPane.showMessageDialog(frame, ex.getMessage());
                //leave the method and allow the user to try again
                return;
            }
            //update the output
            addStepToOutput(step);
        });
        
        frame.getDivideButton().addActionListener((ActionEvent e) -> {
            //get the constant
            String constantString = frame.getDivideConstantTextField().getText();
            double constant = 1;
            if (!constantString.equals("")) {
                constant = Double.parseDouble(constantString);
            }
            
            //get the row number
            String rowNumberString = frame.getDivideRowTextField().getText();
            int rowNumber = Integer.parseInt(rowNumberString);
            
            String step;
            try {
                //perform the operation
                step = matrix.divideRow(constant, rowNumber);
            } catch (MatrixInvalidRowNumberException ex) {
                //tell the user what went wrong
                JOptionPane.showMessageDialog(frame, ex.getMessage());
                //leave the method and allow the user to try again
                return;
            }
            //update the output
            addStepToOutput(step);
        });
        
        showAddMatrixDialog();
    }
    
    private void addStepToOutput(String step) {
        StringBuilder s = new StringBuilder(frame.getOutputTextArea().getText());
        s.append("\n");
        s.append(step);
        s.append("\n");
        s.append(matrix.toString());
        frame.getOutputTextArea().setText(s.toString());
    }
    
    private void showAddMatrixDialog() {
        newMatrixDialog.setLocationRelativeTo(null);
        newMatrixDialog.setTitle("Add Matrix");
        newMatrixDialog.setVisible(true);
    }
    
    private void setUpComboBox() {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(operationsList);
        operationComboBox.setModel(comboBoxModel);
    }
    
    private void addActionListenersToTextFields() {
        frame.getAddSecondRowTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //get the text in the addSecondRowTextField
                String rowNumber = frame.getAddSecondRowTextField().getText();
                //make the text in the secondRowLabel match
                frame.getSecondRowLabel().setText(rowNumber);
            }
        });
        
        frame.getMultiplyRowTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //get the text in the textfield
                String rowNumber = frame.getMultiplyRowTextField().getText();
                //make the text in the label match
                frame.getMultiplyRowLabel().setText(rowNumber);
            }
        });
        
        frame.getDivideRowTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //get the text in the textfield
                String rowNumber = frame.getDivideRowTextField().getText();
                //make the text in the label match
                frame.getDivideRowNumberLabel().setText(rowNumber);
            }
        });
        
        FocusAdapter selectOnClick = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //get the textfield that called this listener
                JTextField textField = (JTextField) e.getSource();
                //select all the text
                textField.selectAll();
            }
        };
        
        frame.getAddConstantTextField().addFocusListener(selectOnClick);
        frame.getAddFirstRowTextField().addFocusListener(selectOnClick);
        frame.getAddSecondRowTextField().addFocusListener(selectOnClick);
        
        frame.getSwapFirstRowTextField().addFocusListener(selectOnClick);
        frame.getSwapSecondRowTextField().addFocusListener(selectOnClick);
        
        frame.getMultiplyConstantTextField().addFocusListener(selectOnClick);
        frame.getMultiplyRowTextField().addFocusListener(selectOnClick);
        
        frame.getDivideConstantTextField().addFocusListener(selectOnClick);
        frame.getDivideRowTextField().addFocusListener(selectOnClick);
    }

    public static void main(String[] args) {
        MatrixOperations app = new MatrixOperations();
        app.frame.setVisible(true);
    }
}
