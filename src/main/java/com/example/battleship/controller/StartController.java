package com.example.battleship.controller;

import com.example.battleship.model.Board;
import com.example.battleship.model.utils.Serialization;
import com.example.battleship.view.AlertBox;
import com.example.battleship.view.GameView;
import com.example.battleship.view.PlacementView;
import com.example.battleship.view.StartView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * StartController class for managing the start view and initial user interactions in the Battleship game.
 * Handles displaying information, checking for saved games, loading games, and starting new games.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class StartController {
    /**
     * Serialization utility for saving and loading game state.
     */
    private Serialization serialization;
    /**
     * Board representing the machine's ships and state.
     */
    private Board machineBoard;
    /**
     * Board representing the player's ships and state.
     */
    private Board playerBoard;

    /**
     * Handles the action event for displaying game information to the user.
     * Shows an alert with instructions about the Battleship game.
     *
     * @param event the ActionEvent triggered by the user
     */
    @FXML
    void onInformationButton(ActionEvent event) {
        new AlertBox().showAlert(
                "Instrucciones",
                "Bienvenido al juego Battle ship",
                "El juego llamado Battle ship es un juego de estrategia donde dos jugadores (humano y máquina) compiten por hundir la flota del oponente. Cada jugador coloca sus barcos en un tablero de coordenadas y luego intenta adivinar la ubicación de los barcos del oponente para hundirlos, el primero que derribe la flota del oponente gana la partida.",
                Alert.AlertType.INFORMATION
        );

    }
    /**
     * Checks for a saved game file and loads it if available and the user confirms.
     * If a saved game is found, prompts the user to continue or start a new game.
     */
    public void checkAndLoadGame() {
        serialization = new Serialization();
        String relativePath = serialization.getRelativePath();
        File saveFile = new File(relativePath);

        if (saveFile.exists() && saveFile.length() > 0) {
            AlertBox alertBox = new AlertBox();
            boolean confirmed = alertBox.showConfirmation("Confirmacion", "Se ha encontrado un juego guardado, Deseas continuar con el juego actual (si selecciona \"NO\" se iniciará un juego nuevo)");
            if (confirmed) {
                this.loadGame();
            }
        }
    }
    /**
     * Handles the action event for starting the game.
     * Prompts the user for confirmation and opens the placement view if confirmed.
     *
     * @param event the ActionEvent triggered by the user
     */
    @FXML
    void onPlayButton(ActionEvent event) {
        AlertBox alertBox = new AlertBox();
        boolean confirmed = alertBox.showConfirmation("Confirmacion", "¿Estas seguro que quieres comenzar a jugar?");
        if (confirmed)
        {
            try
            {
                PlacementView placementView = new PlacementView();
                placementView.show();
                StartView.deleteInstance();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * Loads the saved game state from file and opens the game view if successful.
     * If loading fails, prints the stack trace.
     */
    public void loadGame()
    {
        try
        {
            List<Object> objects = serialization.deserializeObjects(serialization.getRelativePath());
            if (objects.size() >= 2) {
                machineBoard = (Board) objects.get(0);
                playerBoard = (Board) objects.get(1);
                GameView gameView = new GameView(machineBoard, playerBoard);
                gameView.show();
                StartView.deleteInstance();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
