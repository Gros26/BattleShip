package com.example.battleship.view;

import javafx.scene.control.Alert;

public interface IAlert {
    public void showAlert(String title, String header, String message, Alert.AlertType Type);
}

