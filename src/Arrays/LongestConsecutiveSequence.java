package Arrays;

import java.util.*;

public class LongestConsecutiveSequence {

    // -----------------------------------------------------------
    // Approach 1: Brute Force (Linear Search for each element)
    // -----------------------------------------------------------
    // Time Complexity: O(N^2) because for each element we may search
    // the entire array linearly.
    // Space Complexity: O(1) (no extra data structure used).
    public static int longestSuccessiveElementsBrute(int[] a) {
        int n = a.length;
        if (n == 0) return 0;

        int longest = 1;
        // Pick every element and check its consecutive sequence
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int cnt = 1;

            // Search for next consecutive elements using linear search
            while (linearSearch(a, x + 1)) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    // Helper function for brute force
    private static boolean linearSearch(int[] a, int num) {
        for (int value : a) {
            if (value == num) return true;
        }
        return false;
    }

    // -----------------------------------------------------------
    // Approach 2: Sorting
    // -----------------------------------------------------------
    // Time Complexity: O(N log N) due to sorting.
    // Space Complexity: O(1) if we sort in place.
    public static int longestSuccessiveElementsSorting(int[] a) {
        int n = a.length;
        if (n == 0) return 0;

        Arrays.sort(a);  // Sort the array
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0, longest = 1;

        // Traverse and count consecutive numbers
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                cnt += 1;           // continues the sequence
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                cnt = 1;            // restart sequence
                lastSmaller = a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    // -----------------------------------------------------------
    // Approach 3: Using HashSet (Optimal)
    // -----------------------------------------------------------
    // Time Complexity: O(N) on average because set operations are O(1).
    // Space Complexity: O(N) for storing array elements in a set.
    public static int longestSuccessiveElementsHashSet(int[] a) {
        int n = a.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // Put all elements into the set
        for (int num : a) {
            set.add(num);
        }

        // Check sequences starting from each number
        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int x = num;

                while (set.contains(x + 1)) {
                    x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    // -----------------------------------------------------------
    // Main method to test all approaches
    // -----------------------------------------------------------
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};

        System.out.println("Brute Force O(N^2): " + longestSuccessiveElementsBrute(a));
        System.out.println("Sorting O(N log N): " + longestSuccessiveElementsSorting(a));
        System.out.println("HashSet O(N): " + longestSuccessiveElementsHashSet(a));
    }
}
