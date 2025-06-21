import java.util.Scanner;
public class VolumeOfCylinder
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the radius");
    double radius = sc.nextDouble();
    System.out.println("Enter the height");
    double height = sc.nextDouble();
    double Volume = Math.PI * radius*radius * height;
    System.out.println("Volume of the Cylinder is : " + Volume);
 }
}