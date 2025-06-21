public class NullPointerDemo {


    public static void generateException() {
        String text = null;

        System.out.println("Length of text: " + text.length());
    }


    public static void handleNullPointerException() {
        String text = null;
        try {
         
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
    
            System.out.println("Caught a NullPointerException!");
            System.out.println("Exception Message: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
    
        System.out.println("Demonstrating exception (will crash):");
    
        System.out.println("\nNow handling the exception safely:");
        handleNullPointerException();
    }
}