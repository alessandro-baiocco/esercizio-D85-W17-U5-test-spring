package application.U5D5.repositories;

import application.U5D5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepo extends JpaRepository<Building, Integer> {


}
