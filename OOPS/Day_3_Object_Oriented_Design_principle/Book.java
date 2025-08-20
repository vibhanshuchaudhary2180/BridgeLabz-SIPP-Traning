package Day_3_Object_Oriented_Design_principle;

import java.util.*;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Library {
    String name;
    List<Book> books;

    Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book); // Aggregation: book can exist without library
    }

    void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.display();
        }
    }
}

