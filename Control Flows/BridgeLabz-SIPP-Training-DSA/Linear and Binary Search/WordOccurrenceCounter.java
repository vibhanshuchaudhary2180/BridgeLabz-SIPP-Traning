import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordOccurrenceCounter {

    public static int countWordInFile(String filePath, String targetWord) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split line into words using non-word characters as delimiters
                String[] words = line.split("\\W+");

                for (String word : words) {
                    // Compare ignoring case
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "example.txt";  // Replace with your file path
        String targetWord = "hello";       // Word to count

        int occurrences = countWordInFile(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times.");
    }
}
