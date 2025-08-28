package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {

    /*
      Finds the union of two arrays using a HashMap.
      This method works for both sorted and unsorted arrays.

      Time Complexity: O(n + m)
      We iterate through arr1 (n elements) and arr2 (m elements) once to populate the map,
      and then once more through the map's keys. This simplifies to O(n + m).

      Space Complexity: O(n + m)
      In the worst-case scenario (all elements are unique), the HashMap will store
      n + m elements, requiring extra space proportional to the sum of the array sizes.
     */
    static ArrayList<Integer> findUnionUsingMap(int[] arr1, int[] arr2, int n, int m) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // The value doesn't matter, only the key's presence for uniqueness.
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
        }

        for (int key : freq.keySet()) {
            union.add(key);
        }
        return union;
    }

    /*
      Finds the union of two arrays using a HashSet.
      This is generally preferred over the HashMap approach as it's a more direct tool for storing unique elements.

      Time Complexity: O(n + m)
      Similar to the HashMap approach, adding n elements and then m elements to the HashSet
      takes O(n + m) time on average. Iterating the set to create the list also takes O(n+m).

      Space Complexity: O(n + m)
      In the worst case, the HashSet will store n + m unique elements.
     */
    static ArrayList<Integer> findUnionUsingSet(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> s = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            s.add(arr2[i]);
        }

        for (int it : s) {
            union.add(it);
        }
        return union;
    }

    /*
      Finds the union of two arrays using the two-pointer approach.
      PRE-REQUISITE: This method works correctly ONLY IF THE INPUT ARRAYS ARE SORTED.

      Time Complexity: O(n + m)
      The pointers 'i' and 'j' traverse both arrays at most once. This is the most time-efficient approach.

      Space Complexity: O(1)
      This approach uses constant extra space, as it does not require any auxiliary data structures
      like a map or set. The space for the 'union' list is for storing the answer, not for processing.
     */
    static ArrayList<Integer> findUnionTwoPointers(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.getLast() != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // Add remaining elements from arr1, if any
        while (i < n) {
            if (union.getLast() != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2, if any
        while (j < m) {
            if (union.getLast() != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int n = 10, m = 7;

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

        // --- Method 1: Using HashMap ---
        ArrayList<Integer> unionMap = findUnionUsingMap(arr1, arr2, n, m);
        System.out.println("Union using HashMap:");
        for (int val : unionMap) {
            System.out.print(val + " ");
        }
        System.out.println("\n");

        // --- Method 2: Using HashSet ---
        ArrayList<Integer> unionSet = findUnionUsingSet(arr1, arr2, n, m);
        System.out.println("Union using HashSet:");
        for (int val : unionSet) {
            System.out.print(val + " ");
        }
        System.out.println("\n");

        // --- Method 3: Using Two Pointers ---
        ArrayList<Integer> unionPointers = findUnionTwoPointers(arr1, arr2, n, m);
        System.out.println("Union using Two Pointers:");
        for (int val : unionPointers) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
