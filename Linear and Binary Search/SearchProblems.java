import java.util.Arrays;

public class SearchProblems {

    // Linear Search approach to find first missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers, zeros, and numbers > n with a dummy number (n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use index marking for presence of numbers
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                // Mark presence by making nums[val-1] negative
                if (nums[val - 1] > 0) {
                    nums[val - 1] = -nums[val - 1];
                }
            }
        }

        // Step 3: Find first index that is positive => missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all indices are marked, then missing positive is n+1
        return n + 1;
    }

    // Binary Search to find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int missing = firstMissingPositive(nums.clone());
        System.out.println("First missing positive integer: " + missing);

        int[] sortedArr = {1, 2, 4, 5, 7, 8, 10};
        int target = 5;
        int index = binarySearch(sortedArr, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
