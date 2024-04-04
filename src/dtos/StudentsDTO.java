package dtos;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class StudentsDTO {
    private Connection connection;

    // Constructor - Establishes the database connection
    public StudentsDTO() {
        try {
            System.out.println("Welcome \n Connecting to database");
            String url = "jdbc:mariadb://localhost:3306/bookings";
            String user = "root";
            String password = "atomtech19";
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
    public void createStudentsSchema() {
        try {
            System.out.println("Starting students Schema creation.");
            String createStudentTableQuery = "CREATE TABLE IF NOT EXISTS students(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    "name TEXT NOT NULL," +
                    "registrationNumber TEXT NOT NULL";
            Statement createStudentsTableStatement = connection.createStatement();
            createStudentsTableStatement.execute(createStudentTableQuery);
            createStudentsTableStatement.close();
            System.out.println("Schema created successfully.");


        } catch (SQLException e) {
            System.out.println("Failed to create schema:" + e.getMessage());

        }
    }

    //Inserting students data in schema
    public boolean insertStudents(int id, String name, String registrationNumber) {

        String query = "INSERT INTO students(id ,name,registrationNumber )VALUES(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, registrationNumber);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student Details Inserted Successfully.");
                return true;
            } else {
                System.out.println("Failed to insert Student Details.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert Student Details." + e.getMessage());
        }

        return false;
    }

    //update student details
    public boolean updateStudentDetails(int id, String name, String registrationNumber) {
        String query = " UPDATE students SET id=id +? SET name=name +? WHERE registrationNumber +?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, registrationNumber);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student Details Updated Successfully.");
                return true;
            } else {
                System.out.println("Failed to Update Student Details.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to Update Student Details." + e.getMessage());
            return false;
        }
    }

    //Remove Student Details
    public boolean removeStudentDetails(String registrationNumber) {
        String query = "DELETE FROM students WHERE registrationNumber =?";


        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(3, registrationNumber);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student Details Removed  successfully");
                return true;
            } else {
                System.out.println("Failed to remove Student Details  .");
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Failed to remove Student Details");
            return false;
        }
    }

    public boolean requestAllStudentDetails(DefaultTableModel students) {
        String query = "SELECT * FROM students";
        students.setRowCount(0);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("fullName");
                String registrationNumber = resultSet.getString("registrationNumber");


                students.addRow(new Object[]{id, name, registrationNumber});
                return true;
            }
            resultSet.close();
            statement.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to Retrieve Students' Details)" + e.getMessage());
            return false;

        }

    }
}





