import dtos.StudentsDTO;
import models.Booking;
import models.Hostels;
import models.Rooms;
import models.Students;

import java.util.ArrayList;

public class BookingSystem {
    protected ArrayList<Booking> bookings;
    protected  ArrayList<Rooms> rooms;
    protected ArrayList<Hostels> hostels;
    protected ArrayList<Students> students;


    public  BookingSystem(){
        bookings =new ArrayList<>();
        rooms = new ArrayList<>();
        hostels = new ArrayList<>();
        students = new ArrayList<>();
        // add sample hostels
        hostels.add(new Hostels("SJ",30,60,1));
        hostels.add(new Hostels("SD",45,65,2));
        //add rooms
        rooms.add(new Rooms("SJ1",true,2,1,1,2300));
        rooms.add(new Rooms("SD2",true,2,1,2,2300));
        // add students
        students.add(new Students("Gaston Gichure",1,"GG"));
        students.add(new Students("Carlos Odhiambo",2,"CO"));
        students.add(new Students("Grace Muthoki",3,"GM"));
        students.add(new Students("Hassan Julo",4,"HJ"));
        students.add(new Students("Kelvin Ribai",5,"KR"));
        students.add(new Students("lennox Jira",6,"JL"));
        students.add(new Students("Jesse Uhuru",7,"JU"));




    }

    public  void displayAvailableRooms(String hostel){
        int flag=1;
        for(Rooms room :rooms){
            if(room.isAvailable()){
                System.out.println("ROOM ID "+ room.getId());
                System.out.println("ROOM NAME "+ room.getName());
                System.out.println();
                flag++;
            }
        }
        if(flag==1){
            System.out.println("No available rooms");
        }
    }

    public void createStudent(Students students){
        StudentsDTO  studentsDTO =new StudentsDTO();
        studentsDTO.insertStudents(students.getId(), students.getName(), students.getRegistrationNumber());
    }
}
