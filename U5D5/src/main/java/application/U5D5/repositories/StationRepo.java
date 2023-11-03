package application.U5D5.repositories;

import application.U5D5.buildEntities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {

}
