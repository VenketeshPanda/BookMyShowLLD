package dev.venketesh.bookmyshow;

import dev.venketesh.bookmyshow.controllers.UserController;
import dev.venketesh.bookmyshow.dtos.SignUpRequestDTO;
import dev.venketesh.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO request = new SignUpRequestDTO();
        request.setEmail("venketeshpakknda1999@gmail.com");
        request.setPassword("98765");

        SignUpResponseDTO responseDTO=userController.signUp(request);
        System.out.println(responseDTO.getMessage());
    }
}
