package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField loginPassword;

    public void Login(ActionEvent action) {
        if (txtUserName.getText().equals("admin") && loginPassword.getText().equals("password")) {
            lblStatus.setText("*much success*");
        } else {
            lblStatus.setText("*such wrong*");
        }
    }


}
