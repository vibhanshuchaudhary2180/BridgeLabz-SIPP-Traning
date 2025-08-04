import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordFrequencyCounter <filename>");
            return;
        }

        String filename = args[0];
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read file and count words
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split line into words based on non-word characters
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Total number of words
        int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total number of words: " + totalWords);

        // Sort words by frequency descending
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Display top 5 words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
