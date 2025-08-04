import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    // Add at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current == tail) {
            addAtEnd(title, director, year, rating);
        } else {
            Movie newMovie = new Movie(title, director, year, rating);
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
        }
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director or rating
    public void search(String keyword) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(keyword) ||
                String.valueOf(current.rating).equals(keyword)) {
                System.out.println("Found: " + current.title + " | Dir: " + current.director +
                        " | Year: " + current.year + " | Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for search: " + keyword);
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all (forward)
    public void displayForward() {
        Movie current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Forward):");
        while (current != null) {
            System.out.println(current.title + " | Dir: " + current.director +
                    " | Year: " + current.year + " | Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all (reverse)
    public void displayReverse() {
        Movie current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Reverse):");
        while (current != null) {
            System.out.println(current.title + " | Dir: " + current.director +
                    " | Year: " + current.year + " | Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\nMovie Management System:");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Update Rating by Title");
            System.out.println("7. Display Movies (Forward)");
            System.out.println("8. Display Movies (Reverse)");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String title, director;
            int year, position;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = scanner.nextLine();
                    director = scanner.nextLine();
                    year = scanner.nextInt();
                    rating = scanner.nextDouble();
                    movieList.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = scanner.nextLine();
                    director = scanner.nextLine();
                    year = scanner.nextInt();
                    rating = scanner.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = scanner.nextLine();
                    director = scanner.nextLine();
                    year = scanner.nextInt();
                    rating = scanner.nextDouble();
                    movieList.addAtPosition(position, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = scanner.nextLine();
                    movieList.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director Name or Rating to Search: ");
                    String keyword = scanner.nextLine();
                    movieList.search(keyword);
                    break;

                case 6:
                    System.out.print("Enter Movie Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = scanner.nextDouble();
                    movieList.updateRating(title, rating);
                    break;

                case 7:
                    movieList.displayForward();
                    break;

                case 8:
                    movieList.displayReverse();
                    break;

                case 9:
                    System.out.println("Exiting Movie Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
