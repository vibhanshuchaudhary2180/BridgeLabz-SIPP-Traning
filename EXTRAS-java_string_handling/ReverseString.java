import java.util.Scanner;

public class ReverseString {

    private static String reverse(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        }
        return new String(a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String to reverse: ");
        String s = sc.nextLine();
        System.out.println("Reversed: " + reverse(s));
    }
}
