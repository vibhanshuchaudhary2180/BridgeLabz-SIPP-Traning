import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInfoSaver {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;

        try {
            // Read user inputs
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Open file writer (overwrites if file exists)
            writer = new FileWriter("userinfo.txt");

            // Write data to file
            writer.write("Name: " + name + System.lineSeparator());
            writer.write("Age: " + age + System.lineSeparator());
            writer.write("Favorite Programming Language: " + language + System.lineSeparator());

            System.out.println("Information saved to userinfo.txt");

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.err.println("Failed to close reader: " + e.getMessage());
            }
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Failed to close writer: " + e.getMessage());
            }
        }
    }
}
