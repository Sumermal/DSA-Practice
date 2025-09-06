package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public  static void bruteForce(int[] arr, int target){
        int n = arr.length;
        boolean found = false;

        //Outer loop: pick the first element
        for(int i = 0; i < n; i++){
            //Inner loop: pair it with every element after i
            for(int j = i + 1; j < n; j++){
                //Check if the sum matches the target
                if(arr[i] + arr[j] == target){
                    System.out.println("[" + i + "," + j + "]");
                    found = true;
                }
            }
        }
        //If no pair found
        if(!found){
            System.out.println("No valid pair found.");
        }

        // Time Complexity: O(n^2) → two nested loops
        // Space Complexity: O(1) → no extra space used
    }

    public static void betterApproach(int[] arr, int target){

        // Better approach: Use HashMap to store elements and their indices
        // Time Complexity: O(n) → each element is processed once
        // Space Complexity: O(n) → HashMap stores up to n elements

        int n = arr.length;
        boolean found = false;

        // Map to store: value → index
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int moreNeeded = target - num;          // value we need to form target

            if(mpp.containsKey(moreNeeded)){        // If the required value is already in map, we found a pair
                int ans = mpp.get(moreNeeded);
                System.out.printf("[" + ans + "," + i + "]");
                found = true;
            }
            // Store current number with its index
            mpp.put(arr[i],i);
        }
        // If no pair found
        if(!found){
            System.out.println("No valid pair found.");
        }
    }

    public static String optimalApproach(int[] arr, int target){
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0, right = n - 1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                return "YES";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return "NO";
    }

    public static void main(String[] args){
        int target = 4;
        int[] arr1 = {1,2,3,4};
        bruteForce(arr1,target);

        int[] arr2 = {1,2,3,4};
        System.out.println("Hashing: ");
        betterApproach(arr2,target);

        int[] arr3 = {1,2,3,4};
        System.out.println("Two pointers Approach: ");
        String ans = optimalApproach(arr3,target);
        System.out.println(ans);
    }
}
