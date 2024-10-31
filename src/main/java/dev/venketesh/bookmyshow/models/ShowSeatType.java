package dev.venketesh.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private SeatType seatType;

    @ManyToOne
    private Show show;
    private int price;
}

//Show1 Gold 100
//Show1 Silver 50
//Show1 Bronze 25

//Different show type will be present in same show, but same show will be present in diff ShowSeatType