package com.example.battleship.view;

import com.example.battleship.controller.GameController;
import com.example.battleship.model.Board;
import com.example.battleship.model.utils.Path;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * GameView class for displaying the main game window in the Battleship game.
 * Manages the loading of the FXML layout, initialization of the controller, and provides access to the controller and singleton instance.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class GameView extends Stage {
    /**
     * The controller associated with this view.
     */
    private GameController gameController;

    /**
     * Constructor for GameView. Loads the FXML layout and initializes the controller.
     *
     * @param machineBoard the game board for the machine
     * @param playerBoard the game board for the player
     * @throws IOException if the FXML file cannot be loaded
     */
    public GameView(Board machineBoard, Board playerBoard) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.GAME_VIEW));
        Parent root = loader.load();
        this.gameController = loader.getController();
        this.gameController.setBoards(machineBoard, playerBoard);
        this.setTitle("Battle Ship");
        Scene scene = new Scene(root);
        //this.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/battleship/images/yate.png")));
        this.setScene(scene);
        this.show();
    }

    /**
     * Gets the controller associated with this view.
     *
     * @return the GameController instance
     */
    public GameController getGameController() {
        return this.gameController;
    }

    /**
     * Gets the singleton instance of GameView.
     *
     * @param machineBoard the game board for the machine
     * @param playerBoard the game board for the player
     * @return the singleton instance of GameView
     * @throws IOException if the FXML file cannot be loaded
     */
    public static GameView getInstance(Board machineBoard, Board playerBoard) throws IOException {
        return GameViewHolder.INSTANCE = new GameView(machineBoard,playerBoard);
    }

    /**
     * Holder class for the singleton instance of GameView.
     */
    private static class GameViewHolder {
        private static GameView INSTANCE;
    }
}
