import java.io.*;

public class ToLowerCaseFileCopy {

    public static void main(String[] args) {
        String sourceFile = "input.txt";    // change to your source file
        String destFile = "output.txt";     // change to your destination file

        // Use try-with-resources to auto-close streams
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();  // preserve line breaks
            }
            System.out.println("File copied successfully with all letters converted to lowercase.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
