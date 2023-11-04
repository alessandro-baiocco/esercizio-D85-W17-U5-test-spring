package application.U5D5.interfaces;

import application.U5D5.entities.Building;
import application.U5D5.entities.Reservation;

public interface BuildingServiceInterface {
    public void save(Building build);

    public void findByIdAndUpdate(Building build);

    public void findByIdAndDelete(int id);

    public Building findById(int id);



}

