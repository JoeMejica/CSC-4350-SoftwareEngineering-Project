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
	private Connection conn = SQLiteConnection.Connector();

	public Barcode(char AisleLetter, String sectionNumber, String ItemNumber) {
		this.AisleLetter = AisleLetter;
		this.sectionNumber = sectionNumber;
		this.ItemNumber = ItemNumber;
	}

	public Barcode() {
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
