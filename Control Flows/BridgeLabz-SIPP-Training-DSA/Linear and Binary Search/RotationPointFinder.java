public class RotationPointFinder {

    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Rotation point is in the right half
                left = mid + 1;
            } else {
                // Rotation point is in the left half (including mid)
                right = mid;
            }
        }
        // left == right is the index of the smallest element
        return left;
    }

    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12};
        int rotationIndex = findRotationPoint(rotatedArray);

        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}
