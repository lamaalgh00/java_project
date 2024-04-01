/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightdemo;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author asus
 */
public class FlightDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         String name="";
            int id=0;
            int age=0;
            int mobile=0;
            String fromCity=""; 
            String toCity=""; 
            String cabin=""; 
            double price=0; 
            int rows = 4;
            int columns = 10;
            int row=0;
            int column=0;
            String day=""; 
            String time="18:00";
            int x;
            boolean y=true;
            ArrayList<Passenger>Pass=new ArrayList<>();
            ArrayList<FlightDetails>Flight=new ArrayList<>();
            ArrayList<Ticket>Tick=new ArrayList<>();
            
            Scanner keyboard = new Scanner(System.in);
            Scanner key = new Scanner(System.in);
            do{
            System.out.println("----------------------------\n"
                    + "Welcome to Airline Reservation System\n"
                    + "Choose the number you want to:\n"
                    + "1- Book a new flight\n"
                    + "2- Display your booked ticket\n"
                    + "3- Exit\n"
                    + "----------------------------\n");
            x= keyboard.nextInt();
            
            // input vaildation
            while(x<1 || x>3){
                System.out.println("Wrong choice, Try again:");
                 x= keyboard.nextInt();
            }
           
            switch (x) {
                case 1:
                    System.out.println("Enter your Name:");
                    name=key.nextLine();
                    // input validation
                    while(!checkValidation(name)){
                        System.out.println("invaild name! try again:"); 
                        name=key.nextLine();
                    } 
                    System.out.println("Enter your ID:");
                    id=keyboard.nextInt();
                    // input vaildation
                    while(id<0){
                        System.out.println("Invaild! try another number:");
                    id=keyboard.nextInt();
                    }
                    System.out.println("Enter your Age:");
                    age=keyboard.nextInt();
                    // input vaildation
                    while(age<0){
                        System.out.println("Invaild! try another number:");
                    age=keyboard.nextInt();
                    }
                    System.out.println("Enter your phone number:");
                    mobile=keyboard.nextInt();
                    // input vaildation
                    while(mobile<0){
                        System.out.println("Invaild! try another number:");
                    mobile=keyboard.nextInt();
                    }
                    Passenger passenger= new Passenger(id,name,age,mobile);
                    passenger.PassengerFile();
                    Pass.add(passenger);
                            
                    System.out.println("Enter 1 for Jeddah , 2 for Dammam , 3 for Riyadh ");
                    System.out.println("Which city you're from?");
                    int choice=keyboard.nextInt();
                    // input vaildation
                    while(choice<1 || choice>3){
                    System.out.println("Wrong choice, Try another number:");
                    choice= keyboard.nextInt(); } // End While
                        switch (choice) {
                            case 1:
                            fromCity = "Jeddah";
                                break;
                            case 2:
                            fromCity = "Dammam";
                                break;
                                case 3:
                            fromCity = "Riyadh";
                                break;
                        }
                        System.out.println("Which city you want to go?");
                    choice=keyboard.nextInt();
                    // input vaildation
                    while(choice<1 || choice>3){
                    System.out.println("Wrong choice, Try another number:");
                    choice= keyboard.nextInt();}
                        switch (choice) {
                            case 1:
                            toCity = "Jeddah";
                                break;
                            case 2:
                            toCity = "Dammam";
                                break;
                                case 3:
                            toCity = "Riyadh";
                                break;
                        
                    } // End Switch
                    ArrayList<String>list=new ArrayList<>();
                    list.add("Jeddah to Dammam");
                    list.add("Jeddah to Riyadh");
                    list.add("Riyadh to Dammam");
                    list.add("Riyadh to Jeddah");
                    list.add("Dammam to Riyadh");
                    list.add("Dammam to Jeddah");
                    String trip;
                    // Declare an array of seats for every trip
                    boolean seat01[][]=new boolean[rows][columns];
                    boolean seat02[][]=new boolean[rows][columns]; 
                    boolean seat03[][]=new boolean[rows][columns]; 
                    boolean seat04[][]=new boolean[rows][columns]; 
                    boolean seat11[][]=new boolean[rows][columns];
                    boolean seat12[][]=new boolean[rows][columns]; 
                    boolean seat13[][]=new boolean[rows][columns]; 
                    boolean seat14[][]=new boolean[rows][columns];
                    boolean seat21[][]=new boolean[rows][columns];
                    boolean seat22[][]=new boolean[rows][columns]; 
                    boolean seat23[][]=new boolean[rows][columns]; 
                    boolean seat24[][]=new boolean[rows][columns]; 
                    
                    if(fromCity.equalsIgnoreCase("Jeddah") && toCity.equalsIgnoreCase("Dammam")){ // Jeddah to Dammam
                    trip = list.get(0);
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 360 : 180 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat01[row][column]== true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat01[row][column]=true;} 
                                break;
                            case"Friday":
                                if(seat02[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat02[row][column]=true;} 
                                break;
                                
                        } // End Swtich
                      
                    } // End if
                    else if (fromCity.equals("Jeddah") && toCity.equals("Riyadh")){ // Jeddah to Riyadh
                    trip= list.get(1) ;
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 440 : 220 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    } 
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat03[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat03[row][column]=true;} 
                                break;
                            case"Friday":
                                if(seat04[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat04[row][column]=true;} 
                                break;
                         }}
                    else if(fromCity.equals("Riyadh") && toCity.equals("Dammam")){ // Riyadh to Dammam
                    trip=list.get(2);
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 300 : 150 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    } 
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat11[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat11[row][column]=true;} 
                                break;
                            case"Friday":
                                if(seat12[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat12[row][column]=true;} 
                                break;
                         }} // End else if 
                    
                    else if (fromCity.equals("Riyadh") && toCity.equals("Jeddah")){ // Riyadh to Jeddah
                    trip=list.get(3) ;
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 400 : 200 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    } 
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat13[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat13[row][column]=true;} 
                                break;
                            case"Friday":
                                if(true==seat14[row][column]){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat14[row][column]=true;} 
                                break;
                         }}
                    else if(fromCity.equals("Dammam") && toCity.equals("Riyadh")){ // Dammam to Riyadh
                    trip=list.get(4);
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 300 : 150 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    } 
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat21[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat21[row][column]=true;} 
                                break;
                            case"Friday":
                                if(seat22[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat22[row][column]=true;} 
                                break;
                         }}
                    else if(fromCity.equals("Dammam") && toCity.equals("Jeddah")){ // Dammam to Jeddah
                    trip=list.get(5) ;
                    System.out.println("Which cabin would you like? 1 for first class or 2 for guest:");
                    choice=keyboard.nextInt();
                     while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    }
                    price = (choice ==1 )? 460 : 230 ;
                    cabin = (choice ==1 )? "First Class" : "Guest";
                    System.out.println("Which day you prefer? 1 for Tuesday or 2 for Friday:");
                    choice = keyboard.nextInt();
                    // input validation
                    while(choice!=1 && choice!=2){
                        System.out.println("Invaild, try again:");
                        choice = keyboard.nextInt();
                    } 
                    day=(choice==1)?"Tuesday":"Friday"; // if choice 1 equal ro tuesday, else friday
                        System.out.println("Choose Your Seat:");
                        System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        } 
                        // after choosing row and column check if they had been taken
                         switch (day) {
                            case "Tuesday":
                                if(seat23[row][column]==true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat23[row][column]=true;} 
                                break;
                            case"Friday":
                                if(seat24[row][column] == true){
                             System.out.println("The seat alreday taken, Try another one:");
                             System.out.println("Enter row (from 1 to 4 ):");
                        row=keyboard.nextInt();
                        while(row<1 || row>4){
                            System.out.println("Invaild!");
                            System.out.println("Enter row (from 1 to 4 ):");
                            row=keyboard.nextInt();
                        }
                        System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                         while(column<1 || column>10){
                            System.out.println("Invaild!");
                            System.out.println("Enter column ( from 1 to 10 ):");
                        column=keyboard.nextInt();
                        }
                         }
                         else
                         {seat24[row][column]=true;} 
                                break;
                         }}
                    else;
                   FlightDetails flight = new FlightDetails(fromCity,toCity,cabin,price,day,time,row,column);
                   
                   System.out.println(passenger.toString());
                   System.out.println(flight.toString());
                   flight.FDFile();
                   Flight.add(flight);
                   Ticket ticket = new Ticket(passenger,flight);
                   ticket.TicketWrite();
                   Tick.add(ticket);
                   System.out.println(ticket.toString());
                   
                   break;
               
                case 2:

                   Ticket read=new Ticket();
                   read.TicketRead();
        
          
                    break;
                case 3:
                    System.out.println("Thank you For Booking with us!"); 
                    y=false;
                    break;
                    
            } // End of switch
    
} while(y==true);
    
    }
/**
 * checkVaildation method Check validation of name
 * @param n take name of passenger
 * @return boolean value if name vaild to use 
 */
    public static boolean checkValidation(String n){
        return Pattern.matches("[a-zA-Z\t]+" , n);
    }
           
    
    
}
