package Arrays;

public class LeftRotateArrayByKElements {

    // ---------------- Approach 1: Using Temp Array ----------------
    // Time Complexity: O(n), Space Complexity: O(k)
    public static void rotateToLeftTemp(int[] arr, int n, int k) {
        if (n == 0) return;
        k = k % n;
        if (k > n) return;

        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];
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

    public static void rotateToLeftReverse(int[] arr, int n, int k) {
        k = k % n;
        if (k > n) return;

        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        reverse(arr, k, n - 1);
        // Reverse whole array
        reverse(arr, 0, n - 1);
    }


    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        int k = 2;

        // Approach 1: Temp Array
        rotateToLeftTemp(arr1, n, k);
        System.out.print("After Rotating Left (Temp Array Method): ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        // Approach 2: Reversal
        rotateToLeftReverse(arr2, n, k);
        System.out.print("After Rotating Left (Reversal Method):   ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
