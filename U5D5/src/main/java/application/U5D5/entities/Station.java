package application.U5D5.entities;


import application.U5D5.enums.StationType;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Builder(builderClassName = "stationBuilder")
@AllArgsConstructor
public class Station {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
    private boolean isFree;
    private int maxGroupSize;
    @OneToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @Cascade(CascadeType.REMOVE)
    private List<Reservation> reservations;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    public static class stationBuilder{
        Random rnd = new Random();
        private Faker faker = new Faker(Locale.ITALY);
        private String description = faker.elderScrolls().race();
        private boolean isFree = true;
        private int maxGroupSize = rnd.nextInt(10 , 31);

    }



}
