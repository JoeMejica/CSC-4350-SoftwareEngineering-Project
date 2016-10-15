
public class Barcode {
	private char AisleLetter;
	private String sectionNumber;
	private String ItemNumber;
	public Barcode(){
		assignAisle();//requires initialized database
		assignItemNumber();//requires initialized database
		assignSection();//requires initialized database		
	}
	public String getBarcode(){
		return AisleLetter+"-"+sectionNumber+"-"+ItemNumber;
	}
	public char getAisleLetter(){
		return AisleLetter;
	}
	public String getSectionNumber(){
		return sectionNumber;
	}
	public int getSectionNumberInt(){
		return Integer.parseInt(sectionNumber);
	}
	public String getItemNumber(){
		return ItemNumber;
	}
	public boolean equals(Barcode barcode){
		if (this.AisleLetter==barcode.getAisleLetter()
				&&this.getSectionNumber().equals(barcode.getSectionNumber())
				&&this.getItemNumber().equals(barcode.getItemNumber())){
			return true;
		}
		else
			return false;
	}
}
