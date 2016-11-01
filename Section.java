
public class Section {
	Item[] items=new Item[5];
	int numItems=0;
	public Section (){
		
	}
	public void addItem(Item newItem){
		numItems++;
		for (int i=0;i<items.length;i++){
			if (items[i]== null){
				items[i]=newItem;
			}
		}
	}
	public Item findItem(Barcode barcode){
		for(int i = 0;i<items.length;i++){
			if(items[i].getBarcode().equals(barcode)){
				return items[i];
			}
		}
		return null;
	}
	public int getNumItems(){
		return numItems;
	}
	public boolean sectionFull(){
		if(numItems<5){
			return false;
		}
		else
			return true;
	}
	public Item removeItem(Barcode barcode){
		Item returnItem;
		numItems--;
		for(int i = 0;i<items.length;i++){
			if(items[i].getBarcode().equals(barcode)){
				returnItem=items[i];
				items[i]= null;
				return returnItem;
			}
		}
		return null;
	}
}
