package application.U5D5.entities;


import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Locale;

@Getter
@Entity
@ToString
@NoArgsConstructor
@Builder(builderClassName = "userBuilder")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String surname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Cascade(CascadeType.REMOVE)
    private List<Reservation> listOfReservations;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setListOfReservations(List<Reservation> listOfReservations) {
        this.listOfReservations = listOfReservations;
    }


    public static class userBuilder{
        private Faker faker = new Faker(Locale.ITALY);
        private String name = faker.name().firstName();
        private String lastName = faker.name().lastName();
        private String email = faker.internet().emailAddress();
        private String surname = faker.elderScrolls().lastName();


    }

    public User(String name, String lastName, String email, String surname) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.surname = surname;
    }
}
