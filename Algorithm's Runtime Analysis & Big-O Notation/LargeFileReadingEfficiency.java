import java.io.*;

public class LargeFileReadingEfficiency {

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt";  // Replace with your large file path

        // Measure time taken by FileReader
        long startTime = System.nanoTime();
        int fileReaderChars = readFileUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.printf("FileReader read %d chars in %.3f seconds%n", fileReaderChars, (endTime - startTime) / 1_000_000_000.0);

        // Measure time taken by InputStreamReader
        startTime = System.nanoTime();
        int inputStreamReaderChars = readFileUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.printf("InputStreamReader read %d chars in %.3f seconds%n", inputStreamReaderChars, (endTime - startTime) / 1_000_000_000.0);
    }

    private static int readFileUsingFileReader(String filePath) throws IOException {
        int totalChars = 0;
        try (FileReader fr = new FileReader(filePath)) {
            char[] buffer = new char[8192];  // buffer size to optimize reading
            int charsRead;
            while ((charsRead = fr.read(buffer)) != -1) {
                totalChars += charsRead;
            }
        }
        return totalChars;
    }

    private static int readFileUsingInputStreamReader(String filePath) throws IOException {
        int totalChars = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[8192];  // same buffer size
            int charsRead;
            while ((charsRead = isr.read(buffer)) != -1) {
                totalChars += charsRead;
            }
        }
        return totalChars;
    }
}
