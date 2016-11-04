package InventoryManagementSystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class usersController implements Initializable {

	@FXML
	private TableView<UserTable> table;

	@FXML
	private TableColumn<UserTable, String> firstNameCol;

	@FXML
	private TableColumn<UserTable, String> middleInitCol;
	
	@FXML
	private TableColumn<UserTable, String> lastNameCol;
	
	@FXML
	private TableColumn<UserTable, String> phoneCol;
	
	@FXML
	private TableColumn<UserTable, String> emailCol;
	
	@FXML
	private TableColumn<UserTable, String> contactNameCol;
	
	@FXML
	private TableColumn<UserTable, String> contactEmailCol;

	@FXML
	private TableColumn<UserTable, String> contactNumCol;

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

	// STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

	Stage stage;
	Parent root;
	Connection conn = SQLiteConnection.Connector();
	ObservableList<UserTable> list = FXCollections.observableArrayList();
	DepartureEvent departEvent = new DepartureEvent();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		firstNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("firstName"));
		middleInitCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("middleInit"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("lastName"));
		phoneCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("phoneNumber"));
		emailCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("email"));
		contactNameCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("contactName"));
		contactEmailCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("contactEmail"));
		contactNumCol.setCellValueFactory(new PropertyValueFactory<UserTable, String>("contactNumber"));
		loadUsers();
	}
	
	public void loadUsers() {
		try {
			String query = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserTable(rs.getString("firstname"),
						rs.getString("middleinitial"),
						rs.getString("lastname"),
						rs.getString("phonenumber"),
						rs.getString("email"),
						rs.getString("contactname"),
						rs.getString("contactnumber"),
						rs.getString("contactemail")));
				table.setItems(list);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
