import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartureEvent {
	public void reserveEvent(Item item) {
		item.setReserved(true);
	}

	public void pendingEvent(Item item) {
		if (item.getReserved() == true) {
			item.setPending(true);
		} else {
			item.setPending(false);
		}
	}

	public void readyEvent(Item item) {
		if (item.getReserved() == true && item.getPending() == true) {
			item.setReady(true);
		} else {
			item.setReady(false);
		}
	}

	public void shipEvent(Item item) {
		if (item.getReserved() == true && item.getPending() == true && item.getReady() == true) {
			item.setShipped(true);
		} else {
			item.setShipped(false);
		}
	}

	// Need database connection
	public void removeShippedItem(Item item, Connection conn) {
		if (item.getShipped() == true) {
			try {
				Barcode barcode = item.getBarcode();
				String removeBarcode = barcode.getBarcode();
				String query = "DELETE FROM items WHERE barcode=?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, removeBarcode);
				preparedStmt.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	// Need database connection
	public void updateDepartureEvents(Item item, Connection conn) {
		try {
			Barcode barcode = item.getBarcode();
			String addBarcode = barcode.getBarcode();
			String query = "UPDATE items SET reserved=?, pending=?, ready=?, shipped=? WHERE barcode=?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setBoolean(1, item.getReserved());
			preparedStmt.setBoolean(2, item.getPending());
			preparedStmt.setBoolean(3, item.getReady());
			preparedStmt.setBoolean(4, item.getShipped());
			preparedStmt.setString(5, addBarcode);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
