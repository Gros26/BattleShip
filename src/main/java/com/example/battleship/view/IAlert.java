package com.example.battleship.view;

import javafx.scene.control.Alert;

/**
 * IAlert interface for displaying alert dialogs in the Battleship game.
 * Provides a method signature for showing alerts with customizable content and type.
 *
 * @author Grosman Garcia
 * @version 1
 */
public interface IAlert {
    /**
     * Shows an alert dialog with the specified title, header, message, and alert type.
     *
     * @param title the title of the alert dialog
     * @param header the header text of the alert dialog
     * @param message the message content of the alert dialog
     * @param Type the type of alert (information, error, etc.)
     */
    public void showAlert(String title, String header, String message, Alert.AlertType Type);
}

