import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileCopyExample {

    public static void main(String[] args) {
        // Change these paths to your actual source and destination files
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File(sourceFile);
            if (!src.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            // Open input stream
            fis = new FileInputStream(src);

            File dest = new File(destinationFile);

            // Ensure destination file exists; create if not
            if (!dest.exists()) {
                dest.createNewFile();
            }

            // Open output stream
            fos = new FileOutputStream(dest);

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            // Close streams safely
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Failed to close input stream: " + e.getMessage());
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Failed to close output stream: " + e.getMessage());
            }
        }
    }
}
