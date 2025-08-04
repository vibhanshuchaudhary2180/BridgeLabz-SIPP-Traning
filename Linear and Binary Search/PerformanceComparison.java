import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PerformanceComparison {

    private static final int CONCAT_TIMES = 1_000_000;
    private static final String SAMPLE_STRING = "hello";
    private static final String FILE_PATH = "largefile.txt"; // Replace with your 100MB file path

    // Concatenate using StringBuilder
    public static long testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = 0; i < CONCAT_TIMES; i++) {
            sb.append(SAMPLE_STRING);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Concatenate using StringBuffer
    public static long testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();

        for (int i = 0; i < CONCAT_TIMES; i++) {
            sb.append(SAMPLE_STRING);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Count words using FileReader
    public static long countWordsFileReader() {
        int wordCount = 0;
        long startTime = System.nanoTime();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split on whitespace
                String[] words = line.trim().split("\\s+");
                if (words.length == 1 && words[0].isEmpty()) {
                    continue; // empty line
                }
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.err.println("FileReader error: " + e.getMessage());
            return -1;
        }

        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount);
        return endTime - startTime;
    }

    // Count words using InputStreamReader
    public static long countWordsInputStreamReader() {
        int wordCount = 0;
        long startTime = System.nanoTime();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_PATH), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split on whitespace
                String[] words = line.trim().split("\\s+");
                if (words.length == 1 && words[0].isEmpty()) {
                    continue; // empty line
                }
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.err.println("InputStreamReader error: " + e.getMessage());
            return -1;
        }

        long endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount);
        return endTime - startTime;
    }

    public static void main(String[] args) {
        System.out.println("Starting concatenation tests...");
        long sbTime = testStringBuilder();
        System.out.println("StringBuilder time: " + sbTime / 1_000_000 + " ms");

        long sbfTime = testStringBuffer();
        System.out.println("StringBuffer time: " + sbfTime / 1_000_000 + " ms");

        System.out.println("\nStarting file reading tests...");
        long frTime = countWordsFileReader();
        if (frTime != -1)
            System.out.println("FileReader time: " + frTime / 1_000_000 + " ms");

        long isrTime = countWordsInputStreamReader();
        if (isrTime != -1)
            System.out.println("InputStreamReader time: " + isrTime / 1_000_000 + " ms");
    }
}
