import java.util.Scanner;
public class PowerCalculation
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the base");
    double base = sc.nextDouble();
    System.out.println("Enter the Exponent");
    double exponent = sc.nextDouble();
    double Result = Math.pow(base,exponent);
    System.out.println(Result);
 }
}