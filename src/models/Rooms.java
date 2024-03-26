package models;

public class Rooms {
     private String name;
     private int noOfBeds;
     private int hostelId;
     private int id;
     private double price;
     private boolean available;


public Rooms(String name,boolean available, int noOfBeds,int hostelId, int id, int price){
    this.name=name;
    this.noOfBeds=noOfBeds;
    this.hostelId=hostelId;
    this.id=id;
    this.available=available;
    this.price=price;
}
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getHostelId() {
         return hostelId;
     }

     public void setHostelId(int hostelId) {
         this.hostelId = hostelId;
     }

     public int getNoOfBeds() {
         return noOfBeds;
     }

     public void setNoOfBeds(int noOfBeds) {
         this.noOfBeds = noOfBeds;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public boolean isAvailable() {
         return available;
     }

     public void setAvailable(boolean available) {
         this.available = available;
     }
 }
