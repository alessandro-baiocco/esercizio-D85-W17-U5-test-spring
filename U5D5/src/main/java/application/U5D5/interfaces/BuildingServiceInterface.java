package application.U5D5.interfaces;

import application.U5D5.entities.Building;
import application.U5D5.entities.Reservation;
import application.U5D5.entities.Station;
import application.U5D5.enums.StationType;

import java.util.List;

public interface BuildingServiceInterface {
    public void save(Building build);

    public void findByIdAndUpdate(Building build);

    public void findByIdAndDelete(int id);

    public Building findById(int id);
    public List<Station> findSearchedStationsByCity(String city , StationType type);

    public Building getRandomBuild();



}

