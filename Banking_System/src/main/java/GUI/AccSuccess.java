/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

//import com.mycompany.banking_system.Banking_System;
import UI_Components.RoundLabel;
import UI_Components.TransactionButton;
import Objects.Account;
import UI_Components.ExitBtn;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author simon
 */
public final class AccSuccess {
    // Containers
    JFrame frame = new JFrame();
    JPanel panel_container = new JPanel();
    // Color
    Color title_backgroundColor = new Color(232,199,102);
    Color title_foregroundColor = new Color(0,0,0);
    Color no_backgroundColor = new Color(231,230,221);
    
    Color btn_backgroundColor = new Color(51,97,172);
    Color hover_btn_backgroundColor = new Color(22,47,101);
    Color click_btn_backgroundColor = new Color(51,97,172);
    
    Color btn_foregroundColor = new Color(255,255,255);
    Color hover_btn_foregroundColor = new Color(255,255,255);
    
    // Layout 
    GridBagLayout layout = new GridBagLayout();
    
    // Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Labels
    RoundLabel title_label = new RoundLabel("Account successfully opened!", no_backgroundColor, title_foregroundColor);
    RoundLabel name_label = new RoundLabel("Name:", no_backgroundColor, title_foregroundColor);
    RoundLabel accNum_label = new RoundLabel("Account Number:", no_backgroundColor, title_foregroundColor);
    RoundLabel dob_label = new RoundLabel("Birthdate:", no_backgroundColor, title_foregroundColor);
    RoundLabel balance_label = new RoundLabel("Balance:", no_backgroundColor, title_foregroundColor);
    
    //Button
    ExitBtn exit_btn = new ExitBtn(frame,"Exit",btn_backgroundColor,hover_btn_backgroundColor,click_btn_backgroundColor,btn_foregroundColor, hover_btn_foregroundColor);
    TransactionButton transaction_btn = new TransactionButton(frame, "Proceed to Transaction", btn_backgroundColor, hover_btn_backgroundColor, click_btn_backgroundColor, btn_foregroundColor, hover_btn_foregroundColor);

    //Account acc = new Account();
    //String name = acc.getName();
    
    private Account account;
    
    public AccSuccess(JFrame rootFrame, Account account)
    {
        this.account = account;
        setup_comp();
        setup_frame(rootFrame);
    }
    

    public void setup_comp()
    {
        Account acc = account;
//           acc.setName("Philip");
//           acc.setAccountBalance(69421.69);
//           acc.setAccountNumber("123456");
//           acc.setEncryptedAccountBalance("66969696");
//           acc.setDateOfBirth("12-07-2001");
//           acc.setPin("1234");
        
        RoundLabel namelb = new RoundLabel(acc.getName(), title_backgroundColor, title_foregroundColor);
        RoundLabel accNumlb = new RoundLabel(acc.getAccountNumber(), title_backgroundColor, title_foregroundColor);
        RoundLabel doblb = new RoundLabel(acc.getDateOfBirth(), title_backgroundColor, title_foregroundColor);
        RoundLabel balancelb = new RoundLabel(Double.toString(acc.getAccountBalance()), title_backgroundColor, title_foregroundColor);


        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231,230,221));
        
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0,0,100,0);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel_container.add(title_label,gbc);
        
        gbc.insets.bottom = 5;
        gbc.insets.top = 5;
        gbc.gridx = 0;
        gbc.gridy = 5;      
        panel_container.add(name_label,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;      
        panel_container.add(namelb,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;      
        panel_container.add(accNum_label,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;      
        panel_container.add(accNumlb,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;      
        panel_container.add(dob_label,gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;      
        panel_container.add(doblb,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;      
        panel_container.add(balance_label,gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;      
        panel_container.add(balancelb,gbc);
        
        gbc.insets.top = 100;
        gbc.gridx = 1;
        gbc.gridy = 10;
        panel_container.add(exit_btn, gbc);
        
        gbc.insets.top = 100;
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel_container.add(transaction_btn, gbc);

        transaction_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transaction transaction = new Transaction(account);
                transaction.setVisible(true);
                transaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();
            }
        });
        
        
    }
    
    
    public void setup_frame(JFrame rootFrame)
    {
        frame.add(panel_container);
        
        frame.setSize(rootFrame.getSize());
        frame.setLocation(rootFrame.getLocation());
       
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
