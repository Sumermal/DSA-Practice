package Arrays;

public class MaximumSubarraySumInAnArray {

    //  Approach 1: Prefix sum with 2 loops (O(n^2))
    // Time: O(n^2), Space: O(1)
    public static int maxSubarraySumON2(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i...j]
                sum += arr[j];               // accumulate sum
                maxi = Math.max(maxi, sum);  // update maximum
            }
        }

        return maxi;
    }

    // Approach 2: Kadane’s Algorithm (O(n))
    // Time: O(n), Space: O(1)
    public static long maxSubarraySumKadane(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;               // current running sum

        for (int i = 0; i < n; i++) {
            sum += arr[i];                 // add current element
            maxi = Math.max(maxi, sum);    // update maximum
            if (sum < 0) sum = 0;          // reset if sum negative
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;

        int ans1 = maxSubarraySumON2(arr, n);
        long ans2 = maxSubarraySumKadane(arr, n);

        System.out.println("Maximum Subarray Sum (O(n^2) method): " + ans1);
        System.out.println("Maximum Subarray Sum (Kadane O(n) method): " + ans2);
    }
}

