import java.util.Scanner;
public class CalculateSimpleInterest
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the Principle");
    int Principal = sc.nextInt();

    System.out.println("Enter the Rate");
    int Rate = sc.nextInt();

    System.out.println("Enter the Time");
    double Time = sc.nextDouble();

    double SI = (Principal * Rate * Time) / 100;
    System.out.println("The Simple Interest is :" + SI);
 }
}