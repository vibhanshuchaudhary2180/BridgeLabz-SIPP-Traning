import java.util.Scanner;

public class SubstringOccurrences {

    private static int count(String text, String sub) {
        if (sub.isEmpty()) return 0;
        int cnt = 0;
        for (int i = 0; i <= text.length() - sub.length(); i++)
            if (text.regionMatches(i, sub, 0, sub.length())) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");      String text = sc.nextLine();
        System.out.print("Substring: "); String sub  = sc.nextLine();
        System.out.println("Occurrences: " + count(text, sub));
    }
}
