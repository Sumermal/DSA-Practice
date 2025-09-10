package Arrays;

public class SetMatrixZero {

    // -------------------------------------------------------------
    // 🔹 Approach 1: Brute Force (Mark with -1, then replace with 0)
    // Time Complexity: O((n*m) * (n+m)) ≈ O(n^2 * m + n * m^2)
    // Space Complexity: O(1)
    // -------------------------------------------------------------
    static void markRow(int[][] matrix, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void markCol(int[][] matrix, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void zeroMatrixBrute(int[][] matrix, int n, int m) {
        // Step 1: mark rows and cols where 0 is present
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, m, i);
                    markCol(matrix, n, j);
                }
            }
        }

        // Step 2: replace -1 with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // -------------------------------------------------------------
    // 🔹 Approach 2: Better (Using row[] and col[] arrays)
    // Time Complexity: O(n*m)
    // Space Complexity: O(n+m)
    // -------------------------------------------------------------
    static void zeroMatrixBetter(int[][] matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Step 1: Traverse the matrix and mark row/col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Set matrix[i][j] = 0 if row[i] or col[j] is marked
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // -------------------------------------------------------------
    // 🔹 Approach 3: Optimal (Using matrix itself as markers)
    // Time Complexity: O(n*m)
    // Space Complexity: O(1)
    // -------------------------------------------------------------
    static void zeroMatrixOptimal(int[][] matrix, int n, int m) {
        int col0 = 1;

        // Step 1: Traverse and mark 1st row/col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark i-th row:
                    matrix[i][0] = 0;

                    // mark j-th column:
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Mark from (1,1) to (n-1,m-1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Handle first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // -------------------------------------------------------------
    // Utility function to print a matrix
    // -------------------------------------------------------------
    static void printMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------------
    // Main Function
    // -------------------------------------------------------------
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int n = matrix1.length;
        int m = matrix1[0].length;

        // Approach 1: Brute Force
        System.out.println("Brute Force Approach:");
        zeroMatrixBrute(matrix1, n, m);
        printMatrix(matrix1, n, m);

        // Approach 2: Better
        System.out.println("\nBetter Approach (row[] + col[]):");
        zeroMatrixBetter(matrix2, n, m);
        printMatrix(matrix2, n, m);

        // Approach 3: Optimal
        System.out.println("\nOptimal Approach (O(1) space):");
        zeroMatrixOptimal(matrix3, n, m);
        printMatrix(matrix3, n, m);
    }
}

