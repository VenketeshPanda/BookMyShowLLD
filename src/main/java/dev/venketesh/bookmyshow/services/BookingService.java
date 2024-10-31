package dev.venketesh.bookmyshow.services;

import dev.venketesh.bookmyshow.models.*;
import dev.venketesh.bookmyshow.repositories.BookingRepository;
import dev.venketesh.bookmyshow.repositories.ShowRepository;
import dev.venketesh.bookmyshow.repositories.ShowSeatRepository;
import dev.venketesh.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,ShowRepository showRepository,ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository){
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.bookingRepository=bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(List<Integer> showSeatIds,int showId, int userId){
        User user = userRepository.getUserById(userId);
        if(user==null) throw new RuntimeException("User not registered!");

        Show show = showRepository.getReferenceById(showId);
        if(show==null) throw new RuntimeException("Show not available");

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat id: showSeats){
            if(!id.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Selected seats are not available");
            }
        }

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
        }
        showSeatRepository.saveAll(showSeats);

        //using show get all the show seat type
        //We can have price calculation strategy by implementing PriceCalculationStrategy


        //Get user via userId
        //Get show via showId
        ///--------/// Transaction should start here--^^--
        //Get showSeat via showSeatIds
        //check if all the seats are available
        //if yes, mark all the seats as BLOCKED, save the seats in the db, calculate the price
        //if no, return with error message
        ///---------/// Transaction stop --^^--
        //properly create the booking object, save and return it
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeats);
        booking.setPrice(4578);
        booking.setPayments(new ArrayList<>());

        Booking savebooking=bookingRepository.save(booking);

        return savebooking;
    }
}
