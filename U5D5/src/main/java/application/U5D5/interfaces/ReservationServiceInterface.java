package application.U5D5.interfaces;

import application.U5D5.entities.Reservation;

public interface ReservationServiceInterface {
    public void save(Reservation reservation);

    public void findByIdAndUpdate(Reservation Reservation);

    public void findByIdAndDelete(int id);

    public Reservation findById(int id);



}

