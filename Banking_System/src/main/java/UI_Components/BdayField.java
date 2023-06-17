/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import com.toedter.calendar.JCalendar;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author Manuel Marin
 */
public class BdayField extends TextField
{
    private boolean isClicked = false;
    public BdayField(JFrame frame, String placeholder, int col) {
        super(frame, placeholder, col);
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                setEditable(false);
                JCalendar calendar = new JCalendar();
                JDialog dialog = new JDialog();
                dialog.setUndecorated(true); // Remove window frame
                dialog.setType(Window.Type.UTILITY); // Set dialog type to utility
                dialog.setFocusableWindowState(false); // Make the dialog non-focusable
                dialog.getContentPane().add(calendar);
                dialog.pack();

                Point dialogPosition = SwingUtilities.convertPoint(BdayField.this, 0, getHeight(), getParent());
                dialog.setLocation(dialogPosition.x - dialog.getWidth() + 222, dialogPosition.y + 30);
                dialog.setVisible(true);

                // Keep track of the initially selected day
                Calendar initialSelectedDate = calendar.getCalendar();
                
                // prints out the output in calendar
                calendar.addPropertyChangeListener("calendar", (PropertyChangeEvent evt) -> {
                    if (evt.getNewValue() instanceof Calendar selectedDate) {
                        Calendar newSelectedDate = (Calendar) evt.getNewValue();

                        // Compare the day of the initially selected date with the day of the new selected date
                        boolean dayChanged = initialSelectedDate.get(Calendar.DAY_OF_MONTH) != newSelectedDate.get(Calendar.DAY_OF_MONTH);

                        if (dayChanged) {
                            dialog.setVisible(false);
                           
                        } else dialog.setVisible(true);

                        Date date = selectedDate.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(date);
                        setText(formattedDate);
                        
                    }
                });
                
                // hides the calendar if resizing
                Window parentWindow = SwingUtilities.getWindowAncestor(BdayField.this);
                parentWindow.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        dialog.setVisible(false); // Hide the dialog when the window is resized
                    }
                });
                
                
            }
    
    
        });
    }
}

