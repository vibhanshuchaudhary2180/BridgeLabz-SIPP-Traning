import java.io.*;

public class FileCopyPerformance {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";      // Change to your large file path
        String destFileUnbuffered = "copy_unbuffered.dat";
        String destFileBuffered = "copy_buffered.dat";

        try {
            long unbufferedTime = copyFileUnbuffered(sourceFile, destFileUnbuffered);
            long bufferedTime = copyFileBuffered(sourceFile, destFileBuffered);

            System.out.println("Unbuffered copy time (ms): " + (unbufferedTime / 1_000_000));
            System.out.println("Buffered copy time (ms): " + (bufferedTime / 1_000_000));

            System.out.println("Performance improvement: " + 
                ((double) unbufferedTime / bufferedTime) + "x faster with buffering");

        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }

    // Copy file without buffering
    private static long copyFileUnbuffered(String source, String dest) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long startTime = 0;
        long endTime = 0;

        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            startTime = System.nanoTime();

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();

        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }

        return endTime - startTime;
    }

    // Copy file with buffering
    private static long copyFileBuffered(String source, String dest) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        long startTime = 0;
        long endTime = 0;

        try {
            bis = new BufferedInputStream(new FileInputStream(source), BUFFER_SIZE);
            bos = new BufferedOutputStream(new FileOutputStream(dest), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            startTime = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            // Flush to ensure all data is written
            bos.flush();

            endTime = System.nanoTime();

        } finally {
            if (bis != null) bis.close();
            if (bos != null) bos.close();
        }

        return endTime - startTime;
    }
}
