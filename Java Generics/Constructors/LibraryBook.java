public class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is currently not available.");
        }
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Data Structures", "Prof. Singh", 450.00);
        System.out.println("Trying to borrow: " + book.title);
        book.borrowBook();
        book.borrowBook(); 
    }
}