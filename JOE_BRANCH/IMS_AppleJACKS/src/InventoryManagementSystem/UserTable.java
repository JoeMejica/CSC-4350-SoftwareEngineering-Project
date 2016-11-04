package InventoryManagementSystem;

import javafx.beans.property.SimpleStringProperty;

public class UserTable {
	private final SimpleStringProperty firstName;
	private final SimpleStringProperty middleInit;
	private final SimpleStringProperty lastName;
	private final SimpleStringProperty phoneNumber;
	private final SimpleStringProperty email;
	private final SimpleStringProperty contactName;
	private final SimpleStringProperty contactEmail;
	private final SimpleStringProperty contactNumber;

	public UserTable(String firstName, String middleInit, String lastName, String phoneNumber, String email,
			String contactName, String contactEmail, String contactNumber) {
		super();
		this.firstName = new SimpleStringProperty(firstName);
		this.middleInit = new SimpleStringProperty(middleInit);
		this.lastName = new SimpleStringProperty(lastName);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.email = new SimpleStringProperty(email);
		this.contactName = new SimpleStringProperty(contactName);
		this.contactEmail = new SimpleStringProperty(contactEmail);
		this.contactNumber = new SimpleStringProperty(contactNumber);
	}

	public String getFirstName() {
		return firstName.get();
	}

	public String getMiddleInit() {
		return middleInit.get();
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getContactName() {
		return contactName.get();
	}

	public String getContactEmail() {
		return contactEmail.get();
	}

	public String getContactNumber() {
		return contactNumber.get();
	}
}
