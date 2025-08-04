public class MergeSortBooks {

    // Merge two sorted subarrays arr[l..m] and arr[m+1..r]
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        // Merge temp arrays back into arr[l..r]
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Recursive Merge Sort function
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first half
            mergeSort(arr, l, m);

            // Sort second half
            mergeSort(arr, m + 1, r);

            // Merge sorted halves
            merge(arr, l, m, r);
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] bookPrices = {450, 120, 300, 150, 200, 400, 350};

        System.out.println("Original Book Prices:");
        printArray(bookPrices);

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices (Ascending):");
        printArray(bookPrices);
    }
}
