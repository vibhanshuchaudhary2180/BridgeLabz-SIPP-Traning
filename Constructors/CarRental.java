public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 1000.0;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Neha", "Honda City", 4);
        double totalCost = rental.calculateTotalCost();
        System.out.println("Customer: " + rental.customerName);
        System.out.println("Car: " + rental.carModel);
        System.out.println("Total Cost: ₹" + totalCost);
    }
}