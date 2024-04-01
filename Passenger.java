/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package flightdemo; 
 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** 
 * 
 * @author asus 
 */ 
public class Passenger { 
    private int passengerID; 
    private String passengerName; 
    private int passengerAge; 
    private int passengerMobile; 
 
    /**
     * This constructor intializes defualt
     */
    public Passenger() { 
    } 
 
     /**
     * This constructor intializes passengerID , passengerName , passengerAge , passengerMobile fields
     * @ param passengerID The ID of passenger
     * @ param passengerName The name of passenger
     * @ param passengerAge The age of passenger
     * @ param passengerMobile The mobile of passenger
     */
    public Passenger(int passengerID, String passengerName, int passengerAge, int passengerMobile) { 
        this.passengerID = passengerID; 
        this.passengerName = passengerName; 
        this.passengerAge = passengerAge; 
        this.passengerMobile = passengerMobile; 
    } 
 
     /**
      * getPassengerID method
      * @return passengerID The ID of passenger
      */
    public int getPassengerID() { 
        return passengerID; 
    } 
 /**
  * setPassengerID sets values for field
  * @param passengerID The ID of passenger 
  */ 
    public void setPassengerID(int passengerID) { 
        this.passengerID = passengerID; 
    } 
 /**
  * getPassengerName method
  * @return passengerName The name of passenger 
  */
    public String getPassengerName() { 
        return passengerName; 
    } 
 /**
  * setPassengerName set a value for field
  * @param passengerName The name of passenger 
  */
    public void setPassengerName(String passengerName) { 
        this.passengerName = passengerName; 
    } 
 /**
  * getPassengerAge method
  * @return passengerAge The age of passenger 
  */
    public int getPassengerAge() { 
        return passengerAge; 
    } 
 /**
  * setPassengerAge set value for field
  * @param passengerAge The age of passenger 
  */
    public void setPassengerAge(int passengerAge) { 
        this.passengerAge = passengerAge; 
    } 
 /**
  * getPassengerMobile method
  * @return passengerMobile The mobile of passenger  
  */
    public int getPassengerMobile() { 
        return passengerMobile; 
    } 
 /**
  * setPassengerMobile set value for field
  * @param passengerMobile The mobile of passenger 
  */
    public void setPassengerMobile(int passengerMobile) { 
        this.passengerMobile = passengerMobile; 
    } 
     
   
      /**
      * toString method
      * @return A string containing the passenger information
      */
    public String toString(){  
        return "Name:"+this.passengerName+"\nAge:" + this.passengerAge + "\nID:" + this.passengerID + "\nmobile number:" + this.passengerMobile; 
    } 
    /**
     * PassengerFile make a file containing customer information
     * @throws IOException 
     */
    public void PassengerFile()throws IOException{
        FileWriter FileWrite=new FileWriter("Passenger.txt",true);
        PrintWriter write=new PrintWriter(FileWrite);
        write.print(this.passengerID+"\t");
        write.print(this.passengerName+"\t");
        write.print(this.passengerAge+"\t");
        write.print(this.passengerMobile+"\t");
        write.close();
    }
}