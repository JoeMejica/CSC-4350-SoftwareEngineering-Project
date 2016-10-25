/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incomingshipments;

import java.util.LinkedList;


public class IncomingShipments{

    private LinkedList<arrivalEvent> incomingShips; 
    private int currArrEventIndex;
    
    public IncomingShipments(){
        incomingShips = new LinkedList<arrivalEvent>(); 
    }
    
    
    
    public void addNewArrEvent(arrivalEvent event){
        for(int i=0; i<incomingShips.size();i++){
            if(event.getExpArrDate().before(incomingShips.get(i).getExpArrDate())){
                incomingShips.add(i,event);
                currArrEventIndex = i;
                break;  
            }
        }
        if(!incomingShips.contains(event)){
            incomingShips.add(event);
            currArrEventIndex = incomingShips.indexOf(event);
        }
        
    }
    
    public void chCurrentEveDate(int month, int date, int year){
        arrivalEvent temp = incomingShips.remove(currArrEventIndex);
        
        temp.setExpArrDate(month, date, year);
        
        addNewArrEvent(temp);
        
    }
    
    public void chCurrentTrackingNum(String x){
        incomingShips.get(currArrEventIndex).setTrackingNumber(x);
    }
    
    public void setCurrentArrEvent(arrivalEvent event){
        currArrEventIndex = incomingShips.indexOf(event);
    }
    
    
    
    public arrivalEvent getCurrentArrEvent(){
        return incomingShips.get(currArrEventIndex);
    }
    
    public LinkedList<arrivalEvent> getIncomingShipList(){
        return incomingShips;
    }
    
    
    
    
    
}
