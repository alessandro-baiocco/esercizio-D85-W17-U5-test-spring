package application.U5D5.userEntities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String surname;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
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




}
