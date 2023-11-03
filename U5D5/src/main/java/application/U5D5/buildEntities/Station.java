package application.U5D5.buildEntities;


import application.U5D5.enums.StationType;
import application.U5D5.userEntities.Reservation;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Station {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
    private boolean isFree;
    private int maxGroupSize;
    @OneToMany
    private List<Reservation> reservations;



}
