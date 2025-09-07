package Arrays;

public class RearrangeArrayBySign {

    // ✅ Approach 1: Equal Positives and Negatives
    // Puts positives at even indices and negatives at odd indices
    // Time Complexity: O(n)  (traverse array + rearrange)
    // Space Complexity: O(n) (extra pos[] and neg[] arrays)
    public static int[] rearrangeEqualCount(int[] A) {
        int n = A.length;
        int[] pos = new int[n], neg = new int[n];
        int posCount = 0, negCount = 0;

        // Split positives and negatives
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) pos[posCount++] = A[i];
            else neg[negCount++] = A[i];
        }

        // Fill alternating indices
        for (int i = 0; i < n / 2; i++) {
            A[2 * i] = pos[i];
            A[2 * i + 1] = neg[i];
        }
        return A;
    }

    // ✅ Approach 2: Handles Extra Positives or Negatives
    // If positives < negatives or vice versa, places the remaining at the end
    // Time Complexity: O(n)  (segregation + filling result array)
    // Space Complexity: O(n) (extra pos[], neg[], and ans[] arrays)
    public static int[] rearrangeExtraPosNeg(int[] A) {
        int n = A.length;
        int[] pos = new int[n], neg = new int[n];
        int posCount = 0, negCount = 0;

        // Split positives and negatives
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) pos[posCount++] = A[i];
            else neg[negCount++] = A[i];
        }

        int[] ans = new int[n];

        // Case 1: More negatives
        if (posCount < negCount) {
            for (int i = 0; i < posCount; i++) {
                ans[2 * i] = pos[i];
                ans[2 * i + 1] = neg[i];
            }
            int index = posCount * 2;
            for (int i = posCount; i < negCount; i++) ans[index++] = neg[i];
        }
        // Case 2: More positives or equal
        else {
            for (int i = 0; i < negCount; i++) {
                ans[2 * i] = pos[i];
                ans[2 * i + 1] = neg[i];
            }
            int index = negCount * 2;
            for (int i = negCount; i < posCount; i++) ans[index++] = pos[i];
        }
        return ans;
    }

    // ✅ Approach 3: Direct Index Placement
    // Places positives at even indices and negatives at odd indices in one pass
    // Time Complexity: O(n)  (single traversal)
    // Space Complexity: O(n) (extra ans[] array only)
    public static int[] rearrangeDirect(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;

        // Direct placement
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                ans[negIndex] = A[i];
                negIndex += 2;
            } else {
                ans[posIndex] = A[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    // Helper method to print arrays
    public static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -4, -5, 3, 4};
        int[] arr2 = {1, 2, -4, -5};

        System.out.println("Approach 1 (Equal Count Assumed):");
        printArray(rearrangeEqualCount(arr2));

        System.out.println("Approach 2 (Handles Extra Positives/Negatives):");
        printArray(rearrangeExtraPosNeg(arr1));

        System.out.println("Approach 3 (Direct Even/Odd Placement):");
        printArray(rearrangeDirect(arr2));
    }
}