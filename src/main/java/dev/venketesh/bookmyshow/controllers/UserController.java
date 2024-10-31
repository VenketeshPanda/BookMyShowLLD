package dev.venketesh.bookmyshow.controllers;

import dev.venketesh.bookmyshow.dtos.*;
import dev.venketesh.bookmyshow.models.User;
import dev.venketesh.bookmyshow.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDTO signUp(@RequestBody SignUpRequestDTO request){
        SignUpResponseDTO response = new SignUpResponseDTO();

        try{
            User user = userService.signUp(request.getEmail(),request.getPassword());
            response.setUserId(String.valueOf(user.getId()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("User created successfully!");
        } catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
        }
        return response;
    }


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request){
        LoginResponseDTO response = new LoginResponseDTO();
        try{
            User user = userService.login(request.getEmail(),request.getPassword());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage(user.getId()+" logged in successfully!");
        } catch (Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
