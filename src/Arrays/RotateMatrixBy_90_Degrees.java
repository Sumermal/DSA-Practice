package Arrays;

public class RotateMatrixBy_90_Degrees {

    //   Approach 1: Using Extra Space
    // Create a new rotated matrix and copy values accordingly
    static int[][] rotateWithExtraSpace(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        // Rule: rotated[j][n - i - 1] = matrix[i][j]
        // This places each element at its new rotated position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }

        return rotated;
    }

    //  Approach 2: In-place Rotation
    // Step 1: Transpose the matrix (swap across diagonal)
    // Step 2: Reverse each row
    static void rotateInPlace(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Utility function to print matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // -------- Approach 1 --------
        System.out.println(" Approach 1: Rotate using Extra Space");
        int[][] rotated = rotateWithExtraSpace(arr1);
        printMatrix(rotated);

        // -------- Approach 2 --------
        System.out.println("\n Approach 2: Rotate In-place (Transpose + Reverse)");
        rotateInPlace(arr2);
        printMatrix(arr2);
    }
}

/*
--------------------------------------------------------
📌 COMPLEXITY ANALYSIS
--------------------------------------------------------

 Approach 1: Using Extra Space
   - Time Complexity: O(n^2)  → we visit each element once
   - Space Complexity: O(n^2) → extra matrix of same size

 Approach 2: In-place (Transpose + Reverse)
   - Time Complexity: O(n^2) → transpose + row reversal
   - Space Complexity: O(1)  → only temp variable, no extra matrix

*/
