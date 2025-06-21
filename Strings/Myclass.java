// NonStatic class to Static class
import java.util.*;
public class Myclass {

    public void NonStatic(){
    System.out.println("Hello");
    }
  
    public static void Sayhello(){
     Myclass obj = new Myclass();
     obj.NonStatic();
   }
   
   public static void main (String[] args){
   Myclass obj = new Myclass();
   obj.Sayhello();
  }
}

//Static class to NonStatic class
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