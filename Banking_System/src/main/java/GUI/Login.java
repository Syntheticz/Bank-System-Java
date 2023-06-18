/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Objects.Account;
import Objects.FileHandling;
import UI_Components.AccNumField;
import UI_Components.PinField;
import UI_Components.RePinField;
import UI_Components.RoundLabel;
import UI_Components.SubmitButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Marin
 */
public final class Login {
    
    // Containers
    JFrame frame = new JFrame();    
    JPanel panel_container = new JPanel();
    
    // Color
    Color title_backgroundColor = new Color(232,199,102);
    Color title_foregroundColor = new Color(0,0,0);
    
    
    // Title Label
    RoundLabel title_label = new RoundLabel("  Log-in Account  ", title_backgroundColor, title_foregroundColor);
    JLabel ErrorMessage = new JLabel();
    
    // Text Fields
    AccNumField acc_num_field = new AccNumField(frame, "Account Number",20);
    PinField pin_field = new PinField(frame,"4-digit PIN",4);
    RePinField repin_field = new RePinField(frame,pin_field,"Re-enter 4-digit PIN",4);
    
    // Button
    SubmitButton submit_btn = new SubmitButton(frame, "Continue");
    
    
    
    // Layout 
    GridBagLayout layout = new GridBagLayout();
    
    // Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    public Login(JFrame rootFrame)
    {
        setup_comp();
        setup_frame(rootFrame);
    }
    
    public void setup_comp() 
    {
        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231,230,221));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,10,0);
        
        gbc.gridx = 0;
        gbc.gridy = 7;      
        panel_container.add(title_label,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 8;      
        panel_container.add(acc_num_field,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 9;      
        panel_container.add(pin_field,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;      
        panel_container.add(repin_field,gbc);
         
        gbc.gridx = 0;
        gbc.gridy = 11;      
        panel_container.add(ErrorMessage,gbc);
        ErrorMessage.setText("");
        
        gbc.gridx = 0;
        gbc.gridy = 12;      
        panel_container.add(submit_btn,gbc);
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileHandling filehandler = new FileHandling();                   
                String PIN = new String(pin_field.getPassword());
                String rePIN = new String(repin_field.getPassword());
                Account account = filehandler.fetchAccount(acc_num_field.getText());
                
                if(account == null){
                    ErrorMessage.setText("Accont not found!");
                    return;
                }
            
                if(!PIN.equals(rePIN)){
                    ErrorMessage.setText("PIN does not match!");
                    return;
                }
                
                if(!account.getPin().equals(PIN)){
                    ErrorMessage.setText("Wrong PIN");
                    return;
                }

                
                Transaction transaction = new Transaction(account);
                transaction.setVisible(true);
                transaction.setDefaultCloseOperation(3);
                frame.dispose();
            }
        });
        
               
    }
    
    public void setup_frame(JFrame rootFrame)
    {
        frame.add(panel_container);
        
        frame.setSize(1440,1024);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Calculate the center coordinates of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;

        // Set the frame's location to the center coordinates
        frame.setLocation(centerX, centerY);
        frame.setVisible(true);
    }
    
}
