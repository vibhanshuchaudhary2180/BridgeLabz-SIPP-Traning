import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    // Method to reverse a list manually
    public static <T> List<T> reverseList(List<T> inputList) {
        List<T> reversed = new ArrayList<>(); // or LinkedList<T> if you prefer
        for (int i = inputList.size() - 1; i >= 0; i--) {
            reversed.add(inputList.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Example with LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        System.out.println("Original LinkedList: " + linkedList);
        List<Integer> reversedLinkedList = reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
