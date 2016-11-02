package InventoryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartureEvent {
	Connection conn;
	private boolean reserved;
	private boolean pending;
	private boolean ready;
	private boolean shipped;
	private String itemName;
//	private String barcode;
	private DepartureEvent event;

	public DepartureEvent(String itemName) {
		this.itemName = itemName;
//		barcode = null;
		reserved = true;
		pending = false;
		ready = false;
		shipped = false;
	}

	public DepartureEvent() {
		conn = SQLiteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection not successful");
			System.exit(1);
		}
	}

//	public String getBarcode(){
//		return barcode;
//	}
//	
//	public void setBarcode(String barcode){
//		this.barcode = barcode;
//	}
	public String getItemName() {
		return itemName;
	}

	public boolean getReserved() {
		return reserved;
	}

	public boolean getPending() {
		return pending;
	}

	public boolean getReady() {
		return ready;
	}

	public boolean getShipped() {
		return shipped;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setReserved(boolean reserve) {
		reserved = reserve;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public void pendingEvent(String barcode) {
		event = new DepartureEvent(barcode);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"barcode\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setPending(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, barcode);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readyEvent(String barcode) {
		event = new DepartureEvent(barcode);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"barcode\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setReady(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, barcode);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void shippedEvent(String barcode) {
		event = new DepartureEvent(barcode);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"barcode\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setShipped(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, barcode);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isBarcode(String barcode) throws SQLException {
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

	public boolean isDepartItem(String barcode) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM departures WHERE barcode = ?";
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

	public void createDepartureTable() {
		String query = "CREATE  TABLE  IF NOT EXISTS \"main\".\"departures\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"itemname\" TEXT, \"barcode\" TEXT, \"reserved\" BOOL, \"pending\" BOOL, \"ready\" BOOL, \"shipped\" BOOL)";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createDepartureEvent(String itemName, String barcode) {
		try {
			createDepartureTable();
			DepartureEvent outgoingItem = new DepartureEvent(itemName);
			String query = "INSERT INTO \"main\".\"departures\" (\"itemname\",\"barcode\",\"reserved\",\"pending\",\"ready\",\"shipped\") VALUES (?1,?2,?3,?4,?5,?6)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, outgoingItem.getItemName());
			preparedStmt.setString(2, barcode);
			preparedStmt.setBoolean(3, outgoingItem.getReserved());
			preparedStmt.setBoolean(4, outgoingItem.getPending());
			preparedStmt.setBoolean(5, outgoingItem.getReady());
			preparedStmt.setBoolean(6, outgoingItem.getShipped());
			preparedStmt.executeUpdate();
			query = "UPDATE \"main\".\"items\" SET \"reserved\" = ?1 WHERE  \"barcode\" = ?2";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setBoolean(1, outgoingItem.getReserved());
			preparedStmt.setString(2, barcode);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeDepartureItem(String barcode) {
		try {
			String query = "DELETE FROM departures WHERE barcode=?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, barcode);
			preparedStmt.executeUpdate();
			String query2 = "DELETE FROM items WHERE barcode=?";
			PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
			preparedStmt2.setString(1, barcode);
			preparedStmt2.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
