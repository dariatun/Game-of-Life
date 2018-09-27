/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

import static cz.cvut.fel.pjv.GameVariables.*;
import java.lang.reflect.Field;
import java.util.EnumMap;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author dariatunina
 */
public class GameLoopHandler implements EventHandler {

    private final GameCanvas gameCanvas;
    private EnumMap gameVar;
    private MyField field;

    public GameLoopHandler(GameCanvas gameCanvas, EnumMap gameVar, MyField field) {
        this.gameCanvas = gameCanvas;
        this.gameVar = gameVar;
        this.field = field;
    }

   
    @Override
    public void handle(Event event) {
        if (gameVar.get(IS_PLAYING) == Boolean.TRUE) {
            field.oneCycle();
        }
        gameCanvas.redraw();
    }

}
