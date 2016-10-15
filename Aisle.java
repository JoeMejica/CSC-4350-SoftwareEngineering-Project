
public class Aisle {
	private Section sections[]=new Section[20];
	private boolean sectionsFull[]= new boolean[20];
	public Aisle(){
		for (int i = 0;i<20;i++){
			sectionsFull[i]=false;
		}
	}
	public Item removeItem(Barcode barcode){
		int sectionNumber=barcode.getSectionNumberInt();
		Item returnItem=sections[sectionNumber].removeItem(barcode);
		if(returnItem!=null&&sectionsFull[sectionNumber]){
			sectionsFull[sectionNumber]=false;
		}
		return returnItem;
	}
	public void addItem(Item newItem){
		int sectionNumber=newItem.getBarcode().getSectionNumberInt();
		sections[sectionNumber].addItem(newItem);
		if(sections[sectionNumber].getNumItems()==5){
			sectionsFull[sectionNumber]=true;
		}
	}
	public boolean allSectionsFull(){//for use in Assign Aisle
		for(int i=0;i<sections.length;i++){
			if (!sectionsFull[i])
				return false;
		}
		return true;
	}
	public Item findItem(Barcode barcode){
		int sectionNumber=barcode.getSectionNumberInt();
		return sections[sectionNumber].findItem(barcode);
	}
}
