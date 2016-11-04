package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;


public class LoginModel {
	Connection conn;
	public LoginModel() {
		conn = SQLiteConnection.Connector();
		if (conn == null) {
			System.out.println("Connection not successful");
			System.exit(1);
		}

	}

	public boolean isDBconnected() {
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean isLogin(String username, String password) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
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
	
	public boolean isAdmin(String username, String password) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean check = false;
		String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				check = rset.getBoolean("admin");
				return check;
			} else {
				return check;
			}
		} catch (Exception e) {
			return false;
		} finally {
			pstmt.close();
			rset.close();
		}
	}
	
}
