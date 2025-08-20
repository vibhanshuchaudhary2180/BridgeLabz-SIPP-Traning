package Day_2_static_Final.Level_1;

class Shopping {
    static double discount = 10.0; // percent

    private String productName;
    private double price;
    private int quantity;
    final String productID;

    Shopping(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProductDetails() {
        if (this instanceof Shopping) {
            System.out.println("Product: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Product ID: " + productID);
            System.out.println("Discount: " + discount + "%");
        }
    }
}
