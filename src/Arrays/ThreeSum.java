package Arrays;

import java.util.*;

public class ThreeSum {

    // ----------------- Method 1: Brute Force -----------------
    public static List<List<Integer>> threeSum_BruteForce(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(st);
    }
    /*
    Time Complexity: O(n^3)
    Space Complexity: O(n) (for HashSet)
    */


    // ----------------- Method 2: HashSet for 2nd element -----------------
    public static List<List<Integer>> threeSum_HashSet(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        return new ArrayList<>(st);
    }
    /*
    Time Complexity: O(n^2)
    Space Complexity: O(n)
    */


    // ----------------- Method 3: Two-Pointer Optimal -----------------
    public static List<List<Integer>> threeSum_TwoPointer(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue; // skip duplicates

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }
    /*
    Time Complexity: O(n^2)
    Space Complexity: O(1) (excluding result list)
    */


    // ----------------- Main -----------------
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        System.out.println("Original array: " + Arrays.toString(arr));

        System.out.println("\nMethod 1: Brute Force");
        System.out.println(threeSum_BruteForce(arr));

        System.out.println("\nMethod 2: HashSet for 2nd element");
        System.out.println(threeSum_HashSet(arr));

        System.out.println("\nMethod 3: Two-Pointer Optimal");
        System.out.println(threeSum_TwoPointer(arr));
    }
}

