import java.util.Scanner;
public class KilometerstoMiles
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the distance in kilometers");
    double Kilometers = sc.nextDouble();
    double Miles = Kilometers * 0.621371;
    System.out.println("Kilometers to Miles : " + Miles + " Miles");
 }
}