
public class Employee {
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String username;
	private String password;
	private Contact contactInformation;
	private Contact emergencyContact;
	private String emergencyContactName;
	private boolean admin;
	public Employee(String firstName, char middleInitial,String lastName, 
			String username, String PhoneNumber, String Email, 
			String emergencyContactName,String emergencyNumber, String emergencyEmail){
		this.firstName=firstName;
		this.middleInitial=middleInitial;
		this.lastName=lastName;
		this.username=username;
		password= "tempPass";
		contactInformation= new Contact(PhoneNumber,Email);
		emergencyContact=new Contact(emergencyNumber,emergencyEmail);
		this.emergencyContactName=emergencyContactName;
		admin=false;
	}
	public String getFirstName(){
		return firstName;
	}
	public char getMiddleInitial(){
		return middleInitial;
	}
	public String getLastName(){
		return lastName;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return contactInformation.getEmailAddress();
	}
	public String getPhoneNumber(){
		return contactInformation.getPhoneNumber();
	}
	public String getEmergencyContactName(){
		return emergencyContactName;
	}
	public String getEmergencyContactNumber(){
		return emergencyContact.getPhoneNumber();
	}
	public String getEmergencyContactEmail(){
		return emergencyContact.getEmailAddress();
	}
	public boolean getAdmin(){
		return admin;
	}
	public void setFirstName(String newName){
		firstName=newName;
	}
	public void setMiddleInitial(char newInitial){
		middleInitial=newInitial;
	}
	public void setLastName(String newLastName){
		lastName=newLastName;
	}
	public void setPassword(String newPass){
		password=newPass;
	}
	public void setEmail(String newEmail){
		contactInformation.setEmailAddress(newEmail);
	}
	public void setPhoneNumber(String newNumber){
		contactInformation.setPhoneNumber(newNumber);
	}
	public void setEmergencyContactName(String newName){
		emergencyContactName=newName;
	}
	public void setEmergencyContactNumber(String newNumber){
		emergencyContact.setPhoneNumber(newNumber);
	}
	public void setEmergencyContactEmail(String newEmail){
		emergencyContact.setEmailAddress(newEmail);
	}
/*	reserveStock();
	removeBarcode();
	assignArrivalStatus();
	assignDepartureStatus();*/
	
}
