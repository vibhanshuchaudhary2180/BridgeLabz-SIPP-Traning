import java.util.Scanner;

public class WordLengthFinder {
    
  
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
    
 
    public static String[] splitText(String text) {
      
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;
      
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = text.substring(startIndex, i);
                wordIndex++;
                startIndex = i + 1;
            }
        }
        words[wordIndex] = text.substring(startIndex);
        
        return words;
    }
    
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }
    
    
    public static void displayResults(String[][] wordLengths) {
        System.out.println("\nWord Lengths");
        System.out.println("------------------------");
        System.out.printf("%-20s %-10s%n", "Word", "Length");
        System.out.println("------------------------");
        
        for (String[] row : wordLengths) {
            System.out.printf("%-20s %-10s%n", row[0], row[1]);
        }
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
    
        String[] words = splitText(text);
       
        String[][] wordLengths = getWordLengths(words);
        
   
        displayResults(wordLengths);
        
        scanner.close();
    }
} 