package application.U5D5.interfaces;

import application.U5D5.entities.Station;


public interface StationServiceInterface {


        public void save(Station station);

        public void findByIdAndUpdate(Station station);

        public void findByIdAndDelete(int id);

        public Station findById(int id);



    }



