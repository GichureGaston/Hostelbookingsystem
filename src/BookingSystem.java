import dtos.StudentsDTO;
import models.Booking;
import models.Hostels;
import models.Rooms;
import models.Students;

import java.util.ArrayList;

class BookingSystem {
    private ArrayList<Booking> bookings;
    private  ArrayList<Rooms> rooms;
    private ArrayList<Hostels> hostels;
    private ArrayList<Students> students;


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
        rooms.add(new Rooms("SJ2",true,2,1,2,2300));
        // add students
        students.add(new Students("Gino",1,"GINO23"));
        students.add(new Students("Fred",1,"Fred23"));
        students.add(new Students("Gordon",1,"Gordon23"));
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
