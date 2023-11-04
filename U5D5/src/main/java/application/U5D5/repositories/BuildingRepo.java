package application.U5D5.repositories;

import application.U5D5.entities.Building;
import application.U5D5.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingRepo extends JpaRepository<Building, Integer> {

    List<Building> findByCity(String city);


}
