/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Scott
 */
public class MatrixFrame extends javax.swing.JFrame {

    /**
     * Creates new form MatrixFrame
     */
    public MatrixFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        operationComboBox = new javax.swing.JComboBox<>();
        oparationCardPanel = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        addConstantTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addFirstRowTextField = new javax.swing.JTextField();
        addSecondRowTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        secondRowLabel = new javax.swing.JLabel();
        swapPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        swapFirstRowTextField = new javax.swing.JTextField();
        swapSecondRowTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        swapButton = new javax.swing.JButton();
        multiplyPanel = new javax.swing.JPanel();
        multiplyConstantTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        multiplyRowNumberTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        multiplyRowNumberLabel = new javax.swing.JLabel();
        multiplyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        jLabel1.setText("Matrix:");

        operationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        oparationCardPanel.setLayout(new java.awt.CardLayout());

        addConstantTextField.setColumns(2);

        jLabel2.setText("R");

        addFirstRowTextField.setColumns(1);
        addFirstRowTextField.setText("1");

        addSecondRowTextField.setColumns(1);
        addSecondRowTextField.setText("2");

        jLabel3.setText("+ R");

        jLabel4.setText("-> R");

        addButton.setText("Add");

        secondRowLabel.setText("2");

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addConstantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFirstRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSecondRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondRowLabel)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(addPanelLayout.createSequentialGroup()
                .addComponent(addButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addConstantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addFirstRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(addSecondRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(secondRowLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        oparationCardPanel.add(addPanel, "Add");

        jLabel5.setText("R");

        swapFirstRowTextField.setColumns(1);
        swapFirstRowTextField.setText("1");

        swapSecondRowTextField.setColumns(1);
        swapSecondRowTextField.setText("2");

        jLabel6.setText("<-> R");

        swapButton.setText("Swap");

        javax.swing.GroupLayout swapPanelLayout = new javax.swing.GroupLayout(swapPanel);
        swapPanel.setLayout(swapPanelLayout);
        swapPanelLayout.setHorizontalGroup(
            swapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(swapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swapFirstRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swapSecondRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(swapPanelLayout.createSequentialGroup()
                .addComponent(swapButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        swapPanelLayout.setVerticalGroup(
            swapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(swapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(swapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(swapFirstRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(swapSecondRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swapButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        oparationCardPanel.add(swapPanel, "Swap");

        multiplyConstantTextField.setColumns(1);

        jLabel7.setText("R");

        multiplyRowNumberTextField.setColumns(1);
        multiplyRowNumberTextField.setText("1");
        multiplyRowNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplyRowNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("-> R");

        multiplyRowNumberLabel.setText("1");

        multiplyButton.setText("Multiply");

        javax.swing.GroupLayout multiplyPanelLayout = new javax.swing.GroupLayout(multiplyPanel);
        multiplyPanel.setLayout(multiplyPanelLayout);
        multiplyPanelLayout.setHorizontalGroup(
            multiplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(multiplyConstantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiplyRowNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiplyRowNumberLabel)
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(multiplyPanelLayout.createSequentialGroup()
                .addComponent(multiplyButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        multiplyPanelLayout.setVerticalGroup(
            multiplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multiplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiplyConstantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(multiplyRowNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(multiplyRowNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiplyButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        oparationCardPanel.add(multiplyPanel, "Multiply");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oparationCardPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oparationCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void multiplyRowNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplyRowNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multiplyRowNumberTextFieldActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addConstantTextField;
    private javax.swing.JTextField addFirstRowTextField;
    private javax.swing.JPanel addPanel;
    private javax.swing.JTextField addSecondRowTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton multiplyButton;
    private javax.swing.JTextField multiplyConstantTextField;
    private javax.swing.JPanel multiplyPanel;
    private javax.swing.JLabel multiplyRowNumberLabel;
    private javax.swing.JTextField multiplyRowNumberTextField;
    private javax.swing.JPanel oparationCardPanel;
    private javax.swing.JComboBox<String> operationComboBox;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel secondRowLabel;
    private javax.swing.JButton swapButton;
    private javax.swing.JTextField swapFirstRowTextField;
    private javax.swing.JPanel swapPanel;
    private javax.swing.JTextField swapSecondRowTextField;
    // End of variables declaration//GEN-END:variables
    
    public JTextArea getOutputTextArea() {
        return outputTextArea;
    }

    public JTextField getAddConstantTextField() {
        return addConstantTextField;
    }

    public JTextField getAddFirstRowTextField() {
        return addFirstRowTextField;
    }

    public JPanel getOparationCardPanel() {
        return oparationCardPanel;
    }

    public JComboBox<String> getOperationComboBox() {
        return operationComboBox;
    }

    public JTextField getAddSecondRowTextField() {
        return addSecondRowTextField;
    }

    public JLabel getSecondRowLabel() {
        return secondRowLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSwapButton() {
        return swapButton;
    }

    public JTextField getSwapSecondRowTextField() {
        return swapSecondRowTextField;
    }

    public JTextField getSwapFirstRowTextField() {
        return swapFirstRowTextField;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JTextField getMultiplyConstantTextField() {
        return multiplyConstantTextField;
    }

    public JTextField getMultiplyRowNumberTextField() {
        return multiplyRowNumberTextField;
    }

    public JLabel getMultiplyRowNumberLabel() {
        return multiplyRowNumberLabel;
    }
    
}
