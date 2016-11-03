package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class Item {
	private Barcode itemBarcode;
	private double itemWeight;
	private String itemName;
	private int itemNumber;
	private String expirationDate;// if null there is no expiration date
	private boolean reserved;
	private Connection conn = SQLiteConnection.Connector();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public Item(String name, double weight, Barcode itemBarcode, String expirationDate) {
		reserved = false;
		this.itemBarcode = itemBarcode;
		itemWeight = weight;
		this.expirationDate = expirationDate;
		itemName = name;
		itemNumber = itemBarcode.getItemNumberInt();
	}

	public Item(double weight, Barcode itemBarcode) {
		reserved = false;
		this.itemBarcode = itemBarcode;
		itemWeight = weight;
	}

	public Item() {
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

	public Barcode getBarcode() {
		return itemBarcode;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public boolean getReserved() {
		return reserved;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setExpirationDate(String Date) {
		expirationDate = Date;
	}

	public void setReserved(boolean reserve) {
		reserved = reserve;
	}

	public void setItemWeight(double weight) {
		itemWeight = weight;
	}

	public void setItemName(String name) {
		itemName = name;
	}
}
