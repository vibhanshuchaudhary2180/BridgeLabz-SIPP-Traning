public class QuickSortProducts {

    // Partition function: places pivot at correct position
    // and partitions array around pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing the last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return the partition index
    }

    // QuickSort recursive function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] productPrices = {500, 150, 700, 350, 200, 600, 450};

        System.out.println("Original Product Prices:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices (Ascending):");
        printArray(productPrices);
    }
}
