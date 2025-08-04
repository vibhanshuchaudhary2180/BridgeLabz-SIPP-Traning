// ProductCategory interface (marker for all categories)
interface ProductCategory {
    String getCategoryName();
}

// Specific product categories
enum BookCategory implements ProductCategory {
    FICTION, NON_FICTION, EDUCATIONAL;

    public String getCategoryName() {
        return "Book - " + this.name();
    }
}

enum ClothingCategory implements ProductCategory {
    MENS, WOMENS, KIDS;

    public String getCategoryName() {
        return "Clothing - " + this.name();
    }
}

enum GadgetCategory implements ProductCategory {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return "Gadget - " + this.name();
    }
}

// Generic Product class
class Product<T extends ProductCategory> {
    private String name;
    private T category;
    private double price;

    public Product(String name, T category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price = price - (price * percentage / 100);
        }
    }

    @Override
    public String toString() {
        return name + " [" + category.getCategoryName() + "] - $" + String.format("%.2f", price);
    }
}

// Utility class
class ProductUtils {
    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Discount applied to " + product.getName() + ": New price = $" + product.getPrice());
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create different products
        Product<BookCategory> book = new Product<>("Java Programming", BookCategory.EDUCATIONAL, 50.0);
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", ClothingCategory.MENS, 30.0);
        Product<GadgetCategory> smartphone = new Product<>("Smartphone X", GadgetCategory.MOBILE, 699.0);

        // Display initial products
        System.out.println("=== Product Catalog ===");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(smartphone);

        // Apply discounts
        System.out.println("\n=== Applying Discounts ===");
        ProductUtils.applyDiscount(book, 10);        // 10% discount on book
        ProductUtils.applyDiscount(shirt, 20);       // 20% discount on clothing
        ProductUtils.applyDiscount(smartphone, 15);  // 15% discount on gadget

        // Display updated catalog
        System.out.println("\n=== Updated Catalog ===");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(smartphone);
    }
}
