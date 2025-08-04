public class Book {
    String title;
    String author;
    double price;

   
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }


    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("Java Basics", "John Doe", 299.99);

        System.out.println("Default Book: " + defaultBook.title + ", " + defaultBook.author + ", ₹" + defaultBook.price);
        System.out.println("Custom Book: " + customBook.title + ", " + customBook.author + ", ₹" + customBook.price);
    }
}