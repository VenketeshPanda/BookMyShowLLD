package dev.venketesh.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne  
    private Seat seat;

    @Enumerated(value = EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
    private Date blockedAt;
}
