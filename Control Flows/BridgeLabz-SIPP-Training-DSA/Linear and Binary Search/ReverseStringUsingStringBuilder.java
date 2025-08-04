public class ReverseStringUsingStringBuilder {

    // Method to reverse a string using StringBuilder
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();

        // Append input string to StringBuilder
        sb.append(input);

        // Use reverse() method of StringBuilder
        sb.reverse();

        // Convert back to String and return
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverseString(original);

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
