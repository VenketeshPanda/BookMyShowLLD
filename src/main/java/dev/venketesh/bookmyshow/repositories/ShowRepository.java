package dev.venketesh.bookmyshow.repositories;

import dev.venketesh.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {

}
