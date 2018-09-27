/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

import java.util.EnumMap;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author dariatunina
 */
public class UserManupilation implements EventHandler<MouseEvent> {
    private EnumMap gameVar;
    private boolean pressed;
    private MyField field;

    public UserManupilation(EnumMap gameVar, MyField field) {
        this.gameVar = gameVar;
        this.field = field;
        pressed = false;
    }
    
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED ||
                event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            pressed = true;
            field.setCell((int)event.getX(), (int)event.getY());
        }
        if (event.getEventType() == MouseEvent.MOUSE_RELEASED)
            pressed = false;
    }
    
    
    
}
