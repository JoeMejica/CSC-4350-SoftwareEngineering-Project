package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import InventoryManagementSystem.SQLiteConnection;

public class Section {
	Item[] items=new Item[5];
	int numItems=0;
	private Connection conn = SQLiteConnection.Connector();
	
	public Section (){
	}
	
	public boolean checkSectionFull(String section) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int i = 0;
		String query = "SELECT * FROM items WHERE section = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, section);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				i++;
			}
			if (i >= 5) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			pstmt.close();
			rset.close();
		}
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
