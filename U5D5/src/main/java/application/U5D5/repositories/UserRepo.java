package application.U5D5.repositories;

import application.U5D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    @Query("SELECT u FROM User u")
    List<User> findAllUser();


}
