package Arrays;

public class FindTheElementAtRow_r_AndColumn_c_InPascalsTriangle {

    // Function to calculate nCr (binomial coefficient)
    // Formula: nCr = n! / (r! * (n-r)!)
    public static long nCr(int n, int r) {
        long res = 1;

        // Loop runs r times → O(r)
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Function to get element at row r, col c in Pascal's Triangle
    // Element at (r, c) = (r-1)C(c-1)
    public static int pascalTriangle(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    public static void main(String[] args) {
        int r = 5; // row number (1-indexed)
        int c = 3; // column number (1-indexed)

        int element = pascalTriangle(r, c);

        System.out.println("The element at position (" + r + "," + c + ") is: " + element);
    }
}

/*
Time Complexity: O(r)
Space Complexity: O(1)
*/
