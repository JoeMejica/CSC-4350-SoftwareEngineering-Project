package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class loginController {

    @FXML
    public Button loginIssueBtn;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField loginPassword;

    //TODO: need to link login credentials to database
    //can keep "admin" and "password" as safe defaults
    public void Login(ActionEvent action) {
        if (txtUserName.getText().equals("admin") && loginPassword.getText().equals("password")) {
            lblStatus.setText("Login Successful!");

            //TODO: add code to open new stage

        } else {
            lblStatus.setText("Incorrect Password!");
        }
    }


}
