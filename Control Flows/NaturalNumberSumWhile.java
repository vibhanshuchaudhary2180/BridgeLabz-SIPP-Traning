import java.util.Scanner;

public class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a number: ");
        int n = scanner.nextInt();


        if (n <= 0) {
            System.out.println("The number is not a natural number. Please enter a positive integer.");
        } else {

            int sumWhile = 0, i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }

        
            int sumFormula = n * (n + 1) / 2;

          
            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula   : " + sumFormula);

       
            if (sumWhile == sumFormula) {
                System.out.println("Both computations are correct and match.");
            } else {
                System.out.println("Results do not match. Check the logic.");
            }
        }

        scanner.close();
    }
}