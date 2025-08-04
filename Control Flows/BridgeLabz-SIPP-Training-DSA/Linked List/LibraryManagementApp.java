import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head;
    private Book tail;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, id, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int id, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, id, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at specific position (0-based)
    public void addAtPosition(int position, String title, String author, String genre, int id, boolean isAvailable) {
        if (position <= 0 || head == null) {
            addAtBeginning(title, author, genre, id, isAvailable);
            return;
        }

        Book current = head;
        int index = 0;
        while (index < position - 1 && current.next != null) {
            current = current.next;
            index++;
        }

        if (current == tail) {
            addAtEnd(title, author, genre, id, isAvailable);
        } else {
            Book newBook = new Book(title, author, genre, id, isAvailable);
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }

    // Remove book by ID
    public void removeById(int id) {
        if (head == null) return;

        Book current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book with ID " + id + " removed.");
    }

    // Search by title or author
    public void search(String keyword) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No book found with keyword: " + keyword);
    }

    // Update availability
    public void updateAvailability(int id, boolean status) {
        Book current = head;

        while (current != null) {
            if (current.id == id) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found.");
    }

    // Display all books (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;
        System.out.println("Books (Forward):");
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // Display all books (reverse)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = tail;
        System.out.println("Books (Reverse):");
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // Count books
    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total books in library: " + count);
    }

    // Helper to print book details
    private void displayBook(Book book) {
        System.out.println("ID: " + book.id + " | Title: " + book.title +
                " | Author: " + book.author + " | Genre: " + book.genre +
                " | Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}
public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\nLibrary Management Menu:");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title or Author");
            System.out.println("6. Update Availability");
            System.out.println("7. Display All Books (Forward)");
            System.out.println("8. Display All Books (Reverse)");
            System.out.println("9. Count Books");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            String title, author, genre;
            int id, position;
            boolean available;

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    available = scanner.nextBoolean();
                    library.addAtBeginning(title, author, genre, id, available);
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    available = scanner.nextBoolean();
                    library.addAtEnd(title, author, genre, id, available);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    available = scanner.nextBoolean();
                    library.addAtPosition(position, title, author, genre, id, available);
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = scanner.nextInt();
                    library.removeById(id);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Enter Title or Author to search: ");
                    String keyword = scanner.nextLine();
                    library.search(keyword);
                    break;

                case 6:
                    System.out.print("Enter Book ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("New Availability (true/false): ");
                    available = scanner.nextBoolean();
                    library.updateAvailability(id, available);
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8:
                    library.displayReverse();
                    break;

                case 9:
                    library.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        scanner.close();
    }
}
