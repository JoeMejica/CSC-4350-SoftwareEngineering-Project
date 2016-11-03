package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class Admin extends Employee {
	Connection conn = SQLiteConnection.Connector();
	public Admin(String firstName, String middleInitial, String lastName, String username, String PhoneNumber,
			String Email, String emergencyContactName, String emergencyNumber, String emergencyEmail) {
		super();
		admin = true;
	}

	public Admin(Employee employee) {
		this.firstName = employee.firstName;
		this.middleInitial = employee.middleInitial;
		this.lastName = employee.lastName;
		this.username = employee.username;
		this.emergencyContactName = employee.emergencyContactName;
		this.password = employee.password;
		this.emergencyContact = employee.emergencyContact;
		this.contactInformation = employee.contactInformation;
//		removeEmployee(employee);
	}

	public Employee addEmployee(String firstName, String middleInitial, String lastName, String username,
			String PhoneNumber, String Email, String emergencyContactName, String emergencyNumber,
			String emergencyEmail) {
		return new Employee(firstName, middleInitial, lastName, username, PhoneNumber, Email, emergencyContactName,
				emergencyNumber, emergencyEmail);
	}

	public void removeEmployee(String firstName, String lastName) {
		try {
			String query = "DELETE FROM employee WHERE firstname=? AND lastname=?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public Employee modifyEmployee(Employee employee) {
//		// requires user input via gui?
//	}
//
//	public ArrivalEvent modifyArrivalEvent() {
//
//	}

	// scheduleCycleCount()
}
