import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        // Move the 'first' iterator n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("List is shorter than " + n + " elements.");
            }
            first.next();
        }

        // Move both iterators until 'first' reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<>();
        input.add("A");
        input.add("B");
        input.add("C");
        input.add("D");
        input.add("E");

        int N = 2;
        String result = findNthFromEnd(input, N);
        System.out.println("N-th element from the end (N=" + N + "): " + result);
    }
}
