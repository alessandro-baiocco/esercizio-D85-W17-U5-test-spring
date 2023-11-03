package application.U5D5.services;

import application.U5D5.entities.Station;
import application.U5D5.exceptions.ItemNotFoundException;
import application.U5D5.interfaces.StationServiceInterface;
import application.U5D5.repositories.StationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class StationService implements StationServiceInterface {

    @Autowired
    private StationRepo stationRepo;


    @Override
    public void save(Station station) {
        stationRepo.save(station);
        log.info("postazione salvata correttamente!");
    }

    @Override
    public Station findById(int id) throws ItemNotFoundException {
        return stationRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
    @Override
    public void findByIdAndUpdate(Station station) {
        Station found = this.findById(station.getId());
        found.setDescription(station.getDescription());
        found.setStationType(station.getStationType());
        found.setBuilding(station.getBuilding());
        found.setMaxGroupSize(station.getMaxGroupSize());
        found.setFree(station.isFree());
        found.setReservations(station.getReservations());
        stationRepo.save(found);
        log.info("Postazione con id " + station.getId() + " aggiornata con successo!");
    }

    @Override
    public void findByIdAndDelete(int id) throws ItemNotFoundException {
        Station found = this.findById(id);
        stationRepo.delete(found);
        log.info("Postazione con id " + id + " eliminata con successo!");
    }


}
