/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

/**
 *
 * @author Manuel Marin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundLabel extends JLabel 
{
    private final int radius = 30;
    private final Color backgroundColor;
    private final Color foregroundColor;
    private final Font font = new Font("Sans Serif",Font.PLAIN,36);
        
    public RoundLabel(String text,Color backgroundColor, Color foregroundColor) 
    {
        super(text);        
        setOpaque(false);
        setFont(font);
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        int width = getWidth();
        int height = getHeight();
     
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g2.setColor(foregroundColor);
        FontMetrics fontMetrics = g2.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(getText());
        int textHeight = fontMetrics.getHeight();
        int textX = x + (diameter - textWidth) / 2;
        int textY = y + (diameter - textHeight) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
    
   
}
