/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import GUI.AccSuccess;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
/**
 *
 * @author Manuel Marin
 */
public class BackButton extends RoundButton {
    
    Color defaultForegroundColor = new Color(255,255,255);
    Color defaultBackgroundColor = new Color(93,93,93);
    
    Color hoverForegroundColor = new Color(0,0,0);
    Color hoverBackgroundColor = new Color(160,162,166);
    
    
    public BackButton(JFrame rootFrame, String text) {
        super(rootFrame, text);
       
        setColorEffect(defaultBackgroundColor);
        setFontColorEffect(defaultForegroundColor);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setColorEffect(hoverBackgroundColor);
                setFontColorEffect(hoverForegroundColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setColorEffect(defaultBackgroundColor);
                setFontColorEffect(defaultForegroundColor);
            }
        });
    }
}

