package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static main.GameVariables.IS_PLAYING;
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
