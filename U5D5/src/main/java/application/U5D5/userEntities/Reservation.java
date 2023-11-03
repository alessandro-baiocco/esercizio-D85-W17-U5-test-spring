package application.U5D5.userEntities;

import application.U5D5.buildEntities.Station;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Getter
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
