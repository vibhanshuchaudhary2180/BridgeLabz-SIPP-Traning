public class FirstLastOccurrenceFinder {

    // Find the first occurrence of target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Move left to find earlier occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Find the last occurrence of target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Move right to find later occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 4, 4, 6, 7, 9};
        int target = 4;

        int first = findFirstOccurrence(sortedArray, target);
        int last = findLastOccurrence(sortedArray, target);

        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence of " + target + " is at index: " + first);
            System.out.println("Last occurrence of " + target + " is at index: " + last);
        }
    }
}
