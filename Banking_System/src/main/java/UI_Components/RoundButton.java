/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;


/**
 *
 * @author Manuel Marin
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RoundButton extends JButton 
{
    private final int radius = 30;
    private Color defaultBackgroundColor = null;
    private Color hoverBackgroundColor = null;
    private Color clickBackgroundColor = null;
    private Color defaultForegroundColor = null;
    private Color hoverForegroundColor = null;
    
    private Color colorEffect;
    private Color fontColorEffect;
    
    private final Font font = new Font("Sans Serif",Font.PLAIN,36);

    public RoundButton(JFrame rootFrame, String text, Color defaultBackgroundColor, Color hoverBackgroundColor, Color clickBackgroundColor,
                       Color defaultForegroundColor, Color hoverForegroundColor)
    {
        super(text);
        setFont(font);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        
        
        this.defaultBackgroundColor = defaultBackgroundColor;
        this.hoverBackgroundColor = hoverBackgroundColor;
        this.clickBackgroundColor = clickBackgroundColor;
        this.defaultForegroundColor = defaultForegroundColor;
        this.hoverForegroundColor = hoverForegroundColor;
        
        // Setting default color
        this.colorEffect = defaultBackgroundColor;
        this.fontColorEffect = defaultForegroundColor;
    }   
    
    public RoundButton(JFrame rootFrame, String text)
    {
        super(text);
        setFont(font);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);        
    }   
    
    // Getters
    public Color getDefaultBackgroundColor() { return defaultBackgroundColor; }
    public Color getHoverBackgroundColor() { return hoverBackgroundColor; }
    public Color getClickBackgroundColor() { return clickBackgroundColor; }
    
    public Color getHoverForegroundColor() { return hoverForegroundColor; }
    public Color getDefaultForegroundColor() { return defaultForegroundColor; }
    
    public void setColorEffect(Color color) { colorEffect = color; }
    public void setFontColorEffect(Color color) { fontColorEffect = color; }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(colorEffect);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        int width = getWidth();
        int height = getHeight();
     
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g2.setColor(fontColorEffect);
        FontMetrics fontMetrics = g2.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(getText());
        int textHeight = fontMetrics.getHeight();
        int textX = x + (diameter - textWidth) / 2;
        int textY = y + (diameter - textHeight) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }

  
}

   
    
    