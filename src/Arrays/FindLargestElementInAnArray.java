package Arrays;

import java.util.Arrays;

public class FindLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 0};
        Arrays.sort(arr1);  // Sort array
        System.out.println("The largest element in arr1 is: " + arr1[arr1.length - 1]);

        int[] arr2 = {8, 10, 5, 7, 9};
        Arrays.sort(arr2);  // Sort array
        System.out.println("The largest element in arr2 is: " + arr2[arr2.length - 1]);
    }
}

