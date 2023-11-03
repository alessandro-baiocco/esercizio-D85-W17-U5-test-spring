package application.U5D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;



}
