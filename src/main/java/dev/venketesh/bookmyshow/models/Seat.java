package dev.venketesh.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowVal;
    private int colVal;

    @ManyToOne
    private SeatType seatType;
}
// 1 S: 1St
// 1 St: M S