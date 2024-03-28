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

public boolean createHostelTable(){
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
        return true;

    }catch (SQLException e){
        System.out.println("Failed to create Hostel Table:("+e.getMessage());

    }


    return false;
}
//Inserting Hostels
public boolean insertHostels(String name,int noOfRooms,int noOfBeds, int id){
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
            return true;
        }else {
            System.out.println("Failed to insert Hostel Details.");
            return false;
        }
    }
    catch (SQLException e){
        System.out.println("Failed to insert Hostel Details."+e.getMessage());
        return false;
        }

}
//update hostel details
public boolean updateHostels(String name, int noOfRooms,int noOfBeds,int id ){
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
                return true;
            }else {
                System.out.println("Failed to Update Hostel Details .");
                return false;
            }

        }catch (SQLException e){
            System.out.println("Failed to Update Hostel Details:"+e.getMessage());
        }
    return false;
}
    //delete hostel data
    public boolean deleteRecord(String name){
        String query ="DELETE FROM hostels WHERE name =?";
        try {

            //A SQL statement is precompiled and stored in a PreparedStatement object. This object can then be used to efficiently execute this statement multiple times.
            //Note: The setter methods (setShort, setString, and so on) for setting IN parameter values must specify types that are compatible with the defined SQL type of the input parameter. For instance, if the IN parameter has SQL type INTEGER, then the method setInt should be used.
            //If arbitrary parameter type conversions are required, the method setObject should be used with a target SQL type.
            //In the following example of setting a parameter, con represents an active connection:
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);

            int rowsDeleted= statement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Hostel Name Deleted  successfully");
                return true;
            }else {
                System.out.println("Failed to Delete Hostel Name .");
                return false;
            }

        }catch (SQLException e){
            System.out.println("Failed to Delete Hostel Name:"+e.getMessage());
        }
        return false;
    }
        //Request all Hostel details
    public boolean requestAllHostelDetails(DefaultTableModel hostels){
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
            System.out.println("Failed to Retrieve Hostel Details)" + e.getMessage());

        }
        return false;
    }
    }


