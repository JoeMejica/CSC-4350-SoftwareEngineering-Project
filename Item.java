
public class Item {
	private Barcode itemBarcode;
	double itemWeight;
	private String expirationDate;// if null there is no expiration date
	private boolean reserved;
	private boolean pending;
	private boolean ready;
	private boolean shipped;

	public Item(double weight, String expirationDate) {
		reserved = false;
		pending = false;
		ready = false;
		shipped = false;
		this.itemBarcode = itemBarcode;
	}

	public Barcode getBarcode() {
		return itemBarcode;
	}

	public String getExpirationDate() {
		return expirationDate;
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

	public void setExpirationDate(String Date) {
		expirationDate = Date;
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
}
