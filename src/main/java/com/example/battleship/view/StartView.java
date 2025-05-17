package com.example.battleship.view;

import com.example.battleship.controller.StartController;
import com.example.battleship.model.utils.Path;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView extends Stage {
    private StartController startController;

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

    private static class StartViewHolder {
        private static StartView INSTANCE;
    }

    public static StartView getInstance() throws IOException {
        if (StartViewHolder.INSTANCE == null) {
            return StartViewHolder.INSTANCE = new StartView();
        } else {
            return StartViewHolder.INSTANCE;
        }
    }

    public static void deleteInstance() {
        StartViewHolder.INSTANCE.close();
        StartViewHolder.INSTANCE = null;
    }


}
