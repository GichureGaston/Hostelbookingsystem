package classRepositories;

import dtos.BookingDTO;
import dtos.StudentsDTO;
import models.Booking;
import models.Students;
import org.jetbrains.annotations.NotNull;

public class BookingRepository {
    private final BookingDTO bookingDTO;

    public  BookingRepository(){
        bookingDTO = new BookingDTO();
    }
    public void insertBookingDetails(@NotNull Booking Bookings){
        boolean inserted = bookingDTO.insertBookingDetails(Bookings.getId(), Bookings.getBookedFrom(), Bookings.getBookedUntil(), Bookings.getCreatedAt(),Bookings.getStudentId(),Bookings.getRoomId(),Bookings.getBedNo());
    }
    public void updateBookingDetails(@NotNull Booking Bookings){
        boolean update= bookingDTO.updateBookings(Bookings.getId(),Bookings.getCreatedAt(),Bookings.getBookedFrom(),Bookings.getBookedUntil(),Bookings.getStudentId(),Bookings.getRoomId(),Bookings.getBedNo());
    }
    public void removeBookingDetails(@NotNull Booking Bookings){
        boolean remove= bookingDTO.removeBooking(Bookings.getStudentId());
    }


}
