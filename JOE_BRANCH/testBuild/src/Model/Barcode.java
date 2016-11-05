package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class Barcode {
	private char AisleLetter;
	private String sectionNumber;
	private String ItemNumber;
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public Barcode(char AisleLetter, String sectionNumber, String ItemNumber) {
		this.AisleLetter = AisleLetter;
		this.sectionNumber = sectionNumber;
		this.ItemNumber = ItemNumber;
	}

	public Barcode() {
	}

	public boolean checkBarcode(String barcode) {
		try {
			conn = SQLiteConnection.Connector();
			String query = "SELECT * FROM items WHERE barcode = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, barcode);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	public String getBarcode() {
		return AisleLetter + "-" + sectionNumber + "-" + ItemNumber;
	}

	public char getAisleLetter() {
		return AisleLetter;
	}

	public String getSectionNumber() {
		return sectionNumber;
	}

	public int getSectionNumberInt() {
		return Integer.parseInt(sectionNumber);
	}

	public String getItemNumber() {
		return ItemNumber;
	}

	public int getItemNumberInt() {
		return Integer.parseInt(ItemNumber);
	}

	public void setAisleLetter(char aisle) {
		AisleLetter = aisle;
	}

	public void setSectionNumber(String section) {
		sectionNumber = section;
	}

	public void setItemNumber(String number) {
		ItemNumber = number;
	}

	public boolean equals(Barcode barcode) {
		if (this.AisleLetter == barcode.getAisleLetter() && this.getSectionNumber().equals(barcode.getSectionNumber())
				&& this.getItemNumber().equals(barcode.getItemNumber())) {
			return true;
		} else
			return false;
	}
}
