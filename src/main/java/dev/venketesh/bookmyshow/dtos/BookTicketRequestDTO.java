package dev.venketesh.bookmyshow.dtos;

import dev.venketesh.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    List<Integer> seatList;
    private int showId;
    private int userId;
}
