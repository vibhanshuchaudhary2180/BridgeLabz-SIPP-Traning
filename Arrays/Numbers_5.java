import java.util.Scanner;
public class Numbers_5 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] numbers = new int[5];
    
    System.out.println("Enter 5 numbers: ");
    for(int i=0; i<numbers.length; i++){
    numbers[i] = sc.nextInt();
    }
 
    for(int i=0; i<numbers.length; i++){
    if(numbers[i] > 0){
    if(numbers[i] % 2 == 0){
    System.out.println(numbers[i] + "Number is Even");
    }else{
    System.out.println(numbers[i]  + "Number is Odd");
    }
   }
    else if(numbers[i] < 0){
    System.out.println("Negative");
    }else{
    System.out.println("0");
    }
   }

   if(numbers[0] == numbers[numbers.length - 1]){
   System.out.println("First Element is equal to last element");
   }else if(numbers[0] > numbers[numbers.length - 1]){
   System.out.println("First Element is greater than last element");
   }else{
   System.out.println("First Element is less than last element");
   }
  }
 }