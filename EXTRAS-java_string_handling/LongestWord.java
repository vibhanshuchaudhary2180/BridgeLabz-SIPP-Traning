import java.util.Scanner;

public class LongestWord {

    private static String longest(String sentence) {
        String longest = "";
        for (String w : sentence.split("\\s+"))
            if (w.length() > longest.length()) longest = w;
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sentence: ");
        String s = sc.nextLine();
        System.out.println("Longest word: " + longest(s));
    }
}

