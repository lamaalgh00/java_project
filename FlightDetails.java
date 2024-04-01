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
public class FlightDetails { 
     
    private String fromCity; 
    private String toCity; 
    private String cabin; 
    private double price; 
    private int row;
    private int colunm;
    private String day; 
    private String time; 
 
    /**
     * This constructor intializes defualt
     */
    public FlightDetails() { 
    } 
 
    /**
     * This constructor intializes fromCity , toCity , cabin , price , row , colunm , day , time fields 
     * @param fromCity The city passenger came from
     * @param toCity The city passenger going to
     * @param cabin the cabin that user chose
     * @param price the price of the trip 
     * @param row the row of seat
     * @param colunm the colunm of seat
     * @param day the day of trip
     * @param time the time of trip
     */ 
    public FlightDetails(String fromCity, String toCity, String cabin, double price, String day, String time, int row, int colunm) { 
        this.fromCity = fromCity; 
        this.toCity = toCity; 
        this.cabin = cabin; 
        this.price = price;  
        this.day = day; 
        this.time = time; 
      this.row = row;
      this.colunm= colunm;
    }
 /**
  * getFromCity method
  * @return fromCity the city passenger came from
  */
    public String getFromCity() { 
        return fromCity; 
    } 
 /**
  * setFromCity sets a value for field
  * @param fromCity the city passenger came from
  */
    public void setFromCity(String fromCity) { 
        this.fromCity = fromCity; 
    } 
 /**
  * getToCity method
  * @return toCity The city passenger going to
  */
    public String getToCity() { 
        return toCity; 
    } 
 /**
  * setToCity sets a value for field
  * @param toCity The city passenger going to 
  */
    public void setToCity(String toCity) { 
        this.toCity = toCity; 
    } 
 /**
  * getCabin method
  * @return cabin the cabin that user chose
  */
    public String getCabin() { 
        return cabin; 
    } 
 /**
  * setCabin sets a value for field
  * @param cabin the cabin that user chose 
  */
    public void setCabin(String cabin) { 
        this.cabin = cabin; 
    } 
 /** getPrice method
  * @return price the price of the trip 
  */
    public double getPrice() { 
        return price; 
    } 
 /**
  * setPrice
  * @param price the price of the trip  
  */
    public void setPrice(double price) { 
        this.price = price; 
    } 
/**
 * getRow method
 * @return row the row of seat
 */
    public int getRow() {
        return row;
    }
/**
 * setRow method sets value for field
 * @param row the row of seat 
 */
    public void setRow(int row) {
        this.row = row;
    }
/**
 * getColunm method
 * @return colunm the colunm of seat
 */
    public int getColunm() {
        return colunm;
    }
/**
 * SetColunm method sets value for field
 * @param colunm the colunm of seat
 */
    public void setColunm(int colunm) {
        this.colunm = colunm;
    }
 /**
  * getDay method 
  * @return day the day of trip
  */
    public String getDay() { 
        return day; 
    } 
 /**
  * setDay method sets value for fields
  * @param day the day of trip 
  */
    public void setDay(String day) { 
        this.day = day; 
    } 
 /**
  * getTime method
  * @return time the time of trip
  */
    public String getTime() { 
        return time; 
    } 
 /** 
  * setTime sets value for field
  * @param time the time of trip 
  */
    public void setTime(String time) { 
        this.time = time; 
    } 
     /**
      * toString method
      * @return A string containing the fight details
      */
    public String toString(){  
        return "From:" + this.fromCity + "\nTo:" + this.toCity + "\nCabin:" + this.cabin + "\nDay:" + this.day + "\nTime:" + this.time + "\nSeat:" +this.row+this.colunm; 
    } 
    /**
     * FDFile method to make a file contain flight details
     * @throws IOException 
     */
       public void FDFile()throws IOException{
        FileWriter FileWrite=new FileWriter("FlightDetails.txt",true);
        PrintWriter write=new PrintWriter(FileWrite);
        write.print(this.fromCity+"\t");
        write.print(this.toCity+"\t");
        write.print(this.cabin+"\t");
        write.print(this.price+"\t");
        write.print(this.row+"\t");
        write.print(this.colunm+"\t");
        write.print(this.day+"\t");
        write.print(this.time+"\t");
        
        write.close();
    }
}