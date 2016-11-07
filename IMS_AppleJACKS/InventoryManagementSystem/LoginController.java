package InventoryManagementSystem;

import java.io.IOException;
import java.sql.SQLException;

import Model.LoginModel;
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

public class LoginController {
	private LoginModel loginModel = new LoginModel();

	@FXML
	private Button loginIssueBtn;

	@FXML
	private Button loginBtn;

	@FXML
	private Label lblStatus;

	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField loginPassword;

	private Stage stage;
	private Parent root;

	// username: admin password: admin
	public void Login(ActionEvent actionEvent) throws IOException, SQLException {
		try {
			if (loginModel.isLogin(txtUserName.getText(), loginPassword.getText())) {
				if (loginModel.isLock(txtUserName.getText())) {
					lblStatus.setText("Account locked, please notify admin!");
				} else {
					stage = (Stage) loginBtn.getScene().getWindow();

					stage.setTitle("I.M.S. | Main Menu");

					// load mainMenu scene
					root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

					Scene scene = new Scene(root, 600, 400);
					stage.setScene(scene);
					stage.show();
				}
			} else if (loginModel.isUser(txtUserName.getText())) {
				if (loginModel.isLock(txtUserName.getText())) {
					lblStatus.setText("Account locked, please notify admin!");
				} else {
					// correct username wrong password get 4 tries before lockout
					lblStatus.setText("Incorrect password, please try again!");
					loginModel.AddLock(txtUserName.getText());
				}
			} else if(txtUserName.getText().equals("")) {
				lblStatus.setText("Please enter username!");
			} else {
				lblStatus.setText("Username does not exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
