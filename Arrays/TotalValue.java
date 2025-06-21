import java.util.Scanner;

public class TotalValue {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0;
        int index = 0;

        while (true) {
             if (index == 10) {
             System.out.println("Numbers reached the maximum limit.");
             break;
            }
            System.out.print("Enter the number 0 or negative to break: ");
            double input = sc.nextDouble();

            if (input <= 0) {
                break;
            }

            numbers[index] = input;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("Numbers Entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nTotal of all the numbers: " + total);
        sc.close();
    }
}