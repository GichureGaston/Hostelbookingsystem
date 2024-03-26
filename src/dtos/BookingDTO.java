package dtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class BookingDTO {
    private Connection connection;

    // Constructor - Establishes the database connection
    public BookingDTO() {
        try {
            System.out.println("Welcome \n Connecting to database");
            String url = "jdbc:mariadb://localhost:3306/bookings";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection: " + e.getMessage());
        }
    }
    public void createBookingsTable(){
        try{System.out.println("Starting Booking Schema creation.");
            String createBookingsTableQuery ="CREATE TABLE IF NOT EXISTS Bookings("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    "createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"+
                    "bookedFrom DATE,"+
                    "bookedUntil DATE,"+
                    "int studentId ,"+
                    "int roomId , "+
                    "Int bedNo ,"+
                    "FOREIGN KEY (studentId) REFERENCES Student(id),"+
                    "FOREIGN KEY (roomId) REFERENCES Student(id)"+
                    "FOREIGN KEY (studentId) REFERENCES Student(id)";
            Statement createBookingsTableStatement= connection.createStatement();
            createBookingsTableStatement.execute(createBookingsTableQuery);
            createBookingsTableStatement.close();
            System.out.println("BookingsSchema created successfully.");


    } catch (SQLException e) {
            System.out.println("Failed to create BookingSchema:"+e.getMessage());

        }
    }
    // Method to insert data into table

    public boolean insertBookingDetails(int id ,String createdAt,String bookedFrom,String bookedUntil, int studentId,int roomId,int bedNo){
        String query="INSERT INTO Bookings(id,createdAt,bookedFrom,bookedUntil,studentId,roomId,bedNo)VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,createdAt);
            statement.setString(3,bookedFrom);
            statement.setString(4,bookedUntil);
            statement.setInt(5,studentId);
            statement.setInt(6,roomId);
            statement.setInt(7,bedNo);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0){
                System.out.println("Booking Details Inserted Successfully.");
                return true;
            }else {
                System.out.println("Failed to insert Booking Details.");
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to insert Booking Details." + e.getMessage());
            return false;

        }
        }
        //updating bookingDetails into table
        public boolean updateBookings(int id,String createdAt,String bookedFrom,String bookedUntil,int studentId,int roomId,int bedNo){
            String query="UPDATE Bookings SET id = id +?  SET createdAt=createdAt +? SET bookedFrom=bookedFrom +? SET bookedUntil=bookedUntil +? SET studentId=studentId +? WHERE roomId=+?";
            try {
                PreparedStatement statement =connection.prepareStatement(query);
                statement.setInt(1,id);
                statement.setString(2,createdAt);
                statement.setString(3,bookedFrom);
                statement.setString(4,bookedUntil);
                statement.setInt(5,studentId);
                statement.setInt(6,roomId);
                statement.setInt(7,bedNo);
                int rowsInserted= statement.executeUpdate();
                if(rowsInserted>0){
                    System.out.println("Booking made successfully");
                    return true;
                }else {
                    System.out.println("Failed to make booking.");
                    return false;
                }

            }
            catch (SQLException e){
                System.out.println("Failed to make booking:"+e.getMessage());
                return false;
            }

        }
        //Remove  booking
    public boolean removeBooking(int studentId){
        String query="DELETE FROM Bookings WHERE studentId=?";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(5, studentId);

            int rowsDeleted= statement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Booking Removed Successfully");
                return true;
            }else {
                System.out.println("Failed to Remove Booking.");
                return false;
            }

        }catch (SQLException e){
            System.out.println("Failed to Remove Booking:"+e.getMessage());
            return false;
        }
        }
    }



