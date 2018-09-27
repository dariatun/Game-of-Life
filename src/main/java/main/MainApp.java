package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static main.GameVariables.IS_PLAYING;
import java.util.EnumMap;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author dariatunina
 */
public class MainApp extends Application {
    private GameCanvas gameCanvas;
    private GameLoopHandler gameLoopHandler;
    private UserManupilation userManupilation;
    private EnumMap<GameVariables, Boolean> gameVariables;
    private MyField field; 
    
    @Override
    public void init() {
        field = new MyField();
        gameVariables = new EnumMap<>(GameVariables.class);
        gameCanvas = new GameCanvas(gameVariables, field);
        userManupilation = new UserManupilation(gameVariables, field);
        gameLoopHandler = new GameLoopHandler(gameCanvas, gameVariables, field);
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.getChildren().add(gameCanvas);
        gameCanvas.fixAspectRatio();
        Scene scene = new Scene(pane);
        scene.setOnMousePressed(userManupilation);
        scene.setOnMouseReleased(userManupilation);
        scene.setOnMouseDragged(userManupilation);
        scene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                gameVariables.put(IS_PLAYING, true);
            }
        });
        stage.setScene(scene);
        final KeyFrame keyFrame = new KeyFrame(
                Duration.millis(1000 / 10), gameLoopHandler);
        final Timeline tl = new Timeline(keyFrame);
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
