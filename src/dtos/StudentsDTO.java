package dtos;

import java.sql.*;

public class StudentsDTO {
    private Connection connection;

    // Constructor - Establishes the database connection
    public StudentsDTO() {
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

    //Create schema for students
    public void createStudentsSchema(){
        try{System.out.println("Starting students Schema creation.");
            String createStudentTableQuery ="CREATE TABLE IF NOT EXISTS students("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    "name TEXT NOT NULL,"+
                    "registrationNumber TEXT NOT NULL";
            Statement createStudentsTableStatement= connection.createStatement();
            createStudentsTableStatement.execute(createStudentTableQuery);
            createStudentsTableStatement.close();
            System.out.println("Schema created successfully.");



        }
        catch(SQLException e){
            System.out.println("Failed to create schema:"+e.getMessage());

        }
    }
    //Inserting students data in schema
    public void insertStudents(int id,String name,String registrationNumber){

        String query = "INSERT INTO Student(id ,name,registrationNumber )VALUES(?,?,?)";
        try{
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,registrationNumber);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted>0){
                System.out.println("Student Details Inserted Successfully.");
            }else {
                System.out.println("Failed to insert Student Details.");
            }
        }
        catch (SQLException e){
            System.out.println("Failed to insert Student Details."+e.getMessage());
        }

    }
    public void updatestudents(int id,String name,String registrationNumber){
       String query ="UPDATE bookings SET id=? ,name=?, registrationNumber=? ;";



    }
}
