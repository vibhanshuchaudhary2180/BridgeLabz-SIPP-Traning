public class BubbleSort {

    // Function to perform Bubble Sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Utility method to print array elements
    public static void printArray(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] studentMarks = {85, 42, 73, 91, 55, 68, 99, 30};

        System.out.println("Original Marks:");
        printArray(studentMarks);

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks (Ascending):");
        printArray(studentMarks);
    }
}
