package dev.venketesh.bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private String userId;
    private ResponseStatus responseStatus;
    private String message;
}
