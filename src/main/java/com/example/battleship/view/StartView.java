package com.example.battleship.view;

import com.example.battleship.controller.StartController;
import com.example.battleship.model.utils.Path;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * StartView class for displaying the start window in the Battleship game.
 * Manages the loading of the FXML layout, initialization of the controller, singleton instance management, and game loading.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class StartView extends Stage {
    /**
     * The controller associated with this view.
     */
    private StartController startController;

    /**
     * Constructor for StartView. Loads the FXML layout, initializes the controller, and checks for a saved game.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.START_VIEW));
        AnchorPane pane = loader.load();
        this.startController = loader.getController();
        this.setTitle("BattleShip");
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.show();
        this.startController.checkAndLoadGame();
    }

    /**
     * Holder class for the singleton instance of StartView.
     */
    private static class StartViewHolder {
        private static StartView INSTANCE;
    }

    /**
     * Gets the singleton instance of StartView, creating it if necessary.
     *
     * @return the singleton instance of StartView
     * @throws IOException if the FXML file cannot be loaded
     */
    public static StartView getInstance() throws IOException {
        if (StartViewHolder.INSTANCE == null) {
            return StartViewHolder.INSTANCE = new StartView();
        } else {
            return StartViewHolder.INSTANCE;
        }
    }

    /**
     * Deletes the singleton instance of StartView, closing the window if it exists.
     */
    public static void deleteInstance() {
        if (StartViewHolder.INSTANCE != null) {
            StartViewHolder.INSTANCE.close();
            StartViewHolder.INSTANCE = null;
        }
    }


}
