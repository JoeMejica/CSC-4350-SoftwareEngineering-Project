package InventoryManagementSystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.DepartureEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UpdateDepartureEventController implements Initializable {

	@FXML
	private TableView<DepartureItemTable> table;

	@FXML
	private TableColumn<DepartureItemTable, String> itemNameCol;
	
	@FXML
	private TableColumn<DepartureItemTable, String> barcodeCol;

	@FXML
	private TableColumn<DepartureItemTable, Boolean> reserveCol;

	@FXML
	private TableColumn<DepartureItemTable, Boolean> pendingCol;

	@FXML
	private TableColumn<DepartureItemTable, Boolean> readyCol;

	@FXML
	private TableColumn<DepartureItemTable, Boolean> shippedCol;

	@FXML
	private Button signOutIMS;

	@FXML
	private Button mainMenuBtn;

	@FXML
	private Button outgoingBtn;

	@FXML
	private Button incomingBtn;

	@FXML
	private Button manageBtn;

	@FXML
	private Button settingsBtn;

	@FXML
	private Button pendingBtn;

	@FXML
	private Button readyBtn;

	@FXML
	private Button shippedBtn;

	@FXML
	private TextField barcode;

	@FXML
	private Label status;

	@FXML
	private Label txtFieldLbl;

	@FXML
	private Label tableName;

	// STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:

	Stage stage;
	Parent root;
	Connection conn = SQLiteConnection.Connector();
	ObservableList<DepartureItemTable> list = FXCollections.observableArrayList();
	DepartureEvent departEvent = new DepartureEvent();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		itemNameCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, String>("itemName"));
		barcodeCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, String>("barcode"));
		reserveCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, Boolean>("reserved"));
		pendingCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, Boolean>("pending"));
		readyCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, Boolean>("ready"));
		shippedCol.setCellValueFactory(new PropertyValueFactory<DepartureItemTable, Boolean>("shipped"));
		loadDepartureItems();
	}

	public void pendingEvent(ActionEvent event) throws SQLException {
		if (departEvent.isDepartItem(barcode.getText())) {
			departEvent.pendingEvent(barcode.getText());
			status.setText("Update pending status successful!");
			list.removeAll(list);
			loadDepartureItems();
			barcode.clear();
		} else {
			status.setText("Barcode not found!");
		}
	}

	public void readyEvent(ActionEvent event) throws SQLException {
		if (departEvent.isDepartItem(barcode.getText())) {
			departEvent.readyEvent(barcode.getText());
			status.setText("Update ready status successful!");
			list.removeAll(list);
			loadDepartureItems();
			barcode.clear();
		} else {
			status.setText("Barcode not found!");
		}
	}

	public void shippedEvent(ActionEvent event) throws SQLException {
		if (departEvent.isDepartItem(barcode.getText())) {
			departEvent.shippedEvent(barcode.getText());
			status.setText("Update shipped status successful!");
			list.removeAll(list);
			loadDepartureItems();
			barcode.clear();
		} else {
			status.setText("Barcode not found!");
		}
	}

	public void loadDepartureItems() {
		departEvent.createDepartureTable();
		try {
			String query = "SELECT * FROM departures";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DepartureItemTable(rs.getString("itemname"), rs.getString("barcode"), rs.getBoolean("reserved"),
						rs.getBoolean("pending"), rs.getBoolean("ready"), rs.getBoolean("shipped")));
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

}
