import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    
  
    public static void generateException(String[] names) {
     
        System.out.println("Accessing index beyond array length: " + names[names.length]);
    }
    
 
    public static void handleException(String[] names) {
        try {
         
            System.out.println("Accessing index beyond array length: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] names = new String[size];
    
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);
        
        scanner.close();
    }
} 