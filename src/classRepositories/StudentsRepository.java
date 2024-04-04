package classRepositories;

import dtos.StudentsDTO;
import models.Students;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentsRepository {
private final StudentsDTO studentsDTO;

    public  StudentsRepository(){

    studentsDTO = new StudentsDTO();
}
    public void insertStudents(@NotNull Students students){

        boolean inserted = studentsDTO.insertStudents(students.getId(), students.getName(), students.getRegistrationNumber());

    }
    public void updateStudentDetails(@NotNull Students students){

        boolean updateStudentDetails = studentsDTO.insertStudents(students.getId(), students.getName(), students.getRegistrationNumber());

    }
    public void removeStudentDetails(@NotNull String registrationNumber){

        boolean removeStudentDetails= studentsDTO.removeStudentDetails(registrationNumber);

    }
    public List<Students> requestAllStudentDetails(@NotNull Students students){

        boolean requestAllStudentDetails= studentsDTO.requestAllStudentDetails( new DefaultTableModel());


        return null;
    }

    public void createStudentsSchema() {

    }
}
