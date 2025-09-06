package Arrays;

import java.util.*;

public class BoyerMooreMajorityVoteProblem {

    // ------------------- 1. Brute Force Approach -------------------
    // Time Complexity: O(n^2), Space: O(1)
    public static int majorityElementBrute(int[] v) {
        int n = v.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (v[j] == v[i]) cnt++;
            }
            if (cnt > n / 2) return v[i];
        }
        return -1;
    }

    // ------------------- 2. HashMap Approach -------------------
    // Time Complexity: O(n), Space: O(n)
    public static int majorityElementHashMap(int[] v) {
        int n = v.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.put(v[i], freq.getOrDefault(v[i], 0) + 1);
            if (freq.get(v[i]) > n / 2) {
                return v[i];
            }
        }
        return -1;
    }

    // ------------------- 3. Boyer–Moore Voting Algorithm -------------------
    // Time Complexity: O(n), Space: O(1)
    public static int majorityElementBoyerMoore(int[] arr) {
        int n = arr.length;
        int count = 0;
        int element = -1; // will hold majority element

        // Step 1: Find potential element
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];   // pick current element
                count = 1;
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify element
        int freq = 0;
        for (int num : arr) {
            if (num == element) freq++;
        }

        if (freq > n / 2) return element;
        return -1;
    }

    // ------------------- Main Function -------------------
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Brute Force Result: " + majorityElementBrute(arr));
        System.out.println("HashMap Result: " + majorityElementHashMap(arr));
        System.out.println("Boyer–Moore Result: " + majorityElementBoyerMoore(arr));
    }
}
