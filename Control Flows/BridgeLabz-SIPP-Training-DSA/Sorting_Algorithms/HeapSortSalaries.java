public class HeapSortSalaries {

    // Function to heapify a subtree rooted at index i in array of size n
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] salaryDemands = {55000, 72000, 48000, 60000, 65000, 58000};

        System.out.println("Original Salary Demands:");
        printArray(salaryDemands);

        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands (Ascending):");
        printArray(salaryDemands);
    }
}
