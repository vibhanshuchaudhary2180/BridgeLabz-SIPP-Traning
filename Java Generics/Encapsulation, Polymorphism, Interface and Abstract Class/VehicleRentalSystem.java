import java.util.*;

// Interface: Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class: Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; // Sensitive field

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Encapsulation: Getters and setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Protected getter for insurance (not public to protect sensitive info)
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method to display details
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
        if (this instanceof Insurable) {
            System.out.println(((Insurable) this).getInsuranceDetails());
            System.out.println("Insurance Cost: " + ((Insurable) this).calculateInsurance());
        } else {
            System.out.println("No insurance applicable.");
        }
        System.out.println("------------------------------------");
    }
}

// Subclass: Car
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1000.0; // Flat rate for simplicity
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy: " + getInsurancePolicyNumber() + ")";
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate, null); // No insurance
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Subclass: Truck
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // Additional handling fee
    }

    @Override
    public double calculateInsurance() {
        return 2000.0; // Flat rate for trucks
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy: " + getInsurancePolicyNumber() + ")";
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car1 = new Car("KA01AB1234", 1500, "CARINS123");
        Vehicle bike1 = new Bike("KA05CD4321", 500);
        Vehicle truck1 = new Truck("KA09EF9876", 2500, "TRUCKINS987");

        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(truck1);

        int rentalDays = 5;

        // Polymorphism: process each vehicle uniformly
        for (Vehicle v : vehicles) {
            v.displayDetails(rentalDays);
        }
    }
}