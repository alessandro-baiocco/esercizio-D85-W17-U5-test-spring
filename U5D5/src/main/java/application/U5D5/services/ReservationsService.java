package application.U5D5.services;

import application.U5D5.entities.Station;
import application.U5D5.exceptions.ItemNotFoundException;
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
    public Reservation findById(int id) throws ItemNotFoundException {
        return reservRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public void save(Reservation reser) {
        Optional<Reservation> found = reservRepo.findByStationAndDate(reser.getStation() , reser.getDate());
        Optional<Reservation> userIsFree = reservRepo.findByUserAndDate(reser.getUser() , reser.getDate());
        if(found.isEmpty() && userIsFree.isEmpty()){
            reservRepo.save(reser);
            System.out.println("prenotazione salvata con successo");
        }else if(found.isPresent()) {
            System.err.println("c'e gia una prenotazione per quel giorno in quel luogo");
        }else {
            System.err.println("hai gia prenotato una postazione per quel giorno");
        }

    }

    @Override
    public void findByIdAndUpdate(Reservation reser) {
        Reservation found = this.findById(reser.getId());
        found.setStation(reser.getStation());
        found.setUser(reser.getUser());
        found.setDate(reser.getDate());
        reservRepo.save(found);
        log.info("prenotazione con id " + reser.getId() + " aggiornata con successo!");

    }

    @Override
    public void findByIdAndDelete(int id) {
        Reservation found = this.findById(id);
        reservRepo.delete(found);
        log.info("prenotazione con id " + id + " eliminata con successo!");
    }


}
