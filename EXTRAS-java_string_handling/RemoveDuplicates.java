import java.util.Scanner;

public class RemoveDuplicates {

    private static String unique(String s) {
        boolean[] seen = new boolean[256];
        StringBuilder out = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!seen[ch]) { seen[ch] = true; out.append(ch); }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string: ");
        String s = sc.nextLine();
        System.out.println("Without duplicates: " + unique(s));
    }
}
