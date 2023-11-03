package application.U5D5.services;

import application.U5D5.interfaces.ReservationServiceInterface;
import application.U5D5.repositories.ReservationRepo;
import application.U5D5.entities.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ReservationsService implements ReservationServiceInterface {

    @Autowired
    private ReservationRepo reservRepo;




    @Override
    public void save(Reservation reser) {
        Optional<Reservation> found = reservRepo.findByStationAndDate(reser.getStation() , reser.getDate());

    }

    @Override
    public void findByIdAndUpdate(Reservation reser) {

    }

    @Override
    public void findByIdAndDelete(int id) {

    }

    @Override
    public Reservation findById(int id) {
        return null;
    }
}
