package Arrays;

public class RightRotateArrayByKElements {

    // ---------------- Approach 1: Using Temp Array ----------------
    // Time Complexity: O(n), Space Complexity: O(k)
    public static void rotateToRightTemp(int[] arr, int n, int k) {
        if (n == 0) return;
        k = k % n;
        if (k > n) return;

        int[] temp = new int[k];
        // Copy last k elements into temp
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        // Shift remaining elements to the right
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        // Put temp back at beginning
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }

    // ---------------- Approach 2: Using Reversal ----------------
    // Time Complexity: O(n), Space Complexity: O(1)
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateToRightReverse(int[] arr, int n, int k) {
        k = k % n;
        if (k > n) return;

        // Reverse first n-k elements
        reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        reverse(arr, n - k, n - 1);
        // Reverse the whole array
        reverse(arr, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        int k = 2;

        // Approach 1: Temp Array
        rotateToRightTemp(arr1, n, k);
        System.out.print("After Rotating Right (Temp Array Method): ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        // Approach 2: Reversal
        rotateToRightReverse(arr2, n, k);
        System.out.print("After Rotating Right (Reversal Method):   ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
