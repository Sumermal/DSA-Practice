package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSumK {

    public static void bruteForce(int[] arr, int k){
        int n = arr.length;

        int len = 0;

        //Outer loop -> pick every starting index
        for(int i = 0; i < n; i++){
            int s = 0; 
            
            //Inner loop -> extends subarray till the end
            for(int j = i; j < n; j++){
                s += arr[j];            //Add current element

                //If sum == k, update maximum length
                if(s == k){
                    len = Math.max(len,j-1+1);
                    //(j - i + 1) = subarray length from i to j
                }
            }
        }
        System.out.println(len);

        /*
        Time Complexity: O(n^2)
            - Outer loop runs n times.
            - Inner loop runs (n-i) times on average → O(n^2) overall.

        Space Complexity: O(1)
            - No extra data structures used.
       */
    }

    public static void betterApproach(int[] arr, int k){
        int n = arr.length;

        // Map to store prefixSum -> earliest index where this sum occurred
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];

            // Case 1: If prefix sum itself equals k,
            // then subarray from 0...i has sum = k
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            // Case 2: Check if (sum - k) has been seen before
            // If yes, then subarray between (index after that) and current index has sum = k
            long rem = sum - k;

            if(preSumMap.containsKey(rem)){
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store current prefix sum if it's not already present
            // (We store only the earliest index for maximum length)
            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum,i);
            }
        }
        System.out.println(maxLen);


        /*
        Time Complexity: O(n)
            - We iterate over the array once.
            - HashMap operations (put/get/contains) take O(1) on average.

        Space Complexity: O(n)
            - HashMap stores at most n different prefix sums.
       */
    }

    public static void optimalApproach(int[] arr, int k){
        int n = arr.length;

        int left = 0, right = 0;           // 2 pointers
        long sum = arr[0];
        int maxLen = 0;

        while(right < n){
            //if sum > k, reduce the subarray from left
            //until sum becomes less or equal to k:
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }

            //if sum = k, update the maxLen
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            //Move forward the right pointer:
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        System.out.println(maxLen);

        /*
        Time Complexity: O(n)
            - Each element is visited at most twice:
              once by the right pointer and once by the left pointer.
            - Hence, linear complexity.

        Space Complexity: O(1)
            - We only use variables (no extra data structures).
        */
    }

    public static void main(String[] args){
        int k = 5;

        int[] arr1 = {2, 3, 5};
        bruteForce(arr1,k);

        int[] arr2 = {2, 3, 5};
        betterApproach(arr2,k);

        int[] arr3 = {2, 3, 5};
        optimalApproach(arr3,k);
    }
}
