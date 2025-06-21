import java.util.Scanner;
public class Vote {
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ages = new int[10];
   
   

    for(int i=0; i<ages.length;i++){
    System.out.println("Enter the Age of student " + (i+1) + ":");
    ages[i] = sc.nextInt();
    }
    
    for(int i=0; i<ages.length;i++){
    if(ages[i] < 0){
    System.out.println("Invalid Age " + (i+1));
    }else if(ages[i] >= 18){
    System.out.println("The person with age " + ages[i] + " can Vote");
    }else{

     System.out.println("The person with age " + ages[i] + " cannot Vote");
}
}
}
}
