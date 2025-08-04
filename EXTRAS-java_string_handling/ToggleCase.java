import java.util.Scanner;

public class ToggleCase {

    private static String toggle(String s) {
        StringBuilder out = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) out.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch)) out.append(Character.toUpperCase(ch));
            else out.append(ch);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String s = sc.nextLine();
        System.out.println("Toggled: " + toggle(s));
    }
}
