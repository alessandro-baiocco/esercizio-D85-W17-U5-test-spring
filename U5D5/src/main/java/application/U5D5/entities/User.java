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
import org.hibernate.annotations.Type;

import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
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




}
