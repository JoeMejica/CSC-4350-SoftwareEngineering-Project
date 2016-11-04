package Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ArrivalEvent {

  private String trackingNumber;
    private Calendar expectedArrDate;
    private boolean statPending,statShipped,statArrived;
    
    public ArrivalEvent(){
        trackingNumber = null;
        expectedArrDate = GregorianCalendar.getInstance();
        statPending = true;
        statShipped = false;
        statArrived = false;
    }
    
    public ArrivalEvent(String x){
       trackingNumber = x;
       expectedArrDate = GregorianCalendar.getInstance();
       statPending = true;
       statShipped = false;
       statArrived = false;
       
    }
    
    public void setTrackingNumber(String x){
        trackingNumber = x;
    }
    
    public String getTrackingNumber(){
        return  trackingNumber;
    }
    
    public void setExpArrDate(int month, int date, int year){
        expectedArrDate.set(year, month, date);
    }
    
    public Calendar getExpArrDate(){
        return expectedArrDate;
    }
    
    public void setPending(){
       statPending = true;
       statShipped = false;
       statArrived = false;
    }
    
    public void setShipped(){
       statPending = false;
       statShipped = true;
       statArrived = false; 
    }
    
    public void setArrived(){
       statPending = false;
       statShipped = false;
       statArrived = true; 
    }
    public String getStatus(){
        if (statPending)
            return "Pending";
        else if (statShipped)
             return "Shipped";
        else if (statArrived)
             return "Arrived";
        else return null;
    }
    
    
    @Override
     public String toString(){
         return  "Tracking number: " + trackingNumber + "\n"
                 + "Status: " + getStatus() + "\n" 
                 + "Expected Arrival Date: " + expectedArrDate+"\n";
     }
}
