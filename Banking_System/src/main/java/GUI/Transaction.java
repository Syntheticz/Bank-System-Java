
package GUI;

import Objects.Account;
import java.awt.Color;



/**
 *
 * @author philip
 */
public class Transaction extends javax.swing.JFrame {

    private Account account;
    
    public Transaction(Account account){
        this.account = account;
        initComponents();
    }
    
    /**
     * Creates new form Transaction
     */
    public Transaction() {
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
        jLabel1 = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        welcomeLabel1 = new javax.swing.JLabel();
        withdrawButton = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221))
        ;
        depositButton = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221))
        ;
        transferButtton = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221))
        ;
        balanceInquiryButton = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221))
        ;
        toMenuButton = new Objects.RoundButton("", new Color(231, 230, 221), new Color(22, 47, 101), new Color(51, 97, 172), Color.BLACK, new Color(231, 230, 221), new Color(231, 230, 221))
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction Menu");
        setBackground(new java.awt.Color(231, 230, 221));
        setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        setSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(231, 230, 221));
        jPanel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(new java.awt.GridLayout(9, 1, 0, 4));
        jPanel1.add(jLabel1);

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(232, 199, 102));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("None");
        welcomeLabel.setText("Welcome " + account.getName());
        jPanel1.add(welcomeLabel);

        welcomeLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        welcomeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel1.setText("Please select transaction:");
        welcomeLabel.setText("Welcome " + account.getName());
        jPanel1.add(welcomeLabel1);

        withdrawButton.setBackground(new java.awt.Color(231, 230, 221));
        withdrawButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        withdrawButton.setText("Withdraw");
        withdrawButton.setBorder(null);
        withdrawButton.setBorderPainted(false);
        withdrawButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withdrawButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                withdrawButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                withdrawButtonMouseExited(evt);
            }
        });
        withdrawButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                withdrawButtonComponentShown(evt);
            }
        });
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        jPanel1.add(withdrawButton);

        depositButton.setBackground(new java.awt.Color(231, 230, 221));
        depositButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        depositButton.setText("Deposit");
        depositButton.setBorder(null);
        depositButton.setBorderPainted(false);
        depositButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        depositButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                depositButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                depositButtonMouseExited(evt);
            }
        });
        depositButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                depositButtonComponentShown(evt);
            }
        });
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });
        jPanel1.add(depositButton);

        transferButtton.setBackground(new java.awt.Color(231, 230, 221));
        transferButtton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        transferButtton.setText("Transfer");
        transferButtton.setBorder(null);
        transferButtton.setBorderPainted(false);
        transferButtton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transferButtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transferButttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transferButttonMouseExited(evt);
            }
        });
        transferButtton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                transferButttonComponentShown(evt);
            }
        });
        transferButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButttonActionPerformed(evt);
            }
        });
        jPanel1.add(transferButtton);

        balanceInquiryButton.setBackground(new java.awt.Color(231, 230, 221));
        balanceInquiryButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        balanceInquiryButton.setText("Balance Inquiry");
        balanceInquiryButton.setBorder(null);
        balanceInquiryButton.setBorderPainted(false);
        balanceInquiryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        balanceInquiryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                balanceInquiryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                balanceInquiryButtonMouseExited(evt);
            }
        });
        balanceInquiryButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                balanceInquiryButtonComponentShown(evt);
            }
        });
        balanceInquiryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceInquiryButtonActionPerformed(evt);
            }
        });
        jPanel1.add(balanceInquiryButton);

        toMenuButton.setBackground(new java.awt.Color(231, 230, 221));
        toMenuButton.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        toMenuButton.setText("Back to Main Menu");
        toMenuButton.setBorder(null);
        toMenuButton.setBorderPainted(false);
        toMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        toMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(toMenuButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        Withdraw withdraw = new Withdraw(this.account);
        withdraw.setVisible(true);
        withdraw.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void withdrawButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawButtonMouseEntered
    
    }//GEN-LAST:event_withdrawButtonMouseEntered

    private void withdrawButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawButtonMouseExited
       
    }//GEN-LAST:event_withdrawButtonMouseExited

    private void withdrawButtonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_withdrawButtonComponentShown
        
    }//GEN-LAST:event_withdrawButtonComponentShown

    private void depositButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositButtonMouseEntered
  
    }//GEN-LAST:event_depositButtonMouseEntered

    private void depositButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositButtonMouseExited
       
    }//GEN-LAST:event_depositButtonMouseExited

    private void depositButtonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_depositButtonComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_depositButtonComponentShown

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
      Deposit deposit = new Deposit(account);
      deposit.setVisible(true);
      deposit.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.dispose();
    }//GEN-LAST:event_depositButtonActionPerformed

    private void transferButttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferButttonMouseEntered
  
    }//GEN-LAST:event_transferButttonMouseEntered

    private void transferButttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferButttonMouseExited
        
    }//GEN-LAST:event_transferButttonMouseExited

    private void transferButttonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_transferButttonComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_transferButttonComponentShown

    private void transferButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButttonActionPerformed
        Transfer transfer = new Transfer(account);
        transfer.setVisible(true);
        transfer.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_transferButttonActionPerformed

    private void balanceInquiryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceInquiryButtonMouseEntered
    
    }//GEN-LAST:event_balanceInquiryButtonMouseEntered

    private void balanceInquiryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceInquiryButtonMouseExited
     
    }//GEN-LAST:event_balanceInquiryButtonMouseExited

    private void balanceInquiryButtonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_balanceInquiryButtonComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceInquiryButtonComponentShown

    private void balanceInquiryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceInquiryButtonActionPerformed
        BalanceInquiry balinq = new BalanceInquiry(account);
        balinq.setVisible(true);
        balinq.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_balanceInquiryButtonActionPerformed

    private void toMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMenuButtonActionPerformed
       Main_Menu main = new Main_Menu();
       this.dispose();
    }//GEN-LAST:event_toMenuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton balanceInquiryButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton toMenuButton;
    private javax.swing.JButton transferButtton;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeLabel1;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
