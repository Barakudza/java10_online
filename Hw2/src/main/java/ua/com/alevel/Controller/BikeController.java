package ua.com.alevel.Controller;

import ua.com.alevel.Entity.Db;
import ua.com.alevel.Service.Bike;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

public class BikeController {
    private static Db bikeDb = new Db();

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
        System.out.println(" ");
        System.out.println("Hello, this program will help you with searching bikes in your garage");
        System.out.println("- Press 1 if you want to add new bike");
        System.out.println("- Press 2 if you want to search bike by ID");
        System.out.println("- Press 3 if you want to see what bike do you have");
        System.out.println("- Press 4 if you want to update info about some bike");
        System.out.println("- Press 5 if you want to delete some bike");
        System.out.println("- Press 6 if you want exit");
        System.out.println(" ");
    }
    public static void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> pickBike(reader);
            case "3" -> list();
            case "4" -> updateBike(reader);
            case "5" -> deleteBike(reader);
            case "6" -> System.exit(0);
        }
    }

    private static void list(){
        Bike[] bikes = bikeDb.allBikes();
        boolean hasBikes = false;
        for (Bike bike : bikes){
            if (bike != null){
                hasBikes = true;
                System.out.println("Bike ID: " + bike.getId());
                System.out.println("Your bike brand: " + bike.getBrand());
                System.out.println("And your bike year: " + bike.getYear());
                System.out.println(" ");
            }
        }
        if (!hasBikes){ System.out.println("Nothing was found"); }
    }

    private static void pickBike(BufferedReader reader) throws IOException {
        System.out.println("Enter ID");
        int id = Integer.parseInt(reader.readLine());
        Optional<Bike> bike = bikeDb.selectBike(id);
        if (bike.isPresent()){
            System.out.println("Bike ID: " + bike.get().getId());
            System.out.println("Your bike brand: " + bike.get().getBrand());
            System.out.println("And your bike year: " + bike.get().getYear());
        }
        else {
            System.out.println("Nothing was found");
        }
    }

    private static void create(BufferedReader reader) throws IOException {
        System.out.println("Enter your bike brand");
        String brand = reader.readLine();
        System.out.println("Enter your bike year of manufacture");
        int year = Integer.parseInt(reader.readLine());
        Bike newBike = new Bike(0,brand,year);
        bikeDb.createBike(newBike);
        System.out.println("Bike has been created");
    }

    private static void updateBike(BufferedReader reader) throws IOException {
        System.out.println("Enter bike ID: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter new brand: ");
        String brand = reader.readLine();
        System.out.println("Enter new year: ");
        int year = Integer.parseInt(reader.readLine());
        Bike updatedBike = new Bike(id,brand,year);
        boolean updated = bikeDb.updateBike(updatedBike);
        if (updated){ System.out.println("Info updated!"); }
            else { System.out.println("Nothing was found"); }
    }

    private static void deleteBike(BufferedReader reader) throws IOException{
        System.out.println("Enter bike Id");
        int id = Integer.parseInt(reader.readLine());
        boolean deleted = bikeDb.deleteBike(id);
        if (deleted){ System.out.println("Bike deleted!"); }
            else { System.out.println("Nothing was found"); }
    }
}
