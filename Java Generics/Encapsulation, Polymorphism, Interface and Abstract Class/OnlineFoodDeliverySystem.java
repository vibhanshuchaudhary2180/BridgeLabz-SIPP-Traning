import java.util.*;

// Interface: Discountable
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract Class: FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters and Setters (no setters for protected fields)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setPrice(double newPrice) {
        this.price = newPrice;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + calculateTotalPrice());
        if (this instanceof Discountable) {
            System.out.println(((Discountable) this).getDiscountDetails());
        }
        System.out.println("--------------------------------------");
    }
}

// VegItem Class
class VegItem extends FoodItem implements Discountable {
    private double discountAmount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discountAmount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discountAmount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: ₹" + discountAmount;
    }
}

// NonVegItem Class
class NonVegItem extends FoodItem implements Discountable {
    private double discountAmount = 0;
    private static final double NON_VEG_CHARGE = 20.0; // Per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double baseTotal = (getPrice() * getQuantity());
        double extraCharge = NON_VEG_CHARGE * getQuantity();
        return baseTotal + extraCharge - discountAmount;
    }

    @Override
    public void applyDiscount(double percentage) {
        double totalBeforeExtra = getPrice() * getQuantity();
        discountAmount = totalBeforeExtra * (percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: ₹" + discountAmount + " (Excludes extra non-veg charge)";
    }
}


public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();

        FoodItem vegBurger = new VegItem("Veg Burger", 120, 2);
        FoodItem chickenRoll = new NonVegItem("Chicken Roll", 150, 1);

        orderList.add(vegBurger);
        orderList.add(chickenRoll);

        // Apply discounts
        if (vegBurger instanceof Discountable) {
            ((Discountable) vegBurger).applyDiscount(10); // 10% off
        }
        if (chickenRoll instanceof Discountable) {
            ((Discountable) chickenRoll).applyDiscount(5); // 5% off
        }

        // Polymorphic order processing
        System.out.println("===== Order Summary =====");
        for (FoodItem item : orderList) {
            item.getItemDetails();
        }
    }
}