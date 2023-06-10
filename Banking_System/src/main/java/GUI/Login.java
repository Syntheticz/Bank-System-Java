/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import UI_Components.AccNumField;
import UI_Components.PinField;
import UI_Components.RePinField;
import UI_Components.RoundLabel;
import UI_Components.SubmitButton;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    Color btn_backgroundColor = new Color(51,97,172);
    Color hover_btn_backgroundColor = new Color(22,47,101);
    Color click_btn_backgroundColor = new Color(51,97,172);
    
    Color btn_foregroundColor = new Color(255,255,255);
    Color hover_btn_foregroundColor = new Color(255,255,255);
    
    // Title Label
    RoundLabel title_label = new RoundLabel("Log-in Account", title_backgroundColor, title_foregroundColor);
    
    // Text Fields
    AccNumField acc_num_field = new AccNumField(frame, "Account Number",20);
    PinField pin_field = new PinField(frame,"4-digit PIN",4);
    RePinField repin_field = new RePinField(frame,pin_field,"Re-enter 4-digit PIN",4);
    
    // Button
    SubmitButton submit_btn = new SubmitButton(frame, "Continue",btn_backgroundColor,hover_btn_backgroundColor
            ,click_btn_backgroundColor,btn_foregroundColor, hover_btn_foregroundColor);
    
    // Layout 
    GridBagLayout layout = new GridBagLayout();
    
    // Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    public Login()
    {
        setup_comp();
        setup_frame();
    }
    
    public void setup_comp() 
    {
        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231,230,221));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,10,10,10);
        
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
        panel_container.add(submit_btn,gbc);
               
    }
    
    public void setup_frame()
    {
        frame.add(panel_container);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}
