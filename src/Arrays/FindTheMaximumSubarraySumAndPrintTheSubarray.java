package Arrays;

public class FindTheMaximumSubarraySumAndPrintTheSubarray {

    // Function to find the maximum subarray sum and also print the subarray
    public static long maxSubarraySum(int[] arr, int n){
        long maxi = Long.MIN_VALUE;      // stores the maximum sum found so far
        long sum = 0;                    // running sum of current subarray

        int start = 0;                   // tentative starting index of current subarray
        int ansStart = -1, ansEnd = -1;  // stores start & end indices of the best subarray

        // Traverse the array
        for(int i = 0; i < n; i++){
            // If current sum becomes 0, reset potential starting index
            if(sum == 0) start = i;

            // Add current element to running sum
            sum += arr[i];

            // If new maximum is found, update result and indices
            if (sum > maxi){
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum becomes negative, discard it (reset for next subarray)
            if(sum < 0){
                sum = 0;
            }
        }

        // Print the subarray that gives maximum sum
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");

        return maxi;    // return the maximum subarray sum

        /*Time Complexity: O(n)
              We scan the array once (for loop runs n times).

        Space Complexity: O(1)
              Only a few variables used (constant extra space).
       */
    }


    public static void main(String[] args){
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: "+maxSum);
    }
}
