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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageInventoryController implements Initializable {

	ObservableList<String> aisleChoices = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F", "O");
	ObservableList<String> sectionChoices = FXCollections.observableArrayList("All sections", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

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
	public Button viewBtn;

	@FXML
	public Button countBtn;

	@FXML
	public ComboBox<String> aisleBox;

	@FXML
	public ComboBox<String> aisleBox2;

	@FXML
	public ComboBox<String> sectionBox;

	@FXML
	public Label viewLbl;

	@FXML
	public Label countLbl;

	@FXML
	public Label countedLbl;

	// STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

	Stage stage;
	Parent root;
	Connection conn = SQLiteConnection.Connector();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		aisleBox.setVisibleRowCount(4);
		aisleBox.setItems(aisleChoices);
		aisleBox.setValue("A");
		aisleBox2.setVisibleRowCount(4);
		aisleBox2.setItems(aisleChoices);
		aisleBox2.setValue("A");
		sectionBox.setVisibleRowCount(4);
		sectionBox.setItems(sectionChoices);
		sectionBox.setValue("All sections");
	}

	public void cycleCount(ActionEvent event) throws IOException, SQLException {
		if (sectionBox.getSelectionModel().getSelectedItem() == "All sections") {
			String query = "SELECT * FROM items WHERE aisle=?";
			int i = 0;
			ps = conn.prepareStatement(query);
			ps.setString(1, aisleBox2.getSelectionModel().getSelectedItem());
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
			countedLbl.setText("Count: " + i);
		} else {
			String query = "SELECT * FROM items WHERE aisle=? AND section =?";
			int i = 0;
			ps = conn.prepareStatement(query);
			ps.setString(1, aisleBox2.getSelectionModel().getSelectedItem());
			ps.setString(2, sectionBox.getSelectionModel().getSelectedItem());
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
			countedLbl.setText("Count: " + i);
		}
	}

	public void viewInventory(ActionEvent event) throws IOException {
		stage = (Stage) viewBtn.getScene().getWindow();
		String aisle = aisleBox.getSelectionModel().getSelectedItem();

		stage.setTitle("I.M.S. | View Inventory - Aisle " + aisle);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewInventory.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		ViewInventoryController con = fxmlLoader.<ViewInventoryController> getController();
		con.initAisle(aisle);

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
