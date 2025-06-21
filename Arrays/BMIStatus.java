import java.util.Scanner;

public class BMIStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = scanner.nextInt();
        
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
  
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
       
            do {
                System.out.print("Enter weight (kg): ");
                weights[i] = scanner.nextDouble();
            } while (weights[i] <= 0);
            
        
            do {
                System.out.print("Enter height (meters): ");
                heights[i] = scanner.nextDouble();
            } while (heights[i] <= 0);
            
  
            bmis[i] = weights[i] / (heights[i] * heights[i]);
        
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
    
        System.out.println("\nBMI Analysis Results:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.printf("Height: %.2f meters\n", heights[i]);
            System.out.printf("Weight: %.2f kg\n", weights[i]);
            System.out.printf("BMI: %.2f\n", bmis[i]);
            System.out.println("Weight Status: " + statuses[i]);
        }
        
        scanner.close();
    }
} 