package Arrays;

import java.util.*;

public class FindTheNumberThatAppearsOnceAndTheOtherNumbersTwice {

    public static void bruteForce(int[] arr){
        int n = arr.length;

        //Loop to select an element
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int cnt = 0;

            //another loop to find occurrences using linear search
            for(int j = 0; j < n; j++){
                if(arr[j] == num){
                    cnt++;
                }
            }

            if(cnt == 1){
                System.out.println("The Number that appears once is: "+num);
            }
        }

        /*
        Time Complexity:
           - Outer loop runs n times.
           - Inner loop runs n times for each outer loop.
           - Total = O(n * n) = O(n²)

       Space Complexity:
          - Only a few variables (num, cnt).
          - No extra data structures used.
          - Space Complexity = O(1)
       */
    }

    public static void UsingHashing(int[] arr){
        int n = arr.length;

        //Find the maximum element
        int maxi = arr[0];
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi,arr[i]);
        }

        //Declare hash array of size max+1
        //and hash the array
        int[] hash = new int[maxi+1];
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        }

        //Find the single element from hash and return it
        for(int i = 0; i < n; i++){
            if(hash[arr[i]] == 1){
                System.out.println("The Number that appears once is: "+arr[i]);
                return;
            }
        }

        System.out.println("No unique element is found");

        /*
        Time Complexity:
            - Finding maximum element → O(n)
            - Filling frequency hash → O(n)
            - Checking which element appears once → O(n)
            - Total = O(n) + O(n) + O(n) = O(n)

       Space Complexity:
           - Extra hash array of size (max element + 1).
           - Worst case: if max element ≈ n, then space = O(n).
           - So Space Complexity = O(max element) ≈ O(n)
        */
    }

    public static void UsingHashMap(int[] arr){
        int n = arr.length;

        //Declare the hashmap
        //Key -> array element
        //Value -> frequency count
        HashMap<Integer,Integer> mpp = new HashMap<>();

        // Hash the array
        for(int i = 0; i < n; i++){
            int values = mpp.getOrDefault(arr[i],0);
            mpp.put(arr[i],values+1);
        }

        //Find the Single element and print the Output
        for(Map.Entry<Integer, Integer> it: mpp.entrySet()){
            if(it.getValue() == 1){
                System.out.println("The Number that appears Once is: "+it.getKey());
                return;
            }
        }
        //If no element found
        System.out.println("No Unique element found!!");

        /*
        Time Complexity:
            - Building HashMap (loop once over array) → O(n)
            - Iterating over HashMap entries → O(n) in worst case
            - Total = O(n) + O(n) = O(n)

       Space Complexity:
           - HashMap stores up to 'n' keys in worst case
           - Space Complexity = O(n)
      */
    }

    public static void UsingXOR(int[] arr){
        int n = arr.length;

        //XOR all the elements
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor = xor ^ arr[i];
        }
        System.out.println("The Number that appears Once is: "+xor);

        /*
        Time Complexity:
             - Single pass through array → O(n)

        Space Complexity:
             - Uses only one variable (xor) → O(1)
       */
    }

    public static void main(String[] args){

        int[] arr1 = {2, 2, 1, 1,3};
        System.out.println("Brute Force Approach: ");
        bruteForce(arr1);
        System.out.println();

        int[] arr2 = {2, 2, 1, 1, 3};
        System.out.println("Better Approach 1: ");
        UsingHashing(arr2);
        System.out.println();

        int[] arr3 = {2, 2, 1, 1, 3};
        System.out.println("Better Approach 2: ");
        UsingHashMap(arr3);
        System.out.println();

        int[] arr4 = {2, 2, 1, 1, 3};
        System.out.println("Optimal Approach: ");
        UsingXOR(arr4);
    }
}
