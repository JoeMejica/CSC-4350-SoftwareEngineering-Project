package InventoryManagementSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class incomingMenuController {

    @FXML
    public Button signOutIMS;

    @FXML
    public Button mainMenuBtn;

    @FXML
    public Button barcodeBtn;

    @FXML
    public Button outgoingBtn;

    @FXML
    public Button incomingBtn;

    @FXML
    public Button manageBtn;

    @FXML
    public Button settingsBtn;

    @FXML
    public Button createArrivalBtn;

    @FXML
    public Button editArrivalBtn;

    @FXML
    public Button viewByTrackingBtn;

    @FXML
    public TextField trackingNumberInput;

    @FXML
    public TableView arrivalDB;


    //STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

    Stage stage;
    Parent root;


    public void signOut(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Sign Out Button Clicked");

        stage=(Stage) signOutIMS.getScene().getWindow();

        stage.setTitle("I.M.S. | Login");

        root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Main Menu Button Clicked");

        stage=(Stage) mainMenuBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Main Menu");

        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
    public void barcodeMenu(ActionEvent actionEvent) throws IOException {

        stage=(Stage) barcodeBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Barcode Menu");


        root = FXMLLoader.load(getClass().getResource("barcode.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */

    public void outgoingMenu(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Outgoing Menu Button Clicked");

        stage=(Stage) outgoingBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Outgoing Shipments Menu");

        root = FXMLLoader.load(getClass().getResource("outgoing.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void incomingMenu(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Incoming Menu Button Clicked");

        stage=(Stage) incomingBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Incoming Shipments Menu");

        root = FXMLLoader.load(getClass().getResource("incoming.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void manageMenu(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Manage Menu Button Clicked");

        stage=(Stage) manageBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Manage Inventory Menu");

        root = FXMLLoader.load(getClass().getResource("manageInventory.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void settingsMenu(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Settings Menu Button Clicked");

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Settings Menu");

        root = FXMLLoader.load(getClass().getResource("settings.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createArrivalEvent(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("CREATE Arrival Event Button Clicked");

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Create Arrival Event");

        root = FXMLLoader.load(getClass().getResource("createArrival.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void modifyArrivalEvent(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("MODIFY Arrival Event Button Clicked");

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Modify Arrival Event");

        root = FXMLLoader.load(getClass().getResource("modifyArrival.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewArrivalEvent(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("VIEW Arrival Event Button Clicked");

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | View Arrival Event");

        root = FXMLLoader.load(getClass().getResource("viewByTracking.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //TODO: INSERT REMAINING METHODS HERE
}
