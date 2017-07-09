/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srf;

import java.io.FileNotFoundException;
import srf.SRF;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JiJi
 */
public class SRFMainWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public int keyPressCount = 0;
    public SRFMainWindow() {
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

        filenameLable = new javax.swing.JLabel();
        filenameInput = new javax.swing.JTextField();
        strictToggleLable = new javax.swing.JLabel();
        strictButton = new javax.swing.JToggleButton();
        inputBox = new javax.swing.JTextField();
        goLabel = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputBox = new javax.swing.JEditorPane();
        commentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filenameLable.setText("Filename:");

        filenameInput.setText("filename.txt");
        filenameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameInputActionPerformed(evt);
            }
        });

        strictToggleLable.setText("Demo");

        strictButton.setText("Enabled");
        strictButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strictButtonActionPerformed(evt);
            }
        });

        inputBox.setText("Input, split each word with \";\" or semi-colon");
        inputBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputBoxMouseClicked(evt);
            }
        });

        goLabel.setText("Press to Run");

        goButton.setText("GO!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(outputBox);

        commentLabel.setText("Comment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addComponent(inputBox)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filenameLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filenameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(strictToggleLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(strictButton)
                                .addGap(127, 127, 127)
                                .addComponent(goLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goButton))
                            .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filenameLable)
                    .addComponent(filenameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strictToggleLable)
                    .addComponent(strictButton)
                    .addComponent(goLabel)
                    .addComponent(goButton))
                .addGap(1, 1, 1)
                .addComponent(commentLabel)
                .addGap(3, 3, 3)
                .addComponent(inputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filenameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filenameInputActionPerformed

    private void strictButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strictButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strictButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        String inputText = inputBox.getText();
        ArrayList<String> inputStrings = new ArrayList(Arrays.asList(inputText.split(";")));
        
        try{
            outputBox.setText(SRF.getText(filenameInput.getText(),inputStrings,strictButton.isSelected()));
        } catch (FileNotFoundException fnfee){
            System.out.println("File not found trying the formats folder");
            try{
            outputBox.setText(SRF.getText("formats/"+filenameInput.getText(),inputStrings,strictButton.isSelected()));
            fnfee.printStackTrace();
            } catch (Exception snf){
                snf.printStackTrace();
            }
        } catch( Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void inputBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputBoxMouseClicked
        // TODO add your handling code here:
        inputBox.setText("");
    }//GEN-LAST:event_inputBoxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SRFMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SRFMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SRFMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SRFMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SRFMainWindow().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel commentLabel;
    private javax.swing.JTextField filenameInput;
    private javax.swing.JLabel filenameLable;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel goLabel;
    public javax.swing.JTextField inputBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane outputBox;
    private javax.swing.JToggleButton strictButton;
    private javax.swing.JLabel strictToggleLable;
    // End of variables declaration//GEN-END:variables
}
