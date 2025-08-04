public class InsertionSort {

    // Function to perform Insertion Sort
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            // Move elements of employeeIDs[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    // Utility method to print array elements
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108, 104};

        System.out.println("Unsorted Employee IDs:");
        printArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending):");
        printArray(employeeIDs);
    }
}
