
public class Item {
	 private Barcode itemBarcode;
	 double itemWeight;
	 private String expirationDate;//if null there is no expiration date
	 private boolean reserved;
	 public Item(double weight,String expirationDate){
		 reserved= false;
		 this.itemBarcode=itemBarcode;
	 }
	 public Barcode getBarcode(){
		 return itemBarcode;
	 }
	 public String getExpirationDate(){
		 return expirationDate;
	 }
	 public boolean getReserved(){
		 return reserved;
	 }
	 public void setExpirationDate(String Date){
		 expirationDate=Date;
	 }
	 public void setReserved(boolean reserve){
		 reserved=reserve;
	 }
}
