import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Initialize with sum = 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If this sum has been seen before, zero-sum subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Store current index for this cumulative sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // Utility to print result
    public static void printSubarrays(List<int[]> subarrays, int[] arr) {
        for (int[] sub : subarrays) {
            System.out.print("Subarray [");
            for (int i = sub[0]; i <= sub[1]; i++) {
                System.out.print(arr[i] + (i < sub[1] ? ", " : ""));
            }
            System.out.println("]");
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2, 1, 4, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        printSubarrays(subarrays, arr);
    }
}
