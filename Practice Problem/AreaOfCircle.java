import java.util.Scanner;
public class AreaOfCircle
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the radius");
    double radius = sc.nextDouble();
    double Area = Math.PI * radius*radius;
    System.out.println("Area of the circle is: " + Area);
 }
}