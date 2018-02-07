/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixoperations;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
            "Multiply"
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
            newMatrixDialog.setVisible(false);
            //get the user input
            String input = newMatrixDialog.getNewMatrixTextArea().getText();
            //assign the matrix
            matrix = new Matrix(input);
            outputTextArea.setText(matrix.toString());
        });
        
        frame.getAddButton().addActionListener((ActionEvent e) -> {
            //get the constant
            String constantString = frame.getAddConstantTextField().getText();
            int constant = 1;
            if (!constantString.equals("")) {
                constant = Integer.parseInt(constantString);
            }
            
            //get the first row number
            String firstString = frame.getAddFirstRowTextField().getText();
            int firstRowNumber = Integer.parseInt(firstString);
            
            //get the second row number
            String secondString = frame.getAddSecondRowTextField().getText();
            int secondRowNumber = Integer.parseInt(secondString);
            
            //perform the operation
            String step = matrix.addRows(constant, firstRowNumber, secondRowNumber);
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
            
            //perform the operation
            String step = matrix.swapRows(firstRowNumber, secondRowNumber);
            //update the output
            addStepToOutput(step);
        });
        
        frame.getMultiplyButton().addActionListener((ActionEvent e) -> {
            //get the constant
            String constantString = frame.getMultiplyConstantTextField().getText();
            int constant = 1;
            if (!constantString.equals("")) {
                constant = Integer.parseInt(constantString);
            }
            
            //get the row number
            String rowNumberString = frame.getMultiplyRowNumberTextField().getText();
            int rowNumber = Integer.parseInt(rowNumberString);
            
            //perform the operation
            String step = matrix.multiplyRow(constant, rowNumber);
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
            public void keyPressed(KeyEvent e) {
                //get the text in the addSecondRowTextField
                String rowNumber = frame.getAddSecondRowTextField().getText();
                //make the text in the secondRowLabel match
                frame.getSecondRowLabel().setText(rowNumber);
            }
        });
        
        frame.getMultiplyRowNumberLabel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //get the text in the textfield
                String rowNumber = frame.getMultiplyRowNumberTextField().getText();
                //make the text in the label match
                frame.getMultiplyRowNumberLabel().setText(rowNumber);
            }
        });
        
        ActionListener selectOnClick = (ActionEvent e) -> {
            //get the textfield that called this listener
            JTextField textField = (JTextField) e.getSource();
            //select all the text
            textField.selectAll();
        };
        
        frame.getAddConstantTextField().addActionListener(selectOnClick);
        frame.getAddFirstRowTextField().addActionListener(selectOnClick);
        frame.getAddSecondRowTextField().addActionListener(selectOnClick);
        frame.getSwapFirstRowTextField().addActionListener(selectOnClick);
        frame.getSwapSecondRowTextField().addActionListener(selectOnClick);
        frame.getMultiplyConstantTextField().addActionListener(selectOnClick);
        frame.getMultiplyRowNumberTextField().addActionListener(selectOnClick);
    }

    public static void main(String[] args) {
        MatrixOperations app = new MatrixOperations();
        app.frame.setVisible(true);
    }
}