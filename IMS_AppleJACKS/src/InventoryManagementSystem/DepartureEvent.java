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
	private DepartureEvent event;

	public DepartureEvent(String itemName) {
		this.itemName = itemName;
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

	public void pendingEvent(String itemName) {
		event = new DepartureEvent(itemName);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"itemname\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setPending(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, event.getItemName());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readyEvent(String itemName) {
		event = new DepartureEvent(itemName);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"itemname\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setReady(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, event.getItemName());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void shippedEvent(String itemName) {
		event = new DepartureEvent(itemName);
		String query = "UPDATE \"main\".\"departures\" SET \"pending\" = ?1, \"ready\" = ?2, \"shipped\" = ?3 WHERE  \"itemname\" = ?4";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			event.setShipped(true);
			preparedStmt.setBoolean(1, event.getPending());
			preparedStmt.setBoolean(2, event.getReady());
			preparedStmt.setBoolean(3, event.getShipped());
			preparedStmt.setString(4, event.getItemName());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isItem(String itemName) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM items WHERE itemname = ?";
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

	public boolean isDepartItem(String itemName) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM departures WHERE itemname = ?";
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

	public void createDepartureTable() {
		String query = "CREATE  TABLE  IF NOT EXISTS \"main\".\"departures\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"itemname\" TEXT, \"reserved\" BOOL, \"pending\" BOOL, \"ready\" BOOL, \"shipped\" BOOL)";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createDepartureEvent(String itemName) {
		try {
			createDepartureTable();
			DepartureEvent outgoingItem = new DepartureEvent(itemName);
			String query = "INSERT INTO \"main\".\"departures\" (\"itemname\",\"reserved\",\"pending\",\"ready\",\"shipped\") VALUES (?1,?2,?3,?4,?5)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, outgoingItem.getItemName());
			preparedStmt.setBoolean(2, outgoingItem.getReserved());
			preparedStmt.setBoolean(3, outgoingItem.getPending());
			preparedStmt.setBoolean(4, outgoingItem.getReady());
			preparedStmt.setBoolean(5, outgoingItem.getShipped());
			preparedStmt.executeUpdate();
			query = "UPDATE \"main\".\"items\" SET \"reserved\" = ?1 WHERE  \"itemname\" = ?2";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setBoolean(1, outgoingItem.getReserved());
			preparedStmt.setString(2, outgoingItem.getItemName());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeDepartureItem(String itemName) {
		try {
			String query = "DELETE FROM departures WHERE itemname=?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, itemName);
			preparedStmt.executeUpdate();
			String query2 = "DELETE FROM items WHERE itemname=?";
			PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
			preparedStmt2.setString(1, itemName);
			preparedStmt2.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
