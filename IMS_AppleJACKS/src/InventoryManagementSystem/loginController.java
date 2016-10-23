package InventoryManagementSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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




    }


    }


