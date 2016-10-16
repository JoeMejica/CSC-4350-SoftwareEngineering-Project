
public class Contact{
	private static boolean checkEmail(String email){//checks for valid emails
		boolean hasAtSymbol=false,hasUsername=false, hasMailServer=false,hasDomain=false;
		for(int i=0;i<email.length();i++){
			if (i==0&&email.charAt(i)!='@')
				hasUsername=true;
			else if (hasUsername&&email.charAt(i)=='@'){
				hasAtSymbol=true;
			}
			else if(hasAtSymbol&&email.charAt(i)=='.'&&email.charAt(i-1)!='@'&&Character.isLetter(email.charAt(i+1))){
				hasMailServer=true;
				hasDomain=true;
			}
		
		}
		return hasMailServer;
	}
	private static boolean checkPhoneNumber(String PhoneNumber){//looking for a phone number in the form DDD-DDD-DDDD
		if (PhoneNumber.length()!=12){
			return false;
		}
		for (int i=0;i<12;i++){
			if(!(i!=3&&i!=7&&Character.isDigit(PhoneNumber.charAt(i)))){
				return false;
			}
		}
		return true;
	}
	private String phoneNumber;
	private String emailAddress;
	public Contact(String phoneNumber, String emailAddress){
		if (!checkEmail(emailAddress)){
		
		}
		else{
			this.emailAddress=emailAddress;	
		}
		if (!checkPhoneNumber(phoneNumber)){
		
		}
		else{
		this.phoneNumber=phoneNumber;
		}
	}
	public String getEmailAddress(){
		return emailAddress;
	}
	public void setEmailAddress(String newEmailAddress){
		if (!checkEmail(newEmailAddress)){
		
		}
		else{
			emailAddress=newEmailAddress;	
		}
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String newPhoneNumber){
		if (!checkPhoneNumber(newPhoneNumber)){
		throw
		}
		else{
			phoneNumber=newPhoneNumber;	
		}
	}
}
