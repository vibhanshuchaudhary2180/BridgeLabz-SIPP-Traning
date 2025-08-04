import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {

    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "programming";
        String result = removeDuplicates(original);

        System.out.println("Original String: " + original);
        System.out.println("String after removing duplicates: " + result);
    }
}
