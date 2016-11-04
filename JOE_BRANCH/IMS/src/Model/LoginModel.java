package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class LoginModel {
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

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

	public boolean isLogin(String username, String password) {
		try {
			conn = SQLiteConnection.Connector();
			String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
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

	public boolean isAdmin(String username, String password) {
		try {
			conn = SQLiteConnection.Connector();
			boolean check = false;
			String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = rs.getBoolean("admin");
				return check;
			} else {
				return check;
			}
		} catch (Exception e) {
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
}
