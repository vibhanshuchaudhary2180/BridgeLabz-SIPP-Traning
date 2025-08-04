import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

                // Split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        // Replace with your file path
        String filename = "input.txt";

        Map<String, Integer> wordFreq = countWordFrequency(filename);

        System.out.println(wordFreq);
        // Example Output: {hello=2, world=1, java=1}
    }
}
