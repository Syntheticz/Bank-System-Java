/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import GUI.Register;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Manuel Marin
 */
public class RegisterButton extends RoundButton
{
    
    public RegisterButton(JFrame rootFrame, String text, Color defaultBackgroundColor, Color hoverBackgroundColor, Color clickBackgroundColor, Color defaultForegroundColor, Color hoverForegroundColor) {
        super(rootFrame, text, defaultBackgroundColor, hoverBackgroundColor, clickBackgroundColor, defaultForegroundColor, hoverForegroundColor);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setColorEffect(getHoverBackgroundColor());
                setFontColorEffect(getHoverForegroundColor());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setColorEffect(getDefaultBackgroundColor());
                setFontColorEffect(getDefaultForegroundColor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setColorEffect(getClickBackgroundColor());
                Register register_panel = new Register(rootFrame);
                
                
                if (rootFrame.isVisible()) {
                    rootFrame.setVisible(false);
                }
            }
        });
    }
    
    
    
    
}