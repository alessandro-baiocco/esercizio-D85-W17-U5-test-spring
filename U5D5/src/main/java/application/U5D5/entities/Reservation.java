package application.U5D5.entities;

import application.U5D5.repositories.UserRepo;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

@Entity
@Getter
@NoArgsConstructor
@Builder(builderClassName = "reserBuilder")
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public static class reserBuilder{
        Random rnd = new Random();
        private LocalDate date = LocalDate.now().plusDays(rnd.nextInt(2 , 30));

    }


    public Reservation(LocalDate date, User user, Station station) {
        this.date = date;
        this.user = user;
        this.station = station;
    }

    @Override
    public String toString() {
        return "Reservation id."+ id  + "giorno " + date +
                ", utente " + user.getSurname() +
                " postazione " + station.getStationType();
    }
}
