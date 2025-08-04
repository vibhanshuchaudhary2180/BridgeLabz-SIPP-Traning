import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

    private static boolean anagram(String a, String b) {
        char[] x = a.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] y = b.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First string: ");  String s1 = sc.nextLine();
        System.out.print("Second string: "); String s2 = sc.nextLine();
        System.out.println(anagram(s1, s2) ? "Anagrams" : "Not anagrams");
    }
}

