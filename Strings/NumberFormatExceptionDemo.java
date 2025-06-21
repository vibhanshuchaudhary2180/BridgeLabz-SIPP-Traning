import java.util.Scanner;

public class NumberFormatExceptionDemo {
    

    public static void generateException(String text) {
        
        System.out.println("Parsed number: " + Integer.parseInt(text));
    }
    

    public static void handleException(String text) {
        try {

            System.out.println("Parsed number: " + Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string (preferably not a number): ");
        String text = scanner.nextLine();
        
        System.out.println("\nGenerating NumberFormatException:");
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\nHandling NumberFormatException:");
        handleException(text);
        
        scanner.close();
    }
} 