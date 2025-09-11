package Arrays;

import java.util.*;

public class ExtendedBoyerMooreMajorityVoteProblem {

    // ----------------- Method 1: Brute Force -----------------
    // Check frequency of each element manually
    public static List<Integer> majorityElement_BruteForce(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (res.size() == 0 || res.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) count++;
                }
                if (count > n / 3) res.add(nums[i]);
            }
            if (res.size() == 2) break; // max 2 elements can be > n/3
        }

        return res;
    }
    /*
    Time Complexity: O(n^2)
    Space Complexity: O(1) (excluding result list)
    */


    // ----------------- Method 2: Using HashMap -----------------
    public static List<Integer> majorityElement_HashMap(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshold = n / 3 + 1;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == threshold) {
                res.add(num);
            }
            if (res.size() == 2) break; // max 2 elements
        }

        return res;
    }
    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */


    // ----------------- Method 3: Extended Boyer-Moore Voting Algorithm -----------------
    public static List<Integer> majorityElement_BoyerMoore(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // First pass: find potential candidates
        for (int num : nums) {
            if (count1 == 0 && el2 != num) {
                el1 = num;
                count1 = 1;
            } else if (count2 == 0 && el1 != num) {
                el2 = num;
                count2 = 1;
            } else if (num == el1) count1++;
            else if (num == el2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify actual counts
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == el1) count1++;
            if (num == el2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        int threshold = n / 3 + 1;
        if (count1 >= threshold) res.add(el1);
        if (count2 >= threshold) res.add(el2);

        return res;
    }
    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */


    // ----------------- Main -----------------
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        System.out.println("Original array: " + Arrays.toString(arr));

        System.out.println("\nMethod 1: Brute Force");
        System.out.println(majorityElement_BruteForce(arr));

        System.out.println("\nMethod 2: Using HashMap");
        System.out.println(majorityElement_HashMap(arr));

        System.out.println("\nMethod 3: Extended Boyer-Moore Voting");
        System.out.println(majorityElement_BoyerMoore(arr));
    }
}
