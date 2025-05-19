package com.example.battleship.view;

import com.example.battleship.controller.PlacementController;
import com.example.battleship.model.utils.Path;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * PlacementView class for displaying the ship placement window in the Battleship game.
 * Manages the loading of the FXML layout, initialization of the controller, and provides access to the controller and singleton instance.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class PlacementView extends Stage {
    /**
     * The controller associated with this view.
     */
    private PlacementController placementController;

    /**
     * Constructor for PlacementView. Loads the FXML layout and initializes the controller.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public PlacementView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.PLACEMENT_VIEW));
        Parent root = loader.load();
        this.placementController = loader.getController();
        this.setTitle("Battle Ship");
        Scene scene = new Scene(root);
        //this.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/battleship/images/yate.png")));
        this.setScene(scene);
        this.show();
    }

    /**
     * Gets the controller associated with this view.
     *
     * @return the PlacementController instance
     */
    public PlacementController getPlacementController() {
        return this.placementController;
    }

    /**
     * Gets the singleton instance of PlacementView.
     *
     * @return the singleton instance of PlacementView
     * @throws IOException if the FXML file cannot be loaded
     */
    public static PlacementView getInstance() throws IOException {
        return PlacementViewHolder.INSTANCE = new PlacementView();
    }

    /**
     * Holder class for the singleton instance of PlacementView.
     */
    private static class PlacementViewHolder {
        private static PlacementView INSTANCE;
    }
}
