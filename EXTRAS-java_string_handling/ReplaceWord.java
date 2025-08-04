import java.util.Scanner;
import java.util.regex.Pattern;

public class ReplaceWord {

    private static String replace(String sentence, String oldW, String newW) {
        return sentence.replaceAll("\\b" + Pattern.quote(oldW) + "\\b", newW);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sentence: ");          String sentence = sc.nextLine();
        System.out.print("Word to replace: ");   String oldW = sc.next();
        System.out.print("Replacement word: ");  String newW = sc.next();
        System.out.println("Result: " + replace(sentence, oldW, newW));
    }
}

