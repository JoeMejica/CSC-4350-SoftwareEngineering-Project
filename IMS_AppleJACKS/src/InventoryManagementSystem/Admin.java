package InventoryManagementSystem;

public class Admin extends Employee {
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

//	public void removeEmployee(Employee employee) {
//		// modifies database
//	}

//	public Employee modifyEmployee(Employee employee) {
//		// requires user input via gui?
//	}
//
//	public ArrivalEvent modifyArrivalEvent() {
//
//	}

	// scheduleCycleCount()
}
