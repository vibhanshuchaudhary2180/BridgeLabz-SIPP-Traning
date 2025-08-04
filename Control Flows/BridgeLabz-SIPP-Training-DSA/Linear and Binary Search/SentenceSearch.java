public class SentenceSearch {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            // Check if sentence contains the word (case-insensitive)
            // Use regex with word boundaries to match whole words only
            if (sentence.matches(".*\\b" + word + "\\b.*")) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Learning Java is fun and rewarding.",
            "This sentence does not contain the keyword.",
            "Another example sentence here."
        };

        String wordToFind = "Java";

        String result = findSentenceWithWord(sentences, wordToFind);
        System.out.println("Result: " + result);
    }
}
