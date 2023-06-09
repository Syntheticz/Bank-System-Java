/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author philip
 */

import Objects.Account;
import Objects.FileHandling;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.JFrame;



public class Withdraw extends javax.swing.JFrame {
    
    private Account account;
    private Boolean isEnteringPin = false;
    
    
    
    public Withdraw(Account account) {
        this.account = account;
        
        initComponents();
        
        this.setSize(1440,1024);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Calculate the center coordinates of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;

        // Set the frame's location to the center coordinates
        this.setLocation(centerX, centerY);
    }
    
    public Withdraw(){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        errorMessage1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        balance = new Objects.RoundLabel("test", new Color(232, 199, 102), Color.white);
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        amountToWithdrawField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pinLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pinField = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        submitButton = new UI_Components.SubmitButton(null, "Submit");
        ;
        jLabel27 = new javax.swing.JLabel();
        backToTransaction = new UI_Components.BackButton(null, "Back To Transaction Menu");
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Withdraw");
        setSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(231, 230, 221));
        jPanel1.setLayout(new java.awt.GridLayout(8, 5));
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel8);
        jPanel1.add(jLabel9);

        errorMessage1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        errorMessage1.setForeground(new java.awt.Color(232, 199, 102));
        errorMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage1.setText("Withdraw");
        errorMessage.setText("");
        jPanel1.add(errorMessage1);
        jPanel1.add(jLabel11);
        jPanel1.add(jLabel12);
        jPanel1.add(jLabel13);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Current Balance:");
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel14);

        balance.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setText(" 69420.00");
        balance.setText("₱" + String.valueOf(Math.floor(account.getAccountBalance() * 100) / 100));
        balance.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                balanceAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(balance);
        jPanel1.add(jLabel15);
        jPanel1.add(jLabel16);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("Enter Amount to Withdaw:");
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel17);

        amountToWithdrawField.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        amountToWithdrawField.setForeground(new java.awt.Color(99, 100, 102));
        amountToWithdrawField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        UI_Components.amountValidate validator = new UI_Components.amountValidate();
        validator.validate(amountToWithdrawField);
        amountToWithdrawField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountToWithdrawFieldActionPerformed(evt);
            }
        });
        jPanel1.add(amountToWithdrawField);
        jPanel1.add(jLabel18);
        jPanel1.add(jLabel19);

        pinLabel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        pinLabel.setText("Enter PIN:");
        pinLabel.setVisible(false);
        jPanel1.add(pinLabel);
        jPanel1.add(jLabel23);

        UI_Components.PinValidator pinValidator = new UI_Components.PinValidator();
        pinField.setVisible(false);
        pinValidator.validatePin(pinField);
        pinField.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        pinField.setForeground(new java.awt.Color(99, 100, 102));
        jPanel1.add(pinField);
        jPanel1.add(jLabel20);
        jPanel1.add(jLabel21);
        jPanel1.add(jLabel22);

        errorMessage.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Error");
        errorMessage.setText("");
        jPanel1.add(errorMessage);
        jPanel1.add(jLabel24);
        jPanel1.add(jLabel25);
        jPanel1.add(jLabel26);

        submitButton.setBackground(new java.awt.Color(51, 97, 172));
        submitButton.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        submitButton.setForeground(java.awt.Color.white);
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitButton);
        jPanel1.add(jLabel27);

        backToTransaction.setBackground(new java.awt.Color(93, 93, 93));
        backToTransaction.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        backToTransaction.setForeground(java.awt.Color.white);
        backToTransaction.setText("Back");
        backToTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToTransactionActionPerformed(evt);
            }
        });
        jPanel1.add(backToTransaction);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void balanceAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_balanceAncestorAdded

    }//GEN-LAST:event_balanceAncestorAdded

    private void amountToWithdrawFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountToWithdrawFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountToWithdrawFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        double amount = Double.parseDouble(amountToWithdrawField.getText());

        if(isEnteringPin && amount >= 100){
            FileHandling fileHandler = new FileHandling();
            Account temp = fileHandler.fetchAccount(account.getAccountNumber());
            
            String PIN = new String(pinField.getPassword());
            
            if(temp != null){
                if(temp.getPin().equals(PIN)){
                    account.withdraw(amount);
                    
                    Receipt receipt = new Receipt(account, "Withdraw", amountToWithdrawField.getText());
                    Loading loading = new Loading(receipt);
                    loading.setVisible(true);
                    this.dispose();
                    
                    
                }else{
        
                    errorMessage.setText("Pin did not match!");
                }
            }else{
                errorMessage.setText("Record does Not Exist");

            }
        }
 
        if(amount < 100){
            errorMessage.setText("Amount is less than 100!");
            return;
        }
        
        pinLabel.setVisible(true);
        pinField.setVisible(true);
        isEnteringPin = true;
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backToTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTransactionActionPerformed
        Transaction transaction = new Transaction(account);
        transaction.setVisible(true);
        transaction.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backToTransactionActionPerformed

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
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountToWithdrawField;
    private javax.swing.JButton backToTransaction;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel errorMessage1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pinField;
    private javax.swing.JLabel pinLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
