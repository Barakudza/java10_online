package ua.com.alevel.Entity;
import ua.com.alevel.Service.Bike;

import java.util.Arrays;
import java.util.Optional;

public class Db {
    private Bike[] bikes = new Bike[100];
    private int idCounter = 1;

    public void createBike(Bike bike) {
        bike.setId(idCounter++);
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] == null) {
                bikes[i] = bike;
                return;
            }
        }
    }

    public Optional<Bike> selectBike(int id) {
        for (Bike bike : bikes) {
            if (bike != null && bike.getId() == id) {
                return Optional.of(bike);
            }
        }
        return Optional.empty();
    }

    public Bike[] allBikes(){ return bikes; }

    public boolean updateBike(Bike updatedBike) {
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] !=null && bikes[i].getId() == updatedBike.getId()){
                bikes[i].setBrand(updatedBike.getBrand());
                bikes[i].setYear(updatedBike.getYear());
                return true;
            }
        }
        return false;
    }

    public boolean deleteBike(int id){
        for (int i = 0; i < bikes.length; i++) {
            if (bikes[i] != null && bikes[i].getId() == id){
                bikes[i] = null;
                return true;
            }
        }
        return false;
    }

}

