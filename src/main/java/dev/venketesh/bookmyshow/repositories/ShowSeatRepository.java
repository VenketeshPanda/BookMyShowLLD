package dev.venketesh.bookmyshow.repositories;

import dev.venketesh.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    List<ShowSeat> findAllById(Iterator<Integer> showIds);
}
