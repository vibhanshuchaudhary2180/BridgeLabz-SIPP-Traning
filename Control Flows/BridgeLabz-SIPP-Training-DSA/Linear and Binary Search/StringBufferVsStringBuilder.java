public class StringBufferVsStringBuilder {

    public static void main(String[] args) {
        int n = 1_000_000;
        String sample = "hello";

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(sample);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(sample);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Output results in milliseconds
        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");
    }
}
