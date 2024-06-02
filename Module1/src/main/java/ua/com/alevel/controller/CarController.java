package ua.com.alevel.Controller;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import ua.com.alevel.Entity.DbCars;
import ua.com.alevel.Entity.Car;
import ua.com.alevel.Service.CarService;

public class CarController {
    private CarService carService = new CarService();
    static int howId = 0;
    Car[] cars = new Car[10];
    int id;

    public static void start() throws IOException{
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       menu();
       String position;
       while ((position = reader.readLine()) != null) {
          crud(position, reader);
          menu();
    }
    }
    static void menu(){
        System.out.println("Hello, this program will help you with searching cars in your garage");
        System.out.println("- Press 1 if you want to see what cars do you have");
        System.out.println("- Press 2 if you want to add new car");
        System.out.println("- Press 3 if you want to update info about some car");
        System.out.println("- Press 4 if you want to delete some car");
        System.out.println("- Press 5 if you want exit");
    }
    public static void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> list();
            case "2" -> create(reader);
            case "5" -> System.exit(0);
        }
    }
    public static void create(BufferedReader reader) throws IOException {
            System.out.println("Enter your car brand");
            String carBrand = reader.readLine();
            System.out.println("Enter your car model");
            String modelCar = reader.readLine();
            System.out.println("Enter your car year of manufacture");
            String yearCar = reader.readLine();
            int carYear = Integer.valueOf(yearCar);
            Car car = new Car();
            car.setCarBrand(carBrand);
            car.setCarModel(modelCar);
            car.setCarAge(carYear);
            CarService.create(car);

        }
        static void list() {
            Car[] cars = CarService.info();
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] != null) {
                    System.out.println("ID: " + i +
                            ", Car: " + cars[i].getCarBrand() + " " + cars[i].getCarModel() + " " + cars[i].getCarAge());
                } else {System.out.println("You don`t have cars"); break; }
            }
        }
    }

