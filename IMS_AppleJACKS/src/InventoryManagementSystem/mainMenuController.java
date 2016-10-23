package InventoryManagementSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Joe_Mejica on 10/22/16.
 */
public class mainMenuController {

    @FXML
    public Button signOutIMS;

    @FXML
    public Button mainMenuBtn;


    Stage stage;
    Parent root;


    public void signOut(ActionEvent actionEvent) throws IOException {

        stage=(Stage) signOutIMS.getScene().getWindow();


        //load mainMenu scene
        root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        stage=(Stage) mainMenuBtn.getScene().getWindow();


        //load mainMenu scene
        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
