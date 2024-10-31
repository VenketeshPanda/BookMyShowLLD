package dev.venketesh.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;
}
