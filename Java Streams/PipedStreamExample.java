import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Create piped streams and connect them
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(new Writer(pos), "WriterThread");
            Thread readerThread = new Thread(new Reader(pis), "ReaderThread");

            readerThread.start();
            writerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error in piped streams: " + e.getMessage());
        }
    }

    static class Writer implements Runnable {
        private final PipedOutputStream pos;

        public Writer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try (PipedOutputStream out = pos) {
                String data = "Hello from Writer Thread! This is a message via piped streams.";
                byte[] bytes = data.getBytes();

                for (byte b : bytes) {
                    out.write(b);
                    // Sleep a bit to simulate delay and allow reader to read concurrently
                    Thread.sleep(50);
                }
                System.out.println("Writer finished writing data.");
            } catch (IOException | InterruptedException e) {
                System.err.println("Writer error: " + e.getMessage());
            }
        }
    }

    static class Reader implements Runnable {
        private final PipedInputStream pis;

        public Reader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try (PipedInputStream in = pis) {
                int data;
                StringBuilder sb = new StringBuilder();

                while ((data = in.read()) != -1) {
                    sb.append((char) data);
                    // Simulate processing delay
                    Thread.sleep(30);
                }
                System.out.println("Reader received data: " + sb.toString());
            } catch (IOException | InterruptedException e) {
                System.err.println("Reader error: " + e.getMessage());
            }
        }
    }
}
