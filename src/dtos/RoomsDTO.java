package dtos;

import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class RoomsDTO {
    private Connection connection;

    public RoomsDTO() {
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
    //Creation of the Rooms Table
    public boolean createRoomsTable(){
        try {
            String createRoomsTableQuery = "CREATE IF NOT EXISTS rooms(" +
                    "name TEXT NOT NULL" +
                    "noOfBeds INTEGER NOT NULL" +
                    "hostelId INTEGER NOT NULL" +
                    "id INTEGER NOT NULL" +
                    "price REAL NOT NULL" +
                    "available  BOOL NOT NULL";
            Statement createRoomsTableStatement = connection.createStatement();
            createRoomsTableStatement.execute(createRoomsTableQuery);
            createRoomsTableStatement.close();

            System.out.println("Rooms Table created Successfully");
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to create Rooms Table:"+e.getMessage());
        }
        return false;
    }
    // Inserting Data Into the Room Table
    public boolean insertRoomDetails(String name,int noOfBeds,int hostelId,int id, double price,boolean available){
        String query="INSERT INTO rooms(name,noOfBeds,hostelId,id,price,available)VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,noOfBeds);
            statement.setInt(3,hostelId);
            statement.setInt(4,id);
            statement.setDouble(5,price);
            statement.setBoolean(6,available);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0){
                System.out.println("Room Details Inserted Successfully.");
                return available;
            }else {
                System.out.println("Failed to insert Room Details.");
                return false;
            }
        }catch (SQLException e){
        System.out.println("Failed to insert Room Details:"+e.getMessage());

        }
        return false;


    }
    //updating Data in RoomTable
    public boolean updateRoomsTable(String name,int noOfBeds,int hostelId,int id, double price,boolean available){
        String query="UPDATE rooms SET name=name +? SET noOfBeds=noOfBeds +? SET  hostelId=hostelId +? SET id=id +? SET price=price +? WHERE available=available";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,noOfBeds);
            statement.setInt(3,hostelId);
            statement.setInt(4,id);
            statement.setDouble(5,price);
            statement.setBoolean(6,available);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0){
                System.out.println("Room Details Updated Successfully.");
                return true;
            }else {
                System.out.println("Failed to Update Room Details.");
                return false;
            }
        }catch (SQLException e){
            System.out.println("Failed to Update Room Details:"+e.getMessage());
            return false;

        }
    }
    //removing Data from room table
    public boolean removeRoomRecord(String name){
        String query="DELETE FROM rooms WHERE name=?";
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,name);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted>0){
                System.out.println("Room Details Updated Successfully.");
                return true;
            }else {
                System.out.println("Failed to Update Room Details.");
                return false;
            }
        }catch (SQLException e){
            System.out.println("Failed to Update Room Details:"+e.getMessage());
            return false;

        }
    }
    public boolean requestAllRoomInformation(@NotNull DefaultTableModel rooms){
        String query="SELECT * FROM rooms";
        rooms.setRowCount(0);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name=resultSet.getString("roomName");
                int noOfBeds=resultSet.getInt("Number of beds");
                int hostelId=resultSet.getInt("Hostel Id")   ;
                int id=resultSet.getInt("id");
                double price=resultSet.getDouble("Room Pricing");
                boolean available= resultSet.getBoolean("Room Availability");
            }
    }catch (SQLException e){
            System.out.println("Failed to Retrieve Room Data"+e.getMessage());
            return false;
        }

return true;
    }
}
