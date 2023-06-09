
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
public class SubmitButton extends RoundButton 
{   
    Color defaultForegroundColor = new Color(255,255,255);
    Color defaultBackgroundColor = new Color(51,97,172);
    
    Color hoverForegroundColor = new Color(255,255,255);
    Color hoverBackgroundColor = new Color(22,47,101);
    
    public SubmitButton(JFrame rootFrame, String text) {
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
