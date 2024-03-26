package classRepositories;

import dtos.RoomsDTO;
import models.Rooms;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;

public class RoomsRepository {
    private final RoomsDTO roomsDTO;

    public  RoomsRepository(){
        roomsDTO = new RoomsDTO();
    }
    public void insertRoomsDetails(@NotNull Rooms rooms){

        boolean inserted = roomsDTO.insertRoomDetails(rooms.getName(),rooms.getHostelId(),rooms.getId(), rooms.getNoOfBeds(), rooms.getPrice(), rooms.isAvailable());

    }
    public void updateRoomsTable(Rooms rooms){

        boolean update= roomsDTO.updateRoomsTable(rooms.getName(), rooms.getHostelId(), rooms.getId(),rooms.getNoOfBeds(),rooms.getPrice(), rooms.isAvailable());
    }
    public void removeRoomRecord(Rooms rooms){

        boolean remove= roomsDTO.removeRoomRecord(rooms.getName());
    }
    public void requestAllStudentDetails(Rooms rooms) {

    boolean requestAllStudentDetails = roomsDTO.requestAllRoomInformation(new DefaultTableModel());
    }
}
