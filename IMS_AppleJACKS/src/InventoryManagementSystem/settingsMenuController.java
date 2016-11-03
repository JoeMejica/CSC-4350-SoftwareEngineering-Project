package InventoryManagementSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class settingsMenuController {

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
    public Label settingsPromptLbl;

    @FXML
    public Button helpBtn;

    @FXML
    public Button manageUsersBtn;

    @FXML
    public Button aboutBtn;


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

    //TODO: create and host Bootstrap site containing help documentation for IMS
    public void helpURL(ActionEvent actionEvent) {

        //console output added for QA
        System.out.println("Help Button Clicked");



        try {
            Desktop.getDesktop().browse(new URI("http://lmgtfy.com/?q=help"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }





    public void manageUsersMenu(ActionEvent actionEvent) throws IOException {

        //TODO: add admin boolean logic
        //admins only have access to button, if not admin -> settingsPromptLbl.setText("Admins Only");


        //console output added for QA
        System.out.println("Manage Users Button Clicked");

        stage=(Stage) manageUsersBtn.getScene().getWindow();

        stage.setTitle("I.M.S. | Manage Users Menu");

        root = FXMLLoader.load(getClass().getResource("manageUsers.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showVersionNumber(ActionEvent actionEvent) {

        //console output added for QA
        System.out.println("Version Number Button Clicked");
        settingsPromptLbl.setText("IMS Version 1.0");

    }


    //TODO: INSERT REMAINING METHODS HERE
}
