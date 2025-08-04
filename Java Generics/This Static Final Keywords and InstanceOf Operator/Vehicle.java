class Vehicle {
    static double registrationFee = 500.00;
    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("REG123", "Mike", "Car");
        Vehicle v2 = new Vehicle("REG456", "Lucy", "Motorcycle");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        updateRegistrationFee(600.0);
        System.out.println("--- After Fee Update ---");
        v1.displayVehicleDetails();
    }
}
