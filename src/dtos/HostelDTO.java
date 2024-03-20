package dtos;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class HostelDTO {
    private Connection connection;

    // Constructor - Establishes the database connection
    public HostelDTO() {
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

public void createHostelTable(){
    try {
        String createHostelTableQuery="CREATE TABLE IF NOT EXISTS hostels("+
                "name TEXT NOT NULL,"+
                "noOfRooms INTEGER NOT NULL"+
                "noOfBeds INTEGER NOT NULL"+
                "id INTEGER)";
        Statement createHostelsTableStatement=connection.createStatement();
        createHostelsTableStatement.execute(createHostelTableQuery);
        createHostelsTableStatement.close();
        System.out.println("Created Hostels Table Successfully");
    }catch (SQLException e){
        System.out.println("Failed to create Hostel Table:("+e.getMessage());
    }

}
//Inserting Hostels
public void insertHostels(String name,int noOfRooms,int noOfBeds, int id){
    String query="INSERT INTO hostels (name ,noOfRooms ,noOfBeds, id)VALUES(?,?,?,?)";
    try {
        PreparedStatement statement=connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setInt(2,noOfRooms);
        statement.setInt(3,noOfBeds);
        statement.setInt(4,id);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted>0){
            System.out.println("Hostel Details Inserted Successfully.");
        }else {
            System.out.println("Failed to insert Hostel Details.");
        }
    }
    catch (SQLException e){
        System.out.println("Failed to insert Hostel Details."+e.getMessage());
        }

}
//update hostel details
public void updateHostels(String name, int noOfRooms,int noOfBeds,int id ){
        String query="UPDATE hostels SET name =name +? SET noOfRooms=noOfRooms +? SET noOfBeds=noOfBeds +? WHERE id+?";
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,noOfRooms);
            statement.setInt(3,noOfBeds);
            statement.setInt(4,id);
            int rowsInserted= statement.executeUpdate();
            if(rowsInserted>0){
                System.out.println("Hostel Details Updated  successfully");
            }else {
                System.out.println("Failed to Update Hostel Details .");
            }

        }catch (SQLException e){
            System.out.println("Failed to Update Hostel Details:"+e.getMessage());
        }
    }
    //delete hostel data
    public void deleteRecord(String name){
        String query ="DELETE FROM hostels WHERE name =?";
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);

            int rowsDeleted= statement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Hostel Name Deleted  successfully");
            }else {
                System.out.println("Failed to Delete Hostel Name .");
            }

        }catch (SQLException e){
            System.out.println("Failed to Delete Hostel Name:"+e.getMessage());
        }
        }
        //Request all Hostel details
    public void requestAllHostelDetails(DefaultTableModel hostels){
        String query ="SELECT * FROM hostels";
             hostels.setRowCount(0);
        try {
          Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int noOfRooms = resultSet.getInt("noOfRooms");
                int noOfBeds = resultSet.getInt("noOfBeds");
                int id = resultSet.getInt("id");

                hostels.addRow(new Object[]{name,noOfRooms,noOfBeds,id});
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Failed to Retrieve Hostel Details)"+ e.getMessage());
        }
    }
    }


