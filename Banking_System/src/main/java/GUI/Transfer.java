
package GUI;

/**
 *
 * @author philip
 */

import Objects.Account;
import Objects.FileHandling;
import java.awt.Color;
import java.text.DecimalFormat;


public class Transfer extends javax.swing.JFrame {
    
    private Account account;
    private Boolean isEnteringPin = false;
    
    
    
    public Transfer(Account account) {
        this.account = account;
        
        initComponents();
        pinLabel.setVisible(true);
        pinField.setVisible(true);
    }
    
    public Transfer(){
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

        backToTransaction = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221));
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        errorMessage1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        balance = new Objects.RoundLabel("test", new Color(232, 199, 102), Color.white);
        jLabel3 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        amountToTransferField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        accountNumberField = new javax.swing.JTextField();
        pinLabel = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        pinField = new javax.swing.JPasswordField();
        jLabel42 = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        submitbtn = new UI_Components.SubmitButton(null, "Submit")
        ;
        jLabel45 = new javax.swing.JLabel();
        backbtn = new UI_Components.BackButton(null, "Back To Transaction Menu")
 ;

        backToTransaction.setBackground(new java.awt.Color(51, 97, 172));
        backToTransaction.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        backToTransaction.setForeground(java.awt.Color.white);
        backToTransaction.setText("Back");
        backToTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToTransactionActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deposit");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(231, 230, 221));
        setPreferredSize(new java.awt.Dimension(1440, 1024));
        setSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(231, 230, 221));
        jPanel1.setLayout(new java.awt.GridLayout(9, 3));
        jPanel1.add(jLabel47);
        jPanel1.add(jLabel49);
        jPanel1.add(jLabel50);
        jPanel1.add(jLabel46);

        errorMessage1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        errorMessage1.setForeground(new java.awt.Color(232, 199, 102));
        errorMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage1.setText("Transfer");
        errorMessage.setText("");
        jPanel1.add(errorMessage1);
        jPanel1.add(jLabel48);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Current Balance:");
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel41);

        balance.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setText(" 69420.00");
        balance.setVerifyInputWhenFocusTarget(false);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String formattedValue = decimalFormat.format(account.getAccountBalance());

        balance.setText("₱" + formattedValue);
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

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Receivers Account No. :");
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel43);

        amountToTransferField.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        amountToTransferField.setForeground(new java.awt.Color(99, 100, 102));
        amountToTransferField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        UI_Components.amountValidate validator = new UI_Components.amountValidate();
        validator.validate(amountToTransferField);
        amountToTransferField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountToTransferFieldActionPerformed(evt);
            }
        });
        jPanel1.add(amountToTransferField);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Enter Amount to Transfer:");
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel39);

        accountNumberField.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        accountNumberField.setForeground(new java.awt.Color(99, 100, 102));
        accountNumberField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        accountNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberFieldActionPerformed(evt);
            }
        });
        jPanel1.add(accountNumberField);

        pinLabel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        pinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pinLabel.setText("Enter PIN:");
        pinLabel.setVisible(false);
        jPanel1.add(pinLabel);
        jPanel1.add(jLabel40);

        UI_Components.PinValidator pinValidator = new UI_Components.PinValidator();
        pinField.setVisible(false);
        pinValidator.validatePin(pinField);
        pinField.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        pinField.setForeground(new java.awt.Color(99, 100, 102));
        jPanel1.add(pinField);
        jPanel1.add(jLabel42);

        errorMessage.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Error");
        errorMessage.setText("");
        jPanel1.add(errorMessage);
        jPanel1.add(jLabel44);

        submitbtn.setBackground(new java.awt.Color(51, 97, 172));
        submitbtn.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        submitbtn.setForeground(java.awt.Color.white);
        submitbtn.setText("Submit");
        submitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitbtnMouseExited(evt);
            }
        });
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitbtn);
        jPanel1.add(jLabel45);

        backbtn.setBackground(new java.awt.Color(93, 93, 93));
        backbtn.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        backbtn.setForeground(java.awt.Color.white);
        backbtn.setText("Back To Transaction Menu");
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backbtnMouseExited(evt);
            }
        });
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        jPanel1.add(backbtn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTransactionActionPerformed

    }//GEN-LAST:event_backToTransactionActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        Transaction transaction = new Transaction(account);
        transaction.setVisible(true);
        transaction.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        double amount = Double.parseDouble(amountToTransferField.getText());
        FileHandling fileHandler = new FileHandling();

        Account receiver = fileHandler.fetchAccount(accountNumberField.getText());

        if(receiver == null){
            errorMessage.setText("Account not found!");
            return;
        }

        if(isEnteringPin && amount >= 100){
            Account temp = fileHandler.fetchAccount(account.getAccountNumber());

            String PIN = new String(pinField.getPassword());

            if(temp != null){
                if(temp.getPin().equals(PIN)){
                    account.transfer(receiver, amount);

                    Receipt receipt = new Receipt(account, "Transfer", amountToTransferField.getText());
                    receipt.setVisible(true);
                    receipt.setDefaultCloseOperation(EXIT_ON_CLOSE);
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


        isEnteringPin = true;
    }//GEN-LAST:event_submitbtnActionPerformed

    private void accountNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNumberFieldActionPerformed

    private void amountToTransferFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountToTransferFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountToTransferFieldActionPerformed

    private void balanceAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_balanceAncestorAdded

    }//GEN-LAST:event_balanceAncestorAdded

    
    private void backbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseEntered
        Color hoverForegroundColor = new Color(0,0,0);
        Color hoverBackgroundColor = new Color(160,162,166);
        
        this.setBackground(hoverBackgroundColor);
        this.setForeground(hoverForegroundColor);
    }//GEN-LAST:event_backbtnMouseEntered

    private void backbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseExited
        Color defaultForegroundColor = new Color(255,255,255);
        Color defaultBackgroundColor = new Color(93,93,93);
        
        this.setBackground(defaultBackgroundColor);
        this.setForeground(defaultForegroundColor);
    }//GEN-LAST:event_backbtnMouseExited

    private void submitbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbtnMouseEntered
        Color hoverForegroundColor = new Color(255,255,255);
        Color hoverBackgroundColor = new Color(22,47,101);
        this.setBackground(hoverBackgroundColor);
        this.setForeground(hoverForegroundColor);
    }//GEN-LAST:event_submitbtnMouseEntered

    private void submitbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbtnMouseExited
        Color defaultForegroundColor = new Color(255,255,255);
        Color defaultBackgroundColor = new Color(51,97,172);
        this.setBackground(defaultBackgroundColor);
        this.setForeground(defaultForegroundColor);
    }//GEN-LAST:event_submitbtnMouseExited

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumberField;
    private javax.swing.JTextField amountToTransferField;
    private javax.swing.JButton backToTransaction;
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel errorMessage1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pinField;
    private javax.swing.JLabel pinLabel;
    private javax.swing.JButton submitbtn;
    // End of variables declaration//GEN-END:variables
}
