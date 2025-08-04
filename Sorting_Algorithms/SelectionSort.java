public class SelectionSort {

    // Function to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of unsorted subarray
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] examScores = {88, 75, 92, 65, 70, 85, 90};

        System.out.println("Original Exam Scores:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores (Ascending):");
        printArray(examScores);
    }
}
