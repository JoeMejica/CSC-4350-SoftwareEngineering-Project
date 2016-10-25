/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incomingshipments;

/**
 *
 * @author LungsSoMuddy
 */
public class testIncomingShipments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IncomingShipments testIncomingShips = new IncomingShipments();
        //Testing create new arrival events
        
        //Create new arrival event
        arrivalEvent testEvent = new arrivalEvent();
        testIncomingShips.addNewArrEvent(testEvent);
        
        arrivalEvent testEvent1 = new arrivalEvent();
        testIncomingShips.addNewArrEvent(testEvent1);
        
        arrivalEvent testEvent2 = new arrivalEvent();
        testIncomingShips.addNewArrEvent(testEvent2);
        System.out.println("Test create new arrival events");
        for(int i = 0; i<testIncomingShips.getIncomingShipList().size();i++){
            System.out.println(testIncomingShips.getIncomingShipList().get(i));
        }
        
        //Modify existing events
        //Only the current arrival event can be modified
        testIncomingShips.chCurrentTrackingNum("1Z 999 AA1 01");
        testIncomingShips.chCurrentEveDate(10, 24, 69);
        testIncomingShips.getCurrentArrEvent().setArrived();
        
        System.out.println("Test modify existing arrival event");
         for(int i = 0; i<testIncomingShips.getIncomingShipList().size();i++){
            System.out.println(testIncomingShips.getIncomingShipList().get(i));
        }
        
       
        
        
   
        
        
    }
    
}
