public class CountingSortAges {

    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements into output array in sorted order (iterate backwards for stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 13, 18, 14, 12, 17, 11, 15};

        System.out.println("Original Student Ages:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}
