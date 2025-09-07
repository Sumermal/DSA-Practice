package Arrays;

public class NextPermutation {

    // Function to compute the next greater permutation
    // Time Complexity: O(n) -> we scan the array a few times (linear work).
    // Space Complexity: O(1) -> we only use a few extra variables.
    public static int[] nextGreaterPermutation(int[] arr, int n) {
        // Step 1: Find the break point (first element from right which is smaller than its next)
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) { // O(n)
            if (arr[i] < arr[i + 1]) {
                ind = i; // index i is the break point
                break;
            }
        }

        // Step 2: If no break point, reverse the whole array (means array is in descending order)
        if (ind == -1) {
            reverse(arr, 0, n - 1); // O(n)
            return arr;
        }

        // Step 3: Find the next greater element (to the right of ind)
        // and swap it with arr[ind].
        for (int i = n - 1; i > ind; i--) { // O(n) in worst case
            if (arr[i] > arr[ind]) {
                swap(arr, i, ind);
                break;
            }
        }

        // Step 4: Reverse the right half (smallest arrangement after ind)
        reverse(arr, ind + 1, n - 1); // O(n)

        return arr;
    }

    // Utility function to swap elements
    // Time Complexity: O(1)
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility function to reverse a portion of the array
    // Time Complexity: O(n) in worst case (if reversing the whole array).
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int n = arr.length;

        // Call function
        int[] ans = nextGreaterPermutation(arr, n);

        // Print result
        System.out.print("The next permutation is: [");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("]");
    }
}
