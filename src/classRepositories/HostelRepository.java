package classRepositories;

import dtos.HostelDTO;
import models.Hostels;
import models.Rooms;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;

public class HostelRepository {
    private final HostelDTO hostelDTO;

    public  HostelRepository(){
        hostelDTO = new HostelDTO();
    }
    public void insertHostels(@NotNull Hostels hostels, String noOfRooms, String noOfBeds, String id){

        boolean inserted = hostelDTO.insertHostels(hostels.getName(),hostels.getNoOfRooms(),hostels.getNoOfBeds(), hostels.getId());

    }
    public void updateHostels(@NotNull Hostels hostels){

        boolean update= hostelDTO.updateHostels(hostels.getName(),hostels.getNoOfRooms(),hostels.getNoOfBeds(),hostels.getId());

    }
    public void deleteRecord(String hostels){

        boolean remove= hostelDTO.deleteRecord(hostels.getName());
    }
    public void requestAllHostelDetails( Hostels hostels){
        boolean request= hostelDTO.requestAllHostelDetails(new DefaultTableModel());
    }

    public void requestAllHostelDetails(Hostels hostels, String noOfRoomsR, String noOfBedsR, String idRequest) {
    }
}
