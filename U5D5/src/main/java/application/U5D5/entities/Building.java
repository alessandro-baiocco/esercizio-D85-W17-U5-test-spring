package application.U5D5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@ToString
public class Building {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;
    private String address;
    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    @Cascade(CascadeType.REMOVE)
    private List<Station> stations;

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
