import java.util.Scanner;

public class MostFrequentCharacter {

    private static char mostFreq(String s) {
        int[] freq = new int[256];
        for (char ch : s.toCharArray()) freq[ch]++;
        int best = -1;
        char bestCh = 0;
        for (char ch : s.toCharArray())
            if (freq[ch] > best) { best = freq[ch]; bestCh = ch; }
        return bestCh;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Most frequent character: '" + mostFreq(s) + "'");
    }
}
