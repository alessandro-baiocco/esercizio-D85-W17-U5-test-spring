package application.U5D5.entities;


import application.U5D5.enums.StationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
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
}
