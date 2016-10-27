
public class Item {
	 private Barcode itemBarcode;
	 private double itemWeight;
	 private String itemName;
	 private String expirationDate;//if null there is no expiration date
	 private boolean reserved;
	 public Item(String name,double weight,Barcode itemBarcode,String expirationDate){//items with expiration date
		 reserved= false;
		 this.itemBarcode=itemBarcode;
		 itemWeight=weight;
		 this.expirationDate=expirationDate;
		 itemName=name;
	 }
	 public Item(double weight,Barcode itemBarcode){
		 reserved= false;
		 this.itemBarcode=itemBarcode;
		 itemWeight=weight;
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
	 public double getItemWeight(){
		 return itemWeight;
	 }
	 public String getItemName(){
		 return itemName;
	 }
	 public void setExpirationDate(String Date){
		 expirationDate=Date;
	 }
	 public void setReserved(boolean reserve){
		 reserved=reserve;
	 }
	 public void setItemWeight(double weight){
		 itemWeight=weight;
	 }
	 public void setItemName(String name){
		 itemName=name;
	 }
}
