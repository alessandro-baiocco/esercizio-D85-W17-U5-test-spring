package application.U5D5.repositories;

import application.U5D5.entities.Station;
import application.U5D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {


    @Query("SELECT s FROM Station s")
    List<Station> findAllStation();

}
