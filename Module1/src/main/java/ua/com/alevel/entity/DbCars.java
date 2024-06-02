package ua.com.alevel.Entity;

import ua.com.alevel.Entity.Car;

public class DbCars {
    private static Car[] Cars = new Car[10];
    public void create(Car car){
        for (int i = 0; i < Cars.length; i++) {
            if(Cars[i]==null){
                Cars[i] = car;
                car.setId(i);
                break;
            }
        }
    }
    public void update(Car car){
        for (int i = 0; i < Cars.length; i++) {
            if (Cars[i] == null) {
                Cars[i] = car;
                break;

            }
        }
    }
    public void delete(int id){
        for (int i = 0; i < Cars.length; i++) {
            if(Cars[i] != null){
                Cars[i] = null;
            }
        }
    }


}
