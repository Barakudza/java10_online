package ua.com.alevel.Entity;

public class Car extends BaseEntity {

    private String carBrand;
    private String carModel;
    private int carAge;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarAge() {
        return carAge;
    }

    public void setCarAge(int carAge) {
        if (carAge > 0) {
            this.carAge = carAge;
        }
    }
}

