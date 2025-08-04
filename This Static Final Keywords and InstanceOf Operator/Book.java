class Book {
    static String libraryName = "City Library";
    final String isbn;
    String title, author;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell", "ISBN123");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN456");

        displayLibraryName();
        b1.displayBookDetails();
        b2.displayBookDetails();
    }
}
