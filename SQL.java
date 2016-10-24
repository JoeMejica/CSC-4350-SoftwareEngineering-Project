import java.sql.*;
import java.util.*;
public class SQL {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        String y,z;
        
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=node");
            Statement s=c.createStatement();
            int Result=s.executeUpdate("CREATE DATABASE IF NOT EXISTS DATA");
            System.out.println("Would you like to create the table 1 for yes, 2 for no");
            x=scan.nextInt();
            if(x==1){
                String use="USE DATA";
                s.executeUpdate(use);
                String table = "CREATE TABLE item(Barcode VARCHAR(12))";
                s.executeUpdate(table);
                System.out.println("Table Created");
            }else{
                String use="USE DATA";
                s.executeUpdate(use);
            }
            System.out.println("What would you like to do? Press the number of the option you would prefer" );
            System.out.println("1.Store Barcode");
            System.out.println("2.Remove Barcode");
            x=scan.nextInt();
            //ADD method
            if(x==1){
                System.out.println("Type in the Barcode of the item to add(12 characters and/or numbers)");
                y=scan.next();
                z="INSERT INTO item VALUES('"+y+"')";
                s.executeUpdate(z);
                s.close();
                System.out.println("Barcode Added");
            //Remove method
            }else if(x==2){
                System.out.println("Type in the Barcode of the item to delete(12 characters and/or numbers)");
                y=scan.next();
                z="DELETE FROM item WHERE Barcode ='"+y+"'";
                s.executeUpdate(z);
                s.close();
                System.out.println("Barcode Deleted");
            }else{
                System.out.println("Wrong input");
                s.close();
                c.close();
            }           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
