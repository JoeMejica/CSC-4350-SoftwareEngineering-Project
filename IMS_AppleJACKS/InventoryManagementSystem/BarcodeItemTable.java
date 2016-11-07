package InventoryManagementSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BarcodeItemTable {
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty itemName;
	private final SimpleDoubleProperty weight;
	private final SimpleStringProperty expiration;

	public BarcodeItemTable(Integer id, String itemName, Double weight, String expiration) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.itemName = new SimpleStringProperty(itemName);
		this.weight = new SimpleDoubleProperty(weight);
		this.expiration = new SimpleStringProperty(expiration);
	}

	public int getId() {
		return id.get();
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
