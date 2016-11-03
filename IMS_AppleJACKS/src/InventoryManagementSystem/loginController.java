package InventoryManagementSystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class loginController {

    @FXML
    public Button loginIssueBtn;

    @FXML
    public Button loginBtn;

    @FXML
    private Label lblStatus;

    @FXML

    private TextField txtUserName;

    @FXML
    private PasswordField loginPassword;

    //TODO: need to link login credentials to database
    //can keep "admin" and "password" as safe defaults


    Stage stage;
    Parent root;

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {

        //console output added for QA
        System.out.println("Login Button Clicked");

        if (txtUserName.getText().equals("admin") && loginPassword.getText().equals("password")) {


        stage=(Stage) loginBtn.getScene().getWindow();

            stage.setTitle("I.M.S. | Main Menu");


        //load mainMenu scene
        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();

        } else {
            lblStatus.setText("Incorrect Password!");
        }

        //additional non-db credentials added for test purposes
        if (txtUserName.getText().equals("applejacks_dev") && loginPassword.getText().equals("orange")) {


            stage=(Stage) loginBtn.getScene().getWindow();

            stage.setTitle("I.M.S. | Main Menu");


            //load mainMenu scene
            root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();

        } else {
            lblStatus.setText("Incorrect Password!");
        }

        //TODO: add team-member credentials




    }


    }


