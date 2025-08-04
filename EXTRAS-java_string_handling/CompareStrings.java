import java.util.Scanner;

public class CompareStrings {

    private static int lexCmp(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            char ca = a.charAt(i), cb = b.charAt(i);
            if (ca != cb) return ca - cb;
        }
        return a.length() - b.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First string: ");  String s1 = sc.nextLine();
        System.out.print("Second string: "); String s2 = sc.nextLine();

        int cmp = lexCmp(s1, s2);
        if (cmp < 0) System.out.printf("\"%s\" comes before \"%s\"%n", s1, s2);
        else if (cmp > 0) System.out.printf("\"%s\" comes before \"%s\"%n", s2, s1);
        else System.out.println("Strings are identical");
    }
}
