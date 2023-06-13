
package GUI;

import Objects.Account;
import Objects.FileHandling;
import UI_Components.BdayField;
import UI_Components.InitialDepositField;
import UI_Components.NameField;
import UI_Components.PinField;
import UI_Components.RePinField;
import UI_Components.RoundLabel;
import UI_Components.SubmitButton;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Marin
 */
public final class Register extends JFrame{
    
    //Chekcers
    Boolean isSamePIN = false;
    Boolean isvalidDeposit = false;
    
    // Containers
    JFrame frame = new JFrame();    
    JPanel panel_container = new JPanel();
    
    // Color
    Color title_backgroundColor = new Color(232,199,102);
    Color title_foregroundColor = new Color(0,0,0);
    
    Color btn_backgroundColor = new Color(51,97,172);
    Color hover_btn_backgroundColor = new Color(22,47,101);
    Color click_btn_backgroundColor = new Color(51,97,172);
    
    Color btn_foregroundColor = new Color(255,255,255);
    Color hover_btn_foregroundColor = new Color(255,255,255);
    
    // Title Label
    RoundLabel title_label = new RoundLabel("Account Registration", title_backgroundColor, title_foregroundColor);
    
    // Text Fields
    NameField name_field = new NameField(frame,"Name",20);
    BdayField bday_field = new BdayField(frame,"Date of birth",8);
    InitialDepositField initial_deposit_field = new InitialDepositField(frame,"Initial Deposit (Min 10,000 PHP)",15);
    PinField pin_field = new PinField(frame,"4-digit PIN",4);
    RePinField repin_field = new RePinField(frame,pin_field,"Re-enter 4-digit PIN",4);
    JLabel ErrorMessage = new JLabel();
    
    // Button
    SubmitButton submit_btn = new SubmitButton(frame, "Continue",btn_backgroundColor,hover_btn_backgroundColor,click_btn_backgroundColor,btn_foregroundColor, hover_btn_foregroundColor);
    
    
    // Layout 
    GridBagLayout layout = new GridBagLayout();
    
    // Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    
    public Register(JFrame rootFrame)
    {
        setup_comp();
        setup_frame(rootFrame);
    }
    
    private static String generateAccountNumber() {
        Random random = new Random();
        int min = 100000;  // Minimum 6-digit number (100000)
        int max = 999999;  // Maximum 6-digit number (999999)
        int generatedNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(generatedNumber);
    }
    
    public void setup_comp() 
    {
        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231,230,221));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(40,0,150,0);
        
        gbc.gridx = 0;
        gbc.gridy = 7;      
        panel_container.add(title_label,gbc);
        
        
        gbc.insets.bottom = 10;
        gbc.insets.top = 10;
        gbc.gridx = 0;
        gbc.gridy = 8;      
        panel_container.add(name_field,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;      
        panel_container.add(bday_field,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;      
        panel_container.add(initial_deposit_field,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;      
        panel_container.add(pin_field,gbc);
        
        gbc.insets.bottom = 150;
        gbc.gridx = 0;
        gbc.gridy = 12;      
        panel_container.add(repin_field,gbc);
        
        gbc.insets.bottom = 20;
        gbc.gridx = 0;
        gbc.gridy = 13;   
        gbc.anchor = GridBagConstraints.CENTER; // Alignment
        panel_container.add(ErrorMessage,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 14;      
        panel_container.add(submit_btn,gbc);
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String PIN = new String(pin_field.getPassword());
                    String rePIN = new String(repin_field.getPassword());

                    if(!PIN.equals(rePIN)){
                        ErrorMessage.setText("Pin does not match!");
                        return;
                    }
                    isSamePIN = true;
                    
                    if(!(Double.parseDouble(initial_deposit_field.getText()) >= 10000)){
                        ErrorMessage.setText("Invalid Initial Deposit!");
                        return;
                    }
                    
                    isvalidDeposit = true;
                            
                    if(isSamePIN && isvalidDeposit){
                        Account account = new Account(name_field.getText(), generateAccountNumber(), bday_field.getText(), PIN, "", Double.parseDouble(initial_deposit_field.getText()));
                        FileHandling filehandler = new FileHandling();
                        
                        filehandler.saveToFile(account);
                        AccSuccess success = new AccSuccess(frame, account);

                    }else{
                        return;
                    }
                    
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
