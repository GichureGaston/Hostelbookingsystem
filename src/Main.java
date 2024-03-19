import models.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();
        System.out.println("Welcome to hostel booking");

        System.out.println(" Connecting to database");
        while (true){
            System.out.println("1. Get Hostels");
            System.out.println("2. Get Available rooms");
            System.out.println("3. Add Student ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("In works : ");
                    break;

                case 2:
                    System.out.print("Enter hostel name : ");
                    String hostelName = scanner.nextLine();
                    bookingSystem.displayAvailableRooms(hostelName);
                    break;
                case 3:
                    System.out.println("Add Student id:");
                    String studentId = scanner.nextLine();
                    System.out.println("Add Student full name:");
                    String studentFullName = scanner.nextLine();
                    System.out.println("Add Student REgNO:");
                    String studentRegistration = scanner.nextLine();
                    // ADD Y/N

                    bookingSystem.createStudent(new Students(studentFullName ,Integer.parseInt(studentId),studentRegistration));

                    break;
                case 4:
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

//        String url = "jdbc:mariadb://localhost:3306/bookings";
//        String user = "root";
//        String password = "";
//        try {
//            Connection connection = DriverManager.getConnection(url, user, password);
//            if (connection != null) {
//                System.out.println("Connected to the database!");
//                connection.close(); // Don't forget to close the connection when done
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Connection failed! Error: " + e.getMessage());
//        }
    }
}