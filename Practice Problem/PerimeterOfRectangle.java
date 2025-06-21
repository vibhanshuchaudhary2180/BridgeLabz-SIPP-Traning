import java.util.Scanner;
public class PerimeterOfRectangle
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length");
    int length = sc.nextInt();
    System.out.println("Enter the Width");
    int width = sc.nextInt();
    int Perimeter = 2 * (length + width);
    System.out.println("Perimeter of Rectangle is: " + Perimeter);
 }
}