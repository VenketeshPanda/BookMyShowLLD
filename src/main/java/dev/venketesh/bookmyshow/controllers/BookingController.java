package dev.venketesh.bookmyshow.controllers;

import dev.venketesh.bookmyshow.dtos.BookTicketRequestDTO;
import dev.venketesh.bookmyshow.dtos.BookTicketResponseDTO;
import dev.venketesh.bookmyshow.dtos.ResponseStatus;
import dev.venketesh.bookmyshow.models.Booking;
import dev.venketesh.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO request){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try{
            Booking booking=bookingService.bookTicket(request.getSeatList(),request.getShowId(), request.getUserId());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setAmount(booking.getPrice());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Ticket has been booked!");

        } catch (RuntimeException e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
