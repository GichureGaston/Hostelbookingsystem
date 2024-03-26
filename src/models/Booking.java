package models;


 public class Booking {
     private int id;
     private String createdAt;
     private String bookedFrom;
     private String bookedUntil;
     private  int studentId;
     private  int roomId;
     private int bedNo;
     public Booking(int id,int bedNo, String createdAt,String bookedFrom, String bookedUntil,int studentId, int roomId){this.id=id;
       this.createdAt=createdAt;
       this.bookedFrom=bookedFrom;
       this.bedNo=bedNo;
       this.bookedUntil=bookedUntil;
       this.studentId=studentId;
       this.roomId=roomId;

     }

     public Booking(int id) {
     }

     public int getRoomId() {
         return roomId;
     }

     public int getStudentId() {
         return studentId;
     }

     public void setStudentId(int studentId) {
         this.studentId = studentId;
     }

     public String getBookedUntil() {
         return bookedUntil;
     }

     public void setBookedUntil(String bookedUntil) {
         this.bookedUntil = bookedUntil;
     }

     public String getBookedFrom() {
         return bookedFrom;
     }

     public void setBookedFrom(String bookedFrom) {
         this.bookedFrom = bookedFrom;
     }

     public String getCreatedAt() {
         return createdAt;
     }

     public void setCreatedAt(String createdAt) {
         this.createdAt = createdAt;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getBedNo() {
         return bedNo;
     }

     public void setBedNo(int bedNo) {
         this.bedNo = bedNo;
     }


 }

