import java.util.*;

// Interface: Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class: LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;
    private String borrower;  // Sensitive data

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
        this.isAvailable = false;
    }

    public String getBorrower() {
        return borrower;
    }

    protected void setAvailable(boolean available) {
        this.isAvailable = available;
        if (available) this.borrower = null;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Abstract Method
    public abstract int getLoanDuration();

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Reserved by " + borrower));
        System.out.println("-----------------------------------------");
    }
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved successfully by " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days for DVDs
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved successfully by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        LibraryItem book1 = new Book("B001", "1984", "George Orwell");
        LibraryItem mag1 = new Magazine("M001", "Time Magazine", "Time Editors");
        LibraryItem dvd1 = new DVD("D001", "Inception", "Christopher Nolan");

        items.add(book1);
        items.add(mag1);
        items.add(dvd1);

        // Reserve some items using polymorphism
        if (book1 instanceof Reservable) {
            ((Reservable) book1).reserveItem("Alice");
        }

        if (dvd1 instanceof Reservable) {
            ((Reservable) dvd1).reserveItem("Bob");
        }

        // Display all item details
        for (LibraryItem item : items) {
            item.getItemDetails();  // Polymorphism in action
        }
    }
}