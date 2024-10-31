package dev.venketesh.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{

    @OneToMany
    private List<ShowSeat> showSeats;
    private int price;

    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;

    @ManyToOne
    private User bookedBy;
    private Date bookingDate;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
}
