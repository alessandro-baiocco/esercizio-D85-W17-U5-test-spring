package application.U5D5.services;

import application.U5D5.entities.Building;
import application.U5D5.entities.Reservation;
import application.U5D5.exceptions.ItemNotFoundException;
import application.U5D5.interfaces.BuildingServiceInterface;
import application.U5D5.interfaces.ReservationServiceInterface;
import application.U5D5.repositories.BuildingRepo;
import application.U5D5.repositories.ReservationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BuildingsService implements BuildingServiceInterface {

    @Autowired
    private BuildingRepo buildRepo;

    @Override
    public Building findById(int id) throws ItemNotFoundException {
            return buildRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

    }


    @Override
    public void save(Building build) {
            buildRepo.save(build);
            System.out.println("costruzione salvata con successo");

    }

    @Override
    public void findByIdAndUpdate(Building build) {
        Building found = this.findById(build.getId());
        found.setCity(build.getCity());
        found.setAddress(build.getAddress());
        found.setStations(build.getStations());
        found.setName(build.getName());
        buildRepo.save(found);
        log.info("prenotazione con id " + build.getId() + " aggiornata con successo!");

    }

    @Override
    public void findByIdAndDelete(int id) {
        Building found = this.findById(id);
        buildRepo.delete(found);
        log.info("prenotazione con id " + id + " eliminata con successo!");
    }


}
