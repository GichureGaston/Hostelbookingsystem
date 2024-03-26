package models;

 public class Hostels {
     private String name;
     private int noOfRooms;
     private int noOfBeds;
     private int id;
     public Hostels(String name,int noOfBeds, int noOfRooms,int id){
         this.name=name;
         this.noOfBeds=noOfBeds;
         this.noOfRooms=noOfRooms;
         this.id=id;
     }

     public Hostels(String name) {
     }

     public String getName() {
         return name;
     }

     public int getNoOfBeds() {
         return noOfBeds;
     }
     public int getNoOfRooms() {
         return noOfRooms;
     }
     public int getId(){
         return  id;
     }

 }
