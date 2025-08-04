import java.util.*;

// Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Class: Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Encapsulation: Getters and protected setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    protected String getLocation() {
        return currentLocation;
    }

    protected void setLocation(String location) {
        this.currentLocation = location;
    }

    // Abstract Method
    public abstract double calculateFare(double distance);

    // Concrete Method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Subclass: Car
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // ₹50 base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
        System.out.println("Car location updated to " + newLocation);
    }
}

// Subclass: Bike
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // No base fare
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
        System.out.println("Bike location updated to " + newLocation);
    }
}

// Subclass: Auto
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 30; // ₹30 base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setLocation(newLocation);
        System.out.println("Auto location updated to " + newLocation);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();

        Vehicle car1 = new Car("CAR001", "Amit Sharma", 15.0, "MG Road");
        Vehicle bike1 = new Bike("BIKE001", "Ravi Singh", 8.0, "BTM Layout");
        Vehicle auto1 = new Auto("AUTO001", "Sunil Kumar", 10.0, "JP Nagar");

        rides.add(car1);
        rides.add(bike1);
        rides.add(auto1);

        double rideDistance = 12.5; // in km

        System.out.println("=== Ride Fare Details ===");
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for " + rideDistance + " km: ₹" + v.calculateFare(rideDistance));
            System.out.println("--------------------------------------");
        }

        // Updating and viewing GPS location
        if (car1 instanceof GPS) {
            ((GPS) car1).updateLocation("Koramangala");
            System.out.println("New Location: " + ((GPS) car1).getCurrentLocation());
        }
    }
}