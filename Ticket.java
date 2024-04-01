/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author asus
 */
public class Ticket extends FlightDetails {
    
    private Passenger passenger;
    private FlightDetails flightDetails;
    double discount=0;
    Scanner keyboard=new Scanner(System.in);

    /**
     * This constructor intializes defualt
     */
    public Ticket() {
    }

    /**
     * This constructor intializes passenger , flightDetails fields
     * @param passenger passenger object
     * @param flightDetails flight details object
     */
    public Ticket(Passenger passenger, FlightDetails flightDetails) {
        this.passenger = passenger;
        this.flightDetails = flightDetails;
    }
/**
 * getPassenger method 
 * @return passenger passenger object
 */
    public Passenger getPassenger() {
        return passenger;
    }
/**
 * setPassenger set value for object
 * @param passenger passenger object 
 */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
/**
 * getFlightDetails method
 * @return flightDetails flight details object
 */
    public FlightDetails getFlightDetails() {
        return flightDetails;
    }
/**
 * setFlightDetails
 * @param flightDetails flight details object 
 */
    public void setFlightDetails(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }
    /**
     * calculateDiscount method make a discount foe every student in University of Jeddah
     */
    public void calculateDiscount(){
        System.out.println("Are you an employee or student in Univrsity of Jeddah?");
        String answer = keyboard.nextLine();
        if(answer.equalsIgnoreCase("Yes")){
        discount=(flightDetails.getPrice()*0.50);
            System.out.println("You deserve a 50% discount!");
    } 
        else{
        System.out.println("You don't have a discount");}
        
               
    }
      /**
      * toString method
      * @return A string containing the ticket information
      */
    @Override
    public String toString(){
        calculateDiscount();
        String x = (discount!=0)? "\nPrice after discount:" + discount: "" ;
        return "Price: " + flightDetails.getPrice() + x ;
    }
    /**
     * TicketWrite write in file method
     * @throws IOException 
     */
   public void TicketWrite()throws IOException{
        FileWriter FileWrite=new FileWriter("Ticket.txt",true);
        try (PrintWriter write = new PrintWriter(FileWrite)) {
            write.print("\n"+this.passenger+"\t");
            write.print("\n"+this.flightDetails+"\t");
            write.print("\nPrice:" +flightDetails.getPrice()+"\t");
            write.print("\n"+discount+"\t");
        }
     
    }
   /**
     * TicketRead read from file method
     * @throws IOException 
     */
   public void TicketRead()throws IOException{
       File file;
        file = new File("Ticket.txt");
         Scanner read = new Scanner(file);
            while(read.hasNext()){
                System.out.println(read.nextLine());
            }
        }
   }



