package com.example.battleship;

import com.example.battleship.model.*;
import com.example.battleship.view.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class for launching the Battleship game application using JavaFX.
 * This class serves as the entry point for the application and initializes the main view.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class Main extends Application {
    /**
     * Main method to launch the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the primary stage of the application and loads the initial view.
     *
     * @param primaryStage the primary stage for this application
     * @throws IOException if the initial view cannot be loaded
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        StartView.getInstance();
    }
}
