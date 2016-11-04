package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class Aisle {
	private Section sections[] = new Section[20];
	private boolean sectionsFull[] = new boolean[20];
	private Connection conn = SQLiteConnection.Connector();

	public Aisle() {
		for (int i = 0; i < 20; i++) {
			sectionsFull[i] = false;
		}
	}

	public boolean checkAisleFull(String aisle) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int i = 0;
		String query = "SELECT * FROM items WHERE aisle = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, aisle);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				i++;
			}
			if (i >= 100) {
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

	public Item removeItem(Barcode barcode) {
		int sectionNumber = barcode.getSectionNumberInt();
		Item returnItem = sections[sectionNumber].removeItem(barcode);
		if (returnItem != null && sectionsFull[sectionNumber]) {
			sectionsFull[sectionNumber] = false;
		}
		return returnItem;
	}

	public void addItem(Item newItem) {
		int sectionNumber = newItem.getBarcode().getSectionNumberInt();
		sections[sectionNumber].addItem(newItem);
		if (sections[sectionNumber].getNumItems() == 5) {
			sectionsFull[sectionNumber] = true;
		}
	}

	public Item findItem(Barcode barcode) {
		int sectionNumber = barcode.getSectionNumberInt();
		return sections[sectionNumber].findItem(barcode);
	}
}
