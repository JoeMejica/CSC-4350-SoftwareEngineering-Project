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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BarcodeController implements Initializable {

	ObservableList<String> aisleChoices = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
	ObservableList<String> sectionChoices = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

	@FXML
	private TableView<BarcodeItemTable> table;

	@FXML
	private TableColumn<BarcodeItemTable, String> itemNameCol;

	@FXML
	private TableColumn<BarcodeItemTable, Double> weightCol;

	@FXML
	private TableColumn<BarcodeItemTable, String> expirationCol;

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
	public Button createBtn;

	@FXML
	public TextField itemName;

	@FXML
	public TextField number;

	@FXML
	public Label status;

	@FXML
	public Label aisleLbl;

	@FXML
	public Label sectionLbl;

	@FXML
	public Label numberLbl;

	@FXML
	public ComboBox<String> aisleBox;

	@FXML
	public ComboBox<String> sectionBox;

	// STAGE AND BUTTON NAVIGATION VARIABLES AND FUNCTIONS:
	Stage stage;
	Parent root;
	Connection conn = SQLiteConnection.Connector();
	ObservableList<BarcodeItemTable> list = FXCollections.observableArrayList();
	DepartureEvent departEvent = new DepartureEvent();
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		aisleBox.setVisibleRowCount(4);
		aisleBox.setItems(aisleChoices);
		aisleBox.setValue("A");
		sectionBox.setVisibleRowCount(4);
		sectionBox.setItems(sectionChoices);
		sectionBox.setValue("01");
		itemNameCol.setCellValueFactory(new PropertyValueFactory<BarcodeItemTable, String>("itemName"));
		weightCol.setCellValueFactory(new PropertyValueFactory<BarcodeItemTable, Double>("weight"));
		expirationCol.setCellValueFactory(new PropertyValueFactory<BarcodeItemTable, String>("expiration"));
		loadBarcodeItems();
	}

	public boolean checkBarcode(String barcode) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM items WHERE barcode = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, barcode);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			pstmt.close();
			rset.close();
		}
	}

	public boolean isItem(String itemName) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM items WHERE itemname = ? AND barcode IS NULL";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, itemName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			pstmt.close();
			rset.close();
		}
	}

	public void removeDups(String itemName) {
		try {
			String query = "SELECT * FROM items WHERE itemname = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, itemName);
			rs = ps.executeQuery();
			if (rs.next()) {
				int dup = rs.getInt("id");
				query = "UPDATE items SET barcode = NULL WHERE id = ?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, dup);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createBarcodeEvent(ActionEvent event) throws SQLException {
		if (isItem(itemName.getText())) {
			String first = aisleBox.getSelectionModel().getSelectedItem();
			String second = sectionBox.getSelectionModel().getSelectedItem();
			String third = number.getText();
			String cat = first + second + third;
			if (!checkBarcode(cat)) {
				String query = "SELECT * FROM items WHERE itemname = ? AND barcode IS NULL";
				int check = 0;
				ps = conn.prepareStatement(query);
				ps.setString(1, itemName.getText());
				rs = ps.executeQuery();
				while (rs.next()) {
					check++;
				}
				if (check > 1) {
					query = "UPDATE \"main\".\"items\" SET \"barcode\" = ?1 WHERE  \"itemname\" = ?2 AND barcode IS NULL";
					ps = conn.prepareStatement(query);
					ps.setString(1, cat);
					ps.setString(2, itemName.getText());
					ps.executeUpdate();
					removeDups(itemName.getText());
					list.removeAll(list);
					loadBarcodeItems();
					status.setText("Barcode successfully created!");
					number.clear();
					itemName.clear();
				} else {
					query = "UPDATE \"main\".\"items\" SET \"barcode\" = ?1 WHERE  \"itemname\" = ?2 AND barcode IS NULL";
					ps = conn.prepareStatement(query);
					ps.setString(1, cat);
					ps.setString(2, itemName.getText());
					ps.executeUpdate();
					list.removeAll(list);
					loadBarcodeItems();
					status.setText("Barcode successfully created!");
					number.clear();
					itemName.clear();
				}
			} else {
				status.setText("Barcode exists!");
			}
		} else {
			status.setText("Item not found!");
		}
	}

	public void loadBarcodeItems() {
		try {
			String query = "SELECT * FROM items WHERE barcode IS NULL";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BarcodeItemTable(rs.getString("itemname"), rs.getDouble("weight"),
						rs.getString("expiration")));
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
