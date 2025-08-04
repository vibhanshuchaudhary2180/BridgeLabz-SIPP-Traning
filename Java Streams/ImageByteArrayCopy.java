import java.io.*;

public class ImageByteArrayCopy {

    public static void main(String[] args) {
        String originalFile = "original.jpg";  // change to your source image path
        String copiedFile = "copy.jpg";         // destination image path

        try {
            // Read original file into byte array using ByteArrayOutputStream
            byte[] imageBytes = fileToByteArray(originalFile);

            // Write byte array back to a new file using ByteArrayInputStream
            byteArrayToFile(imageBytes, copiedFile);

            // Verify files are identical
            boolean identical = compareFiles(originalFile, copiedFile);
            if (identical) {
                System.out.println("Success! The copied file is identical to the original.");
            } else {
                System.out.println("Warning! The copied file differs from the original.");
            }

        } catch (IOException e) {
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }

    // Reads a file into a byte array
    private static byte[] fileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Writes a byte array to a file
    private static void byteArrayToFile(byte[] bytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Compares two files byte-by-byte
    private static boolean compareFiles(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] buf1 = new byte[4096];
            byte[] buf2 = new byte[4096];

            int read1, read2;
            while ((read1 = fis1.read(buf1)) != -1) {
                read2 = fis2.read(buf2);

                if (read1 != read2) return false;

                for (int i = 0; i < read1; i++) {
                    if (buf1[i] != buf2[i]) return false;
                }
            }

            // Check if second file has extra bytes
            return fis2.read() == -1;
        }
    }
}
