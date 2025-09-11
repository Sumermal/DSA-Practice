package Arrays;

import java.util.*;

public class SpiralTraversalOfMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(); // ArrayList to store result

        int n = matrix.length;       // number of rows
        int m = matrix[0].length;    // number of columns

        // Boundaries
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are added
        while (top <= bottom && left <= right) {

            // 1. Traverse from left → right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // move top boundary down

            // 2. Traverse from top → bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // move right boundary left

            // 3. Traverse from right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // move bottom boundary up
            }

            // 4. Traverse from bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // move left boundary right
            }
        }

        return ans; // return result list
    }

    // 🔹 Main method inside the same class
    public static void main(String[] args) {
        SpiralTraversalOfMatrix sol = new SpiralTraversalOfMatrix();

        // Test matrix
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Call spiralOrder
        List<Integer> ans = sol.spiralOrder(mat);

        // Print result
        System.out.println("Spiral Traversal:");
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

/*
--------------------------------------------------------
    📌 COMPLEXITY
--------------------------------------------------------
    Time Complexity  : O(n*m) → visit each element once
    Space Complexity : O(1) → ignoring the output list
--------------------------------------------------------
*/


