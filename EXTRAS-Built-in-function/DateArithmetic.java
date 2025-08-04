import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input, fmt);

        LocalDate updated = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Updated date after additions and subtraction: " + updated);
    }
}
