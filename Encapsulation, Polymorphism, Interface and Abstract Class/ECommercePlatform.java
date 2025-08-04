import java.util.*;

// Interface: Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class: Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract Method
    public abstract double calculateDiscount();

    // Method to calculate and print final price
    public void printFinalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0.0;
        double finalPrice = price + tax - discount;

        System.out.println("Product: " + name);
        System.out.println("Base Price: " + price);
        if (this instanceof Taxable) {
            System.out.println(((Taxable) this).getTaxDetails());
        } else {
            System.out.println("No tax applicable.");
        }
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------------------");
    }
}

// Electronics Class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax (18% GST): " + calculateTax();
    }
}

// Clothing Class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax (12% GST): " + calculateTax();
    }
}

// Groceries Class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    // Groceries are not taxable, so no Taxable interface implemented
}


public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product laptop = new Electronics(201, "Laptop", 60000);
        Product tshirt = new Clothing(202, "T-Shirt", 1200);
        Product rice = new Groceries(203, "Rice (5kg)", 450);

        products.add(laptop);
        products.add(tshirt);
        products.add(rice);

        // Polymorphism in action
        for (Product p : products) {
            p.printFinalPrice();
        }
    }
}