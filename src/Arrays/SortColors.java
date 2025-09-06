package Arrays;

import java.util.*;

public class SortColors {

    // ---------------------- Solution 1: Counting Approach ----------------------
    public static void sortArrayCounting(ArrayList<Integer> arr, int n) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // Step 1: Count occurrences of 0, 1, and 2
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) cnt0++;
            else if (arr.get(i) == 1) cnt1++;
            else cnt2++;
        }

        // Step 2: Overwrite the array
        for (int i = 0; i < cnt0; i++) arr.set(i, 0); // fill 0's
        for (int i = cnt0; i < cnt0 + cnt1; i++) arr.set(i, 1); // fill 1's
        for (int i = cnt0 + cnt1; i < n; i++) arr.set(i, 2); // fill 2's
    }

    // ---------------------- Solution 2: Dutch National Flag ----------------------
    public static void sortArrayDNF(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n - 1;

        // Process until mid crosses high
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // Swap arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid++;
            } else {
                // Swap arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;

        // Original array
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 2, 1, 2, 0, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(arr1); // clone for second method

        // Apply Counting Approach
        sortArrayCounting(arr1, n);
        System.out.println("After sorting (Counting Approach):");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1.get(i) + " ");
        }
        System.out.println("\nTime: O(n), Space: O(1)");

        // Apply Dutch National Flag Approach
        sortArrayDNF(arr2, n);
        System.out.println("\nAfter sorting (Dutch National Flag):");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2.get(i) + " ");
        }
        System.out.println("\nTime: O(n), Space: O(1)");
    }
}
