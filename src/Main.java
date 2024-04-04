import classRepositories.BookingRepository;
import classRepositories.HostelRepository;
import classRepositories.RoomsRepository;
import classRepositories.StudentsRepository;
import models.Booking;
import models.Hostels;
import models.Rooms;
import models.Students;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        StudentsRepository studentsRepository = new StudentsRepository();
        BookingRepository bookingRepository = new BookingRepository();
        HostelRepository hostelRepository = new HostelRepository();
        RoomsRepository roomsRepository = new RoomsRepository();
        System.out.println("|Welcome To HostelBooking Menu|");


        while (true) {
            // Create all schemas
            System.out.println("001. Create All Schemas");

            System.out.println("100. Insert Student Details");
            System.out.println("101. Update Students' Details");
            System.out.println("102. Remove Students, Details");
            System.out.println("103. Request For StudentDetails");
            System.out.println("104. Get all StudentDetails");


            System.out.println("201. Insert Booking Details");
            System.out.println("202. Update Booking Details");
            System.out.println("203. Booking Cancellation");

            System.out.println("300. Insert Hostel Details");
            System.out.println("301. Update Hostel Records");
            System.out.println("302. Remove Hostel Record");
            System.out.println("303. Request For Hostel Records");

            System.out.println("400. Insert Room Details");
            System.out.println("401. Update Room Details");
            System.out.println("402. Delete Room Record");
            System.out.println("403. Request for Room Details");



            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                // schemas
                case 001:
                    studentsRepository.createStudentsSchema();
                    break;
                //inserting studentData

                case 100:
                    System.out.println("Enter Student id:");
                    String studentIdI = scanner.nextLine();
                    System.out.println("Enter Student full name:");
                    String studentFullNameI = scanner.nextLine();
                    System.out.println("Enter Student Registration Number:");
                    String studentRegistrationI = scanner.nextLine();

                    studentsRepository.insertStudents(new Students(studentFullNameI, Integer.parseInt(studentIdI), studentRegistrationI));

                    break;
                //updatingStudentData
                case 101:
                    System.out.println("Enter New Student id:");
                    String studentIdU = scanner.nextLine();
                    System.out.println("Enter New Student full name:");
                    String studentFullNameU = scanner.nextLine();
                    System.out.println("Enter New Student Registration Number:");
                    String studentRegistrationU = scanner.nextLine();

                    studentsRepository.updateStudentDetails(new Students(studentFullNameU, Integer.parseInt(studentIdU), studentRegistrationU));


                    break;
                //removing student details by use of registration number
                case 103:

                    System.out.println("Enter Student Registration Number:");
                    String studentRegistrationD = scanner.nextLine();

                    studentsRepository.removeStudentDetails(String.valueOf(new Students(studentRegistrationD)));
                    break;

                //get report of students
                case 104:
                    System.out.println("Getting students details:");

                    @NotNull Students DefaultTableModel = null;
                    List<Students> studentList =studentsRepository.requestAllStudentDetails(DefaultTableModel);

                    for (Students student : studentList) {
                        System.out.println("Name: " + student.getName() + ", ID: " + student.getId() +
                                ", Registration Number: " + student.getRegistrationNumber());
                    }
                    break;

                // Creating New Booking

                case 201:
                    System.out.println("Enter ID");
                    String idI = scanner.nextLine();
                    System.out.println("Select Bed Number:");
                    String BedNoI = scanner.nextLine();
                    System.out.println("Booking Created At (Time)");
                    String createAtI = scanner.nextLine();
                    System.out.println("Enter Date You Wish To start Your Stay:");
                    String BookedFromI = scanner.nextLine();
                    System.out.println("Enter Date You Wish To End Your Stay:");
                    String BookedUntilI = scanner.nextLine();
                    System.out.println("Enter Your Student ID number:");
                    String StudentIdI = scanner.nextLine();
                    System.out.println("Enter RoomID:");
                    String RoomIDI= scanner.nextLine();

                    bookingRepository.insertBookingDetails(new Booking(Integer.parseInt(idI),Integer.parseInt(BedNoI), createAtI, BookedFromI, BookedUntilI, Integer.parseInt(StudentIdI), Integer.parseInt(RoomIDI)));
                    break;
                // Updating Booking Details
                case 202:

                    System.out.println("Enter ID");
                    String idU = scanner.nextLine();
                    System.out.println("Select Bed Number:");
                    String BedNoU = scanner.nextLine();
                    System.out.println("Booking Created At (Time)");
                    String createAtU = scanner.nextLine();
                    System.out.println("Enter Date You Wish To start Your Stay:");
                    String BookedFromU = scanner.nextLine();
                    System.out.println("Enter Date You Wish To End Your Stay:");
                    String BookedUntilU = scanner.nextLine();
                    System.out.println("Enter Your Student ID number:");
                    String StudentIdU = scanner.nextLine();
                    System.out.println("Enter RoomID:");
                    String RoomIDU= scanner.nextLine();

                    bookingRepository.updateBookingDetails(new Booking(Integer.parseInt(idU),Integer.parseInt(BedNoU), createAtU, BookedFromU, BookedUntilU, Integer.parseInt(StudentIdU), Integer.parseInt(RoomIDU)));

                    break;
                case 203:

                    System.out.println("Enter Your Student ID number:");
                    String StudentIdR= scanner.nextLine();

                    bookingRepository.removeBookingDetails(new Booking(Integer.parseInt(StudentIdR)));
                    break;

                //Hostel thingies
                case 300:
                    System.out.println("Enter Hostel Name");
                    String name=scanner.nextLine();
                    System.out.println("Enter Number Of Rooms In Hostel:");
                    String noOfRooms= scanner.nextLine();
                    System.out.println("Enter Number of Beds In the Hostel:");
                    String noOfBeds= scanner.nextLine();
                    System.out.println("Enter Hostel ID");
                    String id= scanner.nextLine();

                    hostelRepository.insertHostels(new Hostels(name), noOfRooms, noOfBeds, id);
                    break;
                case 301:
                    System.out.println("Enter Hostel Name");
                    String nameU=scanner.nextLine();
                    System.out.println("Enter Number Of Rooms In Hostel:");
                    String noOfRoomsU= scanner.nextLine();
                    System.out.println("Enter Number of Beds In the Hostel:");
                    String noOfBedsU= scanner.nextLine();
                    System.out.println("Enter Hostel ID");
                    String idUpdate = scanner.nextLine();

                    hostelRepository.insertHostels(new Hostels(nameU), noOfRoomsU, noOfBedsU, idUpdate);
                    break;
                case 302:
                    System.out.println("Enter Hostel Name");
                    String nameDelete= scanner.nextLine();

                    hostelRepository.deleteRecord(nameDelete);
                    break;
                case 303:

                    System.out.println("Enter Hostel Name");
                    String nameR=scanner.nextLine();
                    System.out.println("Enter Number Of Rooms In Hostel:");
                    String noOfRoomsR= scanner.nextLine();
                    System.out.println("Enter Number of Beds In the Hostel:");
                    String noOfBedsR= scanner.nextLine();
                    System.out.println("Enter Hostel ID");
                    String idRequest = scanner.nextLine();

                    hostelRepository.requestAllHostelDetails(new Hostels(nameR),noOfRoomsR,noOfBedsR,idRequest);
                    break;

                //Functions For Rooms Menu

                case 400:
                    System.out.println("Enter Room Name:");
                    String nameInsert= scanner.nextLine();
                    System.out.println("Enter Number Of Beds:");
                    String noOfBedsInsert= scanner.nextLine();
                    System.out.println("Enter HostelID:");
                    String hostelIDInsert= scanner.nextLine();
                    System.out.println("Enter ID:");
                    String IDInsert= scanner.nextLine();
                    System.out.println("Enter Room Price:");
                    String roomPriceInsert= scanner.nextLine();
                    System.out.println("Check Availability:");
                    String availabilityInsert= scanner.nextLine();


                    roomsRepository.insertRoomsDetails(new Rooms(nameInsert),Integer.parseInt(noOfBedsInsert),Integer.parseInt(hostelIDInsert),Integer.parseInt(IDInsert),Double.valueOf(roomPriceInsert),Boolean.getBoolean(availabilityInsert));
                    break;
                case 401:
                    System.out.println("Enter Room Name:");
                    String nameUpdate= scanner.nextLine();
                    System.out.println("Enter Number Of Beds:");
                    String noOfBedsUpdate= scanner.nextLine();
                    System.out.println("Enter HostelID:");
                    String hostelIDUpdate= scanner.nextLine();
                    System.out.println("Enter ID:");
                    String IDUpdate = scanner.nextLine();
                    System.out.println("Enter Room Price:");
                    String roomPriceUpdate = scanner.nextLine();
                    System.out.println("Check Availability:");
                    String availabilityUpdate = scanner.nextLine();


                    roomsRepository.updateRoomsTable(new Rooms(nameUpdate),Integer.parseInt(hostelIDUpdate));
                    break;
                case 402:
                    System.out.println("Enter Room Name:");
                    String nameRemove= scanner.nextLine();

                    roomsRepository.removeRoomRecord(new Rooms(nameRemove));

                    break;
                case 403:
                    System.out.println("Enter Room Name:");
                    String requestAll= scanner.nextLine();

                    //  roomsRepository.requestAllRoomInformation(new Rooms() );
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