/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_Components;

import com.toedter.calendar.JCalendar;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

/**
 *
 * @author Manuel Marin
 */
public class BdayField extends TextField
{
    
    public BdayField(JFrame frame, String placeholder, int col) {
        super(frame, placeholder, col);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                JCalendar calendar = new JCalendar();
                JPopupMenu popup = new JPopupMenu();
                popup.add(calendar);
        
                // Set the position of the popup relative to the text field
                popup.show(getField(), 0, getHeight());
                
                calendar.addPropertyChangeListener("calendar", (PropertyChangeEvent evt) -> {
                    if (evt.getNewValue() instanceof Calendar selectedDate) {
                        Date date = selectedDate.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(date);
                        setText(formattedDate);
                        popup.setVisible(false);
                    }
                });
            }
        });
    }
    
}
