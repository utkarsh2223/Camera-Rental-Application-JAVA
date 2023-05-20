package cameraRentalApp;

public class Camera {
	private String brand;
    private String model;
    private double rentalAmountPerDay;

    public Camera(String brand, String model, double rentalAmountPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalAmountPerDay = rentalAmountPerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRentalAmountPerDay() {
        return rentalAmountPerDay;
    }

    public void setRentalAmountPerDay(double rentalAmountPerDay) {
        this.rentalAmountPerDay = rentalAmountPerDay;
    }
}
