import java.util.*;
public class Myclass {
    public static void Sayhello(){
    System.out.println("Hello");
    }
    public void NonStatic(){
    Sayhello();
   }
   
   public static void main (String[] args){
   Myclass obj = new Myclass();
   obj.NonStatic();
  }
}