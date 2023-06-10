/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import UI_Components.ExitBtn;
import UI_Components.LoginButton;
import UI_Components.RegisterButton;
import UI_Components.RoundLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;  
/**
 *
 * @author Manuel Marin
 */
public final class Main_Menu {
    
    // Colors
    Color title_backgroundColor = new Color(232,199,102);
    Color title_foregroundColor = new Color(0,0,0);
    
    Color btn_backgroundColor = new Color(231,230,221);
    Color hover_btn_background = new Color(22,47,101);
    Color click_btn_background = new Color(22,47,101);
    
    Color btn_foregroundColor = new Color(0,0,0);
    Color hover_btn_foregroundColor = new Color(255,255,255);
    // Containers
    JFrame frame = new JFrame();    
    JPanel panel_container = new JPanel();
    
    // Title Label
    RoundLabel title_label = new RoundLabel("Welcome to OurBank!",title_backgroundColor, title_foregroundColor);
    
    // Buttons
    RegisterButton register_btn = new RegisterButton(frame,"Register New Account",btn_backgroundColor,hover_btn_background,click_btn_background,btn_foregroundColor, hover_btn_foregroundColor);
    LoginButton login_btn = new LoginButton(frame,"Log-in Existing Account",btn_backgroundColor,hover_btn_background,click_btn_background,btn_foregroundColor, hover_btn_foregroundColor);
    ExitBtn exit_btn = new ExitBtn(frame,"Exit",btn_backgroundColor,hover_btn_background,click_btn_background,btn_foregroundColor, hover_btn_foregroundColor);
    
    // Layout 
    GridBagLayout layout = new GridBagLayout();
    
    // Layout Constraint
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    public Main_Menu()
    {  
        setup_comp();
        setup_frame();
    }
    
      
    public void setup_comp()
    {
        panel_container.setLayout(layout);
        panel_container.setBackground(new Color(231,230,221));
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,150,0); // sets bottom gap between title and button
       
        gbc.gridx = 0;
        gbc.gridy = 0;   
        panel_container.add(title_label,gbc);
        
        gbc.insets.bottom = 30;     // sets bottom gap between buttons
        gbc.gridx = 0;
        gbc.gridy = 7;        
        panel_container.add(register_btn,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel_container.add(login_btn,gbc);
                
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel_container.add(exit_btn,gbc);
        
    }
    
    public void setup_frame()
    {        
        frame.add(panel_container);
        frame.setSize(1440,1024);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
            
            
 
}
