package application.U5D5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;
    private String address;
    @OneToMany(mappedBy = "building")
    private List<Station> stations;




}
