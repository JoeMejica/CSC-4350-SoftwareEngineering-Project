package InventoryManagementSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class manageUsersMenuController {

    @FXML
    public Button signOutIMS;

    @FXML
    public Button mainMenuBtn;


    @FXML
    public Button outgoingBtn;

    @FXML
    public Button incomingBtn;

    @FXML
    public Button manageBtn;

    @FXML
    public Button settingsBtn;

    @FXML
    public ComboBox userTypeCBox;

    @FXML
    public TextField firstNameField;

    @FXML
    public TextField middleInitialField;

    @FXML
    public TextField lastNameField;

    @FXML
    public TextField usernameField;

    @FXML
    public TextField passwordField;

    @FXML
    public TextField emergencyContactField;

    @FXML
    public TextField contactNumberField;

    @FXML
    public Button viewAllUsersBtn;

    @FXML
    public Button submitFormBtn;


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

    public void viewUserDB(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("View User Database Button Clicked");

        stage=(Stage) settingsBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | User Database");

        root = FXMLLoader.load(getClass().getResource("userDatabase.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submitForm(ActionEvent actionEvent) {

        //console output added for QA
        System.out.println("Submit Form Button Clicked");
    }


    //TODO: INSERT REMAINING METHODS HERE
}
