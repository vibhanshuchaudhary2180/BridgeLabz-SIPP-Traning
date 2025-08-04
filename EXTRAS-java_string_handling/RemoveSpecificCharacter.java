import java.util.Scanner;
public class RemoveSpecificCharacter {

    private static String remove(String s, char target) {
        StringBuilder out = new StringBuilder();
        for (char ch : s.toCharArray()) if (ch != target) out.append(ch);
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String: ");        String s = sc.nextLine();
        System.out.print("Char to remove: ");char target = sc.nextLine().charAt(0);
        System.out.println("Modified: " + remove(s, target));
    }
}

