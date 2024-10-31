package dev.venketesh.bookmyshow.services;

import dev.venketesh.bookmyshow.models.User;
import dev.venketesh.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User signUp(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User dbUser = userRepository.getUserByEmail(email);
        if(dbUser!=null) throw new RuntimeException("User "+email+" already exists!");
        return userRepository.save(user);
    }

    public User login(String email,String password){
        User user = userRepository.getUserByEmail(email);
        if(user==null) return null;
        if(user.getPassword().equals(password)) return user;
        return null;
    }
}
