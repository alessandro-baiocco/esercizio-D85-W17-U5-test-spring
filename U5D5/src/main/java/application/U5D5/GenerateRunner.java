package application.U5D5;

import application.U5D5.entities.Building;
import application.U5D5.entities.Reservation;
import application.U5D5.entities.Station;
import application.U5D5.entities.User;
import application.U5D5.enums.StationType;
import application.U5D5.interfaces.*;
import application.U5D5.repositories.BuildingRepo;
import application.U5D5.repositories.UserRepo;
import application.U5D5.interfaces.BuildingServiceInterface;
import application.U5D5.services.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(1)
public class GenerateRunner implements CommandLineRunner {
    @Autowired
    private UserServiceInterface usersDAO;
    @Autowired
    private BuildingServiceInterface buildDAO;
    @Autowired
    private  StationServiceInterface stationDAO;
    @Autowired
    private ReservationServiceInterface reservDAO;



    @Override
    public void run(String... args) throws Exception {

        System.out.println(buildDAO.findSearchedStationsByCity("Winterhold" , StationType.OPENSPACE));




    }



    public static void generateUsers(UserServiceInterface usersDAO){
        for (int i = 0 ; i < 20 ; i++){
            User newUser = new User().builder().build();
            System.out.println(newUser);
            usersDAO.save(newUser);
        }
    }


    public static void generateBuildings(BuildingServiceInterface buildDAO){

        for (int i = 0 ; i < 20 ; i++){
            Building newBuild = new Building().builder().build();
            System.out.println(newBuild);
            buildDAO.save(newBuild);

        }
    }


        public static void generateStation(StationServiceInterface stationDAO , BuildingServiceInterface buildDAO){

            for (int i = 0 ; i < 5 ; i++){
                Station newStation = new Station().builder().building(buildDAO.getRandomBuild()).stationType(StationType.PRIVATO).build();
                System.out.println(newStation);
                stationDAO.save(newStation);
            }
            for (int i = 0 ; i < 5 ; i++){
                Station newStation = new Station().builder().building(buildDAO.getRandomBuild()).stationType(StationType.OPENSPACE).build();
                System.out.println(newStation);
                stationDAO.save(newStation);
            }
            for (int i = 0 ; i < 5 ; i++){
                Station newStation = new Station().builder().building(buildDAO.getRandomBuild()).stationType(StationType.SALA).build();
                System.out.println(newStation);
                stationDAO.save(newStation);
            }
            for (int i = 0 ; i < 5 ; i++){
                Station newStation = new Station().builder().building(buildDAO.getRandomBuild()).stationType(StationType.RIUNIONI).build();
                System.out.println(newStation);
                stationDAO.save(newStation);
            }

    }



    public static void generateReservation(ReservationServiceInterface reservDAO , UserServiceInterface usersDAO , StationServiceInterface stationDAO ){

        for (int i = 0 ; i < 20 ; i++){
            Reservation newReserv = new Reservation().builder().user(usersDAO.getRandomUser()).station(stationDAO.getRandomStation()).build();
            System.out.println(newReserv);
            reservDAO.save(newReserv);
        }


    }



}

