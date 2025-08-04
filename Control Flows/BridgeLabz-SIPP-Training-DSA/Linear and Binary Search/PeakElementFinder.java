public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check neighbors carefully to avoid ArrayIndexOutOfBounds
            int midLeft = (mid - 1 >= 0) ? arr[mid - 1] : Integer.MIN_VALUE;
            int midRight = (mid + 1 < arr.length) ? arr[mid + 1] : Integer.MIN_VALUE;

            if (arr[mid] > midLeft && arr[mid] > midRight) {
                return mid; // mid is peak
            } else if (arr[mid] < midLeft) {
                // Peak is in the left half
                right = mid - 1;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }
        // When left == right, it must be a peak
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
