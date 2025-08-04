import java.util.Scanner;

public class PalindromeCheck {

    private static boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println(isPal(s) ? "Palindrome" : "Not a palindrome");
    }
}

