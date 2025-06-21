import java.util.Scanner;

public class TextTrimmer {
    

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    

    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;
        
  
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end};
    }
    
   
    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }
    

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text with spaces: ");
        String text = scanner.nextLine();
     
        int[] indices = findTrimIndices(text);
        
   
        String trimmed1 = createSubstring(text, indices[0], indices[1]);
    
        String trimmed2 = text.trim();
        
   
        boolean areEqual = compareStrings(trimmed1, trimmed2);
        
        System.out.println("\nResults:");
        System.out.println("Original text: \"" + text + "\"");
        System.out.println("Trimmed using charAt(): \"" + trimmed1 + "\"");
        System.out.println("Trimmed using trim(): \"" + trimmed2 + "\"");
        System.out.println("Are the results equal? " + areEqual);
        
        scanner.close();
    }
} 