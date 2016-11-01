package InventoryManagementSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ItemTemp {
	private final SimpleStringProperty itemName;
	private final SimpleStringProperty barcode;
	private final SimpleDoubleProperty weight;
	private final SimpleStringProperty expiration;
	private final SimpleBooleanProperty reserved;
	public ItemTemp(String itemName, String barcode, Double weight, boolean reserved, String expiration) {
		super();
		this.itemName = new SimpleStringProperty(itemName);
		this.barcode = new SimpleStringProperty(barcode);
		this.weight = new SimpleDoubleProperty(weight);
		this.reserved = new SimpleBooleanProperty(reserved);
		this.expiration = new SimpleStringProperty(expiration);
		
	}
	public String getItemName() {
		return itemName.get();
	}
	public String getBarcode() {
		return barcode.get();
	}
	public Double getWeight() {
		return weight.get();
	}
	public boolean isReserved() {
		return reserved.get();
	}
	public String getExpiration() {
		return expiration.get();
	}

}
