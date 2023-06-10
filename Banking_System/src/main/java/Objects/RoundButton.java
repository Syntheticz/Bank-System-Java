
package Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class RoundButton extends JButton {
    private final int radius = 30;
    private final Color defaultBackgroundColor;
    private final Color hoverBackgroundColor;
    private final Color clickBackgroundColor;
    private final Color defaultForegroundColor;
    private final Color hoverForegroundColor;
    private final Color clickForegroundColor;
    private final Font font = new Font("Sans Serif", Font.PLAIN, 14);
    

    public RoundButton(String text, Color defaultBackgroundColor, Color hoverBackgroundColor, Color clickBackgroundColor,
                       Color defaultForegroundColor, Color hoverForegroundColor, Color clickForegroundColor) {
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
        this.clickForegroundColor = clickForegroundColor;
        
      

     

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                    setBackground(hoverBackgroundColor);
                    setForeground(hoverForegroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackgroundColor);
                    setForeground(defaultForegroundColor);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(clickBackgroundColor);
                setForeground(clickForegroundColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        int width = getWidth();
        int height = getHeight();

        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g2.setColor(getForeground()); // Set the current foreground color
        FontMetrics fontMetrics = g2.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(getText());
        int textHeight = fontMetrics.getHeight();
        int textX = x + (diameter - textWidth) / 2;
        int textY = y + (diameter - textHeight) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
}