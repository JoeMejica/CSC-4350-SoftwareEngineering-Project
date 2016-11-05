package InventoryManagementSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BarcodeItemTable {
	private final SimpleStringProperty itemName;
	private final SimpleDoubleProperty weight;
	private final SimpleStringProperty expiration;

	public BarcodeItemTable(String itemName, Double weight, String expiration) {
		super();
		this.itemName = new SimpleStringProperty(itemName);
		this.weight = new SimpleDoubleProperty(weight);
		this.expiration = new SimpleStringProperty(expiration);
	}

	public String getItemName() {
		return itemName.get();
	}

	public Double getWeight() {
		return weight.get();
	}

	public String getExpiration() {
		return expiration.get();
	}
}
