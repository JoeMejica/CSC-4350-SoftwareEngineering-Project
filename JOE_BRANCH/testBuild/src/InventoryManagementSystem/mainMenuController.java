package InventoryManagementSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class mainMenuController {

    @FXML
    private Button signOutIMS;

    @FXML
    private Button mainMenuBtn;

    @FXML
    private Button outgoingBtn;

    @FXML
    private Button incomingBtn;

    @FXML
    private Button manageBtn;

    @FXML
    private Button settingsBtn;

    //Dashboard Label Counts

    @FXML
    private Label totalInventoryLbl;

    @FXML
    private Label totalIncomingInventoryLbl;

    @FXML
    private Label totalOutgoingInventoryLbl;

    @FXML
    private Label totalPendingInventoryLbl;




    //STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

    private Stage stage;
    private Parent root;


    public void signOut(ActionEvent actionEvent) throws IOException {

        stage=(Stage) signOutIMS.getScene().getWindow();

        stage.setTitle("I.M.S. | Login");

        root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) mainMenuBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Main Menu");

        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void outgoingMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) outgoingBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Outgoing Shipments Menu");

        root = FXMLLoader.load(getClass().getResource("outgoing.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void incomingMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) incomingBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Incoming Shipments Menu");

        root = FXMLLoader.load(getClass().getResource("incoming.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    public void manageMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) manageBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Manage Inventory Menu");

        root = FXMLLoader.load(getClass().getResource("manageInventory.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void settingsMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Settings Menu");

        root = FXMLLoader.load(getClass().getResource("settings.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //DASHBOARD COUNT FUNCTIONS:



    //TODO: INSERT REMAINING METHODS HERE
}
