package application.U5D5.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Locale;


@Entity
@Getter
@NoArgsConstructor
@ToString
@Builder(builderClassName = "buildBuilder")
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;
    private String address;
    @OneToMany(mappedBy = "building",fetch = FetchType.EAGER)
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

    public static class buildBuilder{
        private Faker faker = new Faker(Locale.ITALY);
        private String name = faker.elderScrolls().creature();
        private String city = faker.elderScrolls().city();
        private String address = faker.address().streetAddress();
        private List<Station> stations = null;

    }


}
