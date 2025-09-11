package Arrays;

import java.util.*;

public class CountSubarraySumEqualsK {

    //  Approach 1: Brute Force (3 loops)
    // Check all subarrays and calculate sum each time
    public static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {          // starting index
            for (int j = i; j < n; j++) {      // ending index
                int sum = 0;
                for (int x = i; x <= j; x++) { // sum of subarray [i..j]
                    sum += arr[x];
                }
                if (sum == k) cnt++;
            }
        }
        return cnt;
    }
    /*
        Time Complexity  : O(n^3)
        Space Complexity: O(1)
    */


    //  Approach 2: Better (2 loops with cumulative sum)
    // Instead of recomputing sum each time, keep adding arr[j]
    public static int better(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // cumulative sum of subarray [i..j]
                if (sum == k) cnt++;
            }
        }
        return cnt;
    }
    /*
        Time Complexity  : O(n^2)
        Space Complexity: O(1)
    */


    //  Approach 3: Optimal (Prefix Sum + HashMap)
    // Count how many times (prefixSum - k) appeared before
    public static int optimal(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        // Base case: prefix sum = 0 occurs once
        mpp.put(0, 1);

        for (int i = 0; i < n; i++) {
            preSum += arr[i];

            // If (preSum - k) exists, add its frequency
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);

            // Store/update frequency of current preSum
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
    /*
        Time Complexity  : O(n)
        Space Complexity: O(n) (HashMap for prefix sums)
    */

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target Sum: " + k + "\n");

        int ans1 = bruteForce(arr, k);
        System.out.println("Approach 1 (Brute Force O(n^3)): " + ans1);

        int ans2 = better(arr, k);
        System.out.println("Approach 2 (Better O(n^2)): " + ans2);

        int ans3 = optimal(arr, k);
        System.out.println("Approach 3 (Optimal O(n)): " + ans3);
    }
}

