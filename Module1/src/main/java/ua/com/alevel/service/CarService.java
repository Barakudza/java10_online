package ua.com.alevel.Service;

import ua.com.alevel.Entity.Car;
import ua.com.alevel.Entity.DbCars;

public class CarService {
    static DbCars carsStorage = new DbCars();

    public static void create(Car car){
        if(car.getCarBrand() != null){
            carsStorage.create(car);
        }
    }
    public static Car[] info() {
        return new Car[0];
    }
    public void update(Car car){

    }
}
