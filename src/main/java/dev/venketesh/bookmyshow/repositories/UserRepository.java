package dev.venketesh.bookmyshow.repositories;

import dev.venketesh.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User getUserById(int id);
    public User getUserByEmail(String email);
}
