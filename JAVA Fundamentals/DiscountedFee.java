import java.util.Scanner;
public class DiscountedFee
{
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the course fee :");
    double fee = sc.nextDouble();

    System.out.println("Enter the university discount %");
    double discountprcnt = sc.nextDouble();

    double discount = (discountprcnt / 100) * fee;
    double finalfee = fee - discount; 
    System.out.println("The discount amount is INR: " + discount + " and final discounted fee is INR: " + finalfee + " Rs");
    
 }
}