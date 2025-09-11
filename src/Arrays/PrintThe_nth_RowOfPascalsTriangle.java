package Arrays;

public class PrintThe_nth_RowOfPascalsTriangle {

    // ----------------- Method 1: Using nCr -----------------
    public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Print nth row using nCr
    public static void printRow_Method1(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    /*
    Time Complexity: O(n^2) (since nCr is O(r) per call)
    Space Complexity: O(1)
    */


    // ----------------- Method 2: Iterative Calculation -----------------
    // nextValue = prevValue * (n - i) / i
    public static void printRow_Method2(int n) {
        long ans = 1;
        System.out.print(ans + " "); // first element is always 1

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */


    // ----------------- Main -----------------
    public static void main(String[] args) {
        int n = 5; // print the 5th row

        System.out.println(" Print " + n + "-th row of Pascal's Triangle");

        System.out.println("Method 1 (Using nCr):");
        printRow_Method1(n);

        System.out.println("Method 2 (Iterative Formula):");
        printRow_Method2(n);
    }
}

