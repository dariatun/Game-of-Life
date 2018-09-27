package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static main.GameVariables.*;
import java.awt.Color;
import java.util.EnumMap;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

/**
 *
 * @author dariatunina
 */
public class GameCanvas extends Canvas {

    private final EnumMap gameVar;
    private final MyField field;

    public GameCanvas(EnumMap gameVar, MyField field) {
        this.gameVar = gameVar;
        this.field = field;
    }

    public void fixAspectRatio() {
        Parent parent = getParent();
        if (parent instanceof Pane) {
            widthProperty().bind(((Pane) getParent()).widthProperty());
            heightProperty().bind(((Pane) getParent()).heightProperty());
        }
    }

    public void redraw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, 1024, 768);
        field.draw(gc);
        //field.printCells();
    }
}
