package application.U5D5.repositories;

import application.U5D5.entities.Reservation;
import application.U5D5.entities.Station;
import application.U5D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

   Optional<Reservation> findByStationAndDate(Station station , LocalDate localDate);

   Optional<Reservation> findByUserAndDate(User user , LocalDate localDate);


}
