import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;  // For circular linked list

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket tail;  // Points to last ticket node in circular list

    // Add a new ticket at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            tail = newTicket;
            tail.next = tail; // circular link to itself
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket added successfully: ID " + ticketId);
    }

    // Remove a ticket by Ticket ID
    public boolean removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return false;
        }

        Ticket curr = tail.next;
        Ticket prev = tail;

        do {
            if (curr.ticketId == ticketId) {
                if (curr == tail && curr.next == tail) {
                    // Only one node
                    tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket removed successfully: ID " + ticketId);
                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        System.out.println("Ticket ID " + ticketId + " not found.");
        return false;
    }

    // Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }
        System.out.println("Current tickets:");
        Ticket curr = tail.next;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        do {
            System.out.println("Ticket ID: " + curr.ticketId +
                    ", Customer: " + curr.customerName +
                    ", Movie: " + curr.movieName +
                    ", Seat: " + curr.seatNumber +
                    ", Booking Time: " + curr.bookingTime.format(formatter));
            curr = curr.next;
        } while (curr != tail.next);
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket curr = tail.next;
        boolean found = false;
        keyword = keyword.toLowerCase();
        System.out.println("Search results for: \"" + keyword + "\"");
        do {
            if (curr.customerName.toLowerCase().contains(keyword) || curr.movieName.toLowerCase().contains(keyword)) {
                System.out.println("Ticket ID: " + curr.ticketId +
                        ", Customer: " + curr.customerName +
                        ", Movie: " + curr.movieName +
                        ", Seat: " + curr.seatNumber);
                found = true;
            }
            curr = curr.next;
        } while (curr != tail.next);

        if (!found) {
            System.out.println("No tickets found for the search keyword.");
        }
    }

    // Calculate total number of booked tickets
    public int totalTickets() {
        if (tail == null) return 0;
        int count = 0;
        Ticket curr = tail.next;
        do {
            count++;
            curr = curr.next;
        } while (curr != tail.next);
        return count;
    }

   
    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();

        trs.addTicket(101, "Alice", "Avengers", "A1", LocalDateTime.now().minusHours(2));
        trs.addTicket(102, "Bob", "Inception", "B3", LocalDateTime.now().minusHours(1));
        trs.addTicket(103, "Charlie", "Avengers", "A2", LocalDateTime.now().minusMinutes(30));

        trs.displayTickets();

        System.out.println("\nSearch tickets for 'Avengers':");
        trs.searchTicket("Avengers");

        System.out.println("\nSearch tickets for customer 'Bob':");
        trs.searchTicket("Bob");

        System.out.println("\nTotal tickets booked: " + trs.totalTickets());

        System.out.println("\nRemoving ticket with ID 102");
        trs.removeTicket(102);
        trs.displayTickets();

        System.out.println("\nTotal tickets booked after removal: " + trs.totalTickets());
    }
}
