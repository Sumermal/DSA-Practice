package Arrays;

public class FindTheMissingNumberInAnArray {

    public static void bruteForce(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int flag = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] == i){
                    flag= 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.println("Missing Number is "+i);
            }
        }

        /*
        Time Complexity:
            O(n²) → because for every number we search the entire array.

        Space Complexity:
            O(1) → because only a few variables are used.
        */
    }

    public static void UsingHashing(int[] arr){
        int n = arr.length;

        int[] hash = new int[n+1]; // hash array

        // storing the frequencies
        for(int i = 0; i < n-1; i++){
            hash[arr[i]]++;
        }

        //checking frequencies from 1 to n and if if any hash frequency is zero then return it.
        for(int i = 0; i < n; i++){
            if(hash[i] == 0){
                System.out.println("Missing Number is "+i);
            }
        }

        /*
           Time Complexity:
                O(n) → because we make two passes over the array and hash
           Space Complexity:
                O(n) → because we use an extra hash array of size n+1
        */
    }

    public static void UsingSum(int[] arr){
        int n = arr.length;

        int s1 = (n * (n + 1)) / 2; // s1 is sum of n natural number
        int s2 = 0;

        for(int i = 0; i < n; i++){        // s2 is sum of array elements
            s2 += arr[i];
        }

        int missingNumber = s1 - s2;

        System.out.println("Missing Number is "+missingNumber);

       /* Time Complexity:
              O(n) → because we traverse the array once to compute its sum
         Space Complexity:
              O(1) → because only a fixed number of variables are used
       */
    }

    public static void UsingXOR(int[] arr){
        int n= arr.length;

        //declare two variables
        int xor1 = 0, xor2 = 0;

        for(int i = 0; i < n; i++){
            xor2 = xor2 ^ arr[i]; // XOR array element
            xor1 = xor1 ^ (i+1);// XOR all numbers from 0 to n
        }

        // Missing number is XOR of both variables
        int missingNumber = xor1 ^ xor2;
        System.out.println("Missing Number is "+missingNumber);

        /*Time Complexity:
            O(n) → because we traverse the array once.
          Space Complexity:
            O(1) → because we use only a fixed number of variables.
        */
    }

    public static void main(String[] args){

        int[] arr1 = {0,1,3,4};
        System.out.println("Brute Force Approach: ");
        bruteForce(arr1);

        int[] arr2 = {0,1,3,4};
        System.out.println("Better Approach (Using Hashing):");
        UsingHashing(arr2);

        int[] arr3 = {0,1,3,4};
        System.out.println("Optimal Approach (Using Sum):");
        UsingSum(arr3);

        int[] arr4 = {0,1,3,4};
        System.out.println("Optimal Approach(Using XOR):");
        UsingXOR(arr4);


    }
}
