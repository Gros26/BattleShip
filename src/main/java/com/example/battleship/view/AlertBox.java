package com.example.battleship.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * AlertBox class for displaying alert and confirmation dialogs in the Battleship game.
 * Implements the IAlert interface to provide standardized alert functionality.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class AlertBox implements IAlert{

    /**
     * Enum representing the types of alerts that can be shown.
     */
    public enum AlertType {
        INFORMATION,
        ERROR
    }

    /**
     * Shows an alert dialog with the specified title, header, message, and alert type.
     *
     * @param title the title of the alert dialog
     * @param header the header text of the alert dialog
     * @param message the message content of the alert dialog
     * @param type the type of alert (information or error)
     */
    @Override
    public void showAlert(String title, String header, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Shows a confirmation dialog with the specified title and message.
     *
     * @param title the title of the confirmation dialog
     * @param message the message content of the confirmation dialog
     * @return true if the user confirms, false otherwise
     */
    public boolean showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType buttonTypeYes = new ButtonType("Si");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == buttonTypeYes;
    }
}
