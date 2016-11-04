package InventoryManagementSystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class ViewInventoryController implements Initializable {
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
	private Button signOutIMS;
	@FXML
	private TableView<ViewInventoryTable> table;
	@FXML
	private TableColumn<ViewInventoryTable, String> aisleCol;
	@FXML
	private TableColumn<ViewInventoryTable, String> nameCol;
	@FXML
	private TableColumn<ViewInventoryTable, String> barcodeCol;
	@FXML
	private TableColumn<ViewInventoryTable, Double> weightCol;
	@FXML
	private TableColumn<ViewInventoryTable, String> expirationCol;
	@FXML
	private TableColumn<ViewInventoryTable, String> sectionCol;
	@FXML
	private TableColumn<ViewInventoryTable, String> numberCol;
	@FXML
	private Label aisleLbl;

	private Stage stage;
	private Parent root;
	private Connection conn;
	private ObservableList<ViewInventoryTable> list = FXCollections.observableArrayList();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String viewAisle = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		aisleCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("aisle"));
		nameCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("itemName"));
		barcodeCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("barcode"));
		weightCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, Double>("weight"));
		expirationCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("expiration"));
		sectionCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("section"));
		numberCol.setCellValueFactory(new PropertyValueFactory<ViewInventoryTable, String>("number"));
	}

	public void initAisle(String aisle) {
		aisleLbl.setText(aisle);
		viewAisle = aisleLbl.getText();
		aisleLbl.setText("Aisle " + aisle);
		loadAisle(viewAisle);
	}

	public void loadAisle(String aisle) {
		try {
			if (!(aisle == "All aisles")) {
				conn = SQLiteConnection.Connector();
				String query = "SELECT * FROM items WHERE aisle = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, aisle);
				rs = ps.executeQuery();
				while (rs.next()) {
					char aisleChar = rs.getString("aisle").charAt(0);
					String aisleString = String.valueOf(aisleChar);
					int i = Integer.parseInt(rs.getString("itemnumber"));
					String number = String.valueOf(i);
					list.add(new ViewInventoryTable(aisleString, rs.getString("itemname"), rs.getString("barcode"),
							rs.getDouble("weight"), rs.getString("expiration"), rs.getString("section"), number));
					table.setItems(list);
				}
			} else {
				conn = SQLiteConnection.Connector();
				String query = "SELECT * FROM items";
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					char aisleChar = rs.getString("aisle").charAt(0);
					String aisleString = String.valueOf(aisleChar);
					int i = Integer.parseInt(rs.getString("itemnumber"));
					String number = String.valueOf(i);
					list.add(new ViewInventoryTable(aisleString, rs.getString("itemname"), rs.getString("barcode"),
							rs.getDouble("weight"), rs.getString("expiration"), rs.getString("section"), number));
					table.setItems(list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					/* ignored */}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					/* ignored */}
			}
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
