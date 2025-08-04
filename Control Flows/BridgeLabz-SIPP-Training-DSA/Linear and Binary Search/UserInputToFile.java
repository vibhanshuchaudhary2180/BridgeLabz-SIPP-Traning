import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputToFile {

    public static void main(String[] args) {
        String outputFile = "output.txt"; // File to write input lines

        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(outputFile);
        ) {
            System.out.println("Enter text lines (type 'exit' to quit):");
            String line;

            while (true) {
                line = br.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(line + System.lineSeparator());
            }

            System.out.println("Input saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
