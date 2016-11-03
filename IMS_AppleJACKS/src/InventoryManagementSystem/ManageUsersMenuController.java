package InventoryManagementSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Admin;
import Model.Contact;
import Model.Employee;

public class ManageUsersMenuController implements Initializable {

	ObservableList<String> userChoices = FXCollections.observableArrayList("Admin", "Employee");

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
	public Button viewAllUsersBtn;

	@FXML
	public Button submitFormBtn;

	@FXML
	public ComboBox<String> userTypeCBox;

	@FXML
	public TextField firstNameField;

	@FXML
	public TextField middleInitialField;

	@FXML
	public TextField lastNameField;

	@FXML
	public TextField usernameField;

	@FXML
	public PasswordField passwordField;

	@FXML
	public TextField contactNumberField;

	@FXML
	public TextField emailField;

	@FXML
	public TextField emergencyContactField;

	@FXML
	public TextField emergencyNumberField;

	@FXML
	public TextField emergencyEmailField;

	@FXML
	public Label status;

	@FXML
	public Label userLbl;

	@FXML
	public Label phoneLbl;

	@FXML
	public Label emailLbl;

	@FXML
	public Label contactPhoneLbl;

	@FXML
	public Label contactEmailLbl;

	// STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

	Stage stage;
	Parent root;
	Connection conn = SQLiteConnection.Connector();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userTypeCBox.setItems(userChoices);
		userTypeCBox.setValue("Employee");
	}

	public void submitForm(ActionEvent actionEvent) {
		Employee hire = new Employee();
		Admin admin;

		Contact confirm;
		Contact confirmEmergency;
		String compareX = null;
		String compareY = null;
		String check = userTypeCBox.getSelectionModel().getSelectedItem();
		boolean level = false;
		if (check == "Admin") {
			level = true;
		}
		String x = "";
		if (!(firstNameField.getText().equals(x))) {
			status.setText(null);
			if (!(lastNameField.getText().equals(x))) {
				status.setText(null);
				if (!(usernameField.getText().equals(x))) {
					status.setText(null);
					if (!(passwordField.getText().equals(x))) {
						status.setText(null);
						if (!(emergencyContactField.getText().equals(x))) {
							status.setText(null);
							hire.setAdmin(level);
							hire.setFirstName(firstNameField.getText());
							hire.setMiddleInitial(middleInitialField.getText());
							hire.setLastName(lastNameField.getText());
							hire.setUsername(usernameField.getText());
							hire.setPassword(passwordField.getText());
							hire.setEmergencyContactName(emergencyContactField.getText());
							confirm = new Contact(contactNumberField.getText(), emailField.getText());
							confirmEmergency = new Contact(emergencyNumberField.getText(),
									emergencyEmailField.getText());
							compareX = confirm.getEmailAddress();
							compareY = emailField.getText();
							if (compareX.equals(compareY)) {
								compareX = confirm.getPhoneNumber();
								compareY = contactNumberField.getText();
								emailLbl.setText(null);
								if (compareX.equals(compareY)) {
									compareX = confirmEmergency.getEmailAddress();
									compareY = emergencyEmailField.getText();
									phoneLbl.setText(null);
									if (compareX.equals(compareY)) {
										compareX = confirmEmergency.getPhoneNumber();
										compareY = emergencyNumberField.getText();
										contactPhoneLbl.setText(null);
										if (compareX.equals(compareY)) {
											contactEmailLbl.setText(null);
											String query = "SELECT * FROM employee WHERE username = ?";
											try {
												ps = conn.prepareStatement(query);
												ps.setString(1, hire.getUsername());
												rs = ps.executeQuery();
												if (rs.next()) {
													userLbl.setText("Username exists!");
												} else {
													userLbl.setText(null);
													query = "SELECT * FROM employee WHERE email = ?";
													ps = conn.prepareStatement(query);
													ps.setString(1, emailField.getText());
													rs = ps.executeQuery();
													if (rs.next()) {
														emailLbl.setText("Email exists!");
													} else {
														emailLbl.setText(null);
														if (level) {
															admin = new Admin(hire);
															query = "INSERT INTO employee (firstname, middleinitial, lastname, username, password, phonenumber, email, admin, contactname, contactnumber, contactemail)"
																	+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
															ps = conn.prepareStatement(query);
															ps.setString(1, admin.getFirstName());
															ps.setString(2, admin.getMiddleInitial());
															ps.setString(3, admin.getLastName());
															ps.setString(4, admin.getUsername());
															ps.setString(5, admin.getPassword());
															ps.setString(6, contactNumberField.getText());
															ps.setString(7, emailField.getText());
															ps.setBoolean(8, level);
															ps.setString(9, admin.getEmergencyContactName());
															ps.setString(10, emergencyNumberField.getText());
															ps.setString(11, emergencyEmailField.getText());
															ps.executeUpdate();
															firstNameField.clear();
															middleInitialField.clear();
															lastNameField.clear();
															usernameField.clear();
															passwordField.clear();
															contactNumberField.clear();
															emailField.clear();
															emergencyContactField.clear();
															emergencyEmailField.clear();
															emergencyNumberField.clear();
															status.setText("New user created!");
														} else {
															query = "INSERT INTO employee (firstname, middleinitial, lastname, username, password, phonenumber, email, admin, contactname, contactnumber, contactemail)"
																	+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
															ps = conn.prepareStatement(query);
															ps.setString(1, hire.getFirstName());
															ps.setString(2, hire.getMiddleInitial());
															ps.setString(3, hire.getLastName());
															ps.setString(4, hire.getUsername());
															ps.setString(5, hire.getPassword());
															ps.setString(6, contactNumberField.getText());
															ps.setString(7, emailField.getText());
															ps.setBoolean(8, hire.getAdmin());
															ps.setString(9, hire.getEmergencyContactName());
															ps.setString(10, emergencyNumberField.getText());
															ps.setString(11, emergencyEmailField.getText());
															ps.executeUpdate();
															firstNameField.clear();
															middleInitialField.clear();
															lastNameField.clear();
															usernameField.clear();
															passwordField.clear();
															contactNumberField.clear();
															emailField.clear();
															emergencyContactField.clear();
															emergencyEmailField.clear();
															emergencyNumberField.clear();
															status.setText("New user created!");
														}
													}
												}
											} catch (SQLException e) {
												e.printStackTrace();
											}
										} else {
											contactPhoneLbl.setText("Incorrect!");
										}
									} else {
										contactEmailLbl.setText("Incorrect!");
									}
								} else {
									phoneLbl.setText("Incorrect!");
								}
							} else {
								emailLbl.setText("Incorrect!");
							}
						} else {
							status.setText("Empty field!");
						}
					} else {
						status.setText("Empty field!");
					}
				} else {
					status.setText("Empty field!");
				}
			} else {
				status.setText("Empty field!");
			}
		} else {
			status.setText("Empty field!");
		}
	}

	public void viewUserDB(ActionEvent actionEvent) throws IOException {
		stage = (Stage) signOutIMS.getScene().getWindow();

		stage.setTitle("I.M.S. | View User Menu");

		root = FXMLLoader.load(getClass().getResource("users.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void signOut(ActionEvent actionEvent) throws IOException {

		stage = (Stage) signOutIMS.getScene().getWindow();

		stage.setTitle("I.M.S. | Login");

		root = FXMLLoader.load(getClass().getResource("login.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void mainMenu(ActionEvent actionEvent) throws IOException {

		stage = (Stage) mainMenuBtn.getScene().getWindow();

		stage.setTitle("I.M.S. | Main Menu");

		root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void outgoingMenu(ActionEvent actionEvent) throws IOException {

		stage = (Stage) outgoingBtn.getScene().getWindow();

		stage.setTitle("I.M.S. | Outgoing Shipments Menu");

		root = FXMLLoader.load(getClass().getResource("outgoing.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void incomingMenu(ActionEvent actionEvent) throws IOException {

		stage = (Stage) incomingBtn.getScene().getWindow();

		stage.setTitle("I.M.S. | Incoming Shipments Menu");

		root = FXMLLoader.load(getClass().getResource("incoming.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void manageMenu(ActionEvent actionEvent) throws IOException {

		stage = (Stage) manageBtn.getScene().getWindow();

		stage.setTitle("I.M.S. | Manage Inventory Menu");

		root = FXMLLoader.load(getClass().getResource("manageInventory.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void settingsMenu(ActionEvent actionEvent) throws IOException {

		stage = (Stage) settingsBtn.getScene().getWindow();

		stage.setTitle("I.M.S. | Settings Menu");

		root = FXMLLoader.load(getClass().getResource("settings.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// TODO: INSERT REMAINING METHODS HERE
}
