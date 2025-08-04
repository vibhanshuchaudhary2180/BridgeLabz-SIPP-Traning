

import java.util.*;
public class CountVowelConsoneant {
    private static int[] countVC(String s) {
        int v = 0, c = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) >= 0) v++;
                else c++;
            }
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int[] res = countVC(input);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
    }

}
