package Arrays;

import java.util.*;

public class PrintTheFirst_n_RowsOfPascalsTriangle {

    // ----------------- Method 1: Using nCr -----------------
    public static int nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    // Generate Pascal's Triangle using nCr
    public static List<List<Integer>> pascalTriangle_Method1(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                tempRow.add(nCr(row - 1, col - 1));
            }
            ans.add(tempRow);
        }
        return ans;
    }

    /*
    Time Complexity: O(n^3) approx (n rows × n columns × nCr computation)
    Space Complexity: O(1) extra (excluding result)
    */


    // ----------------- Method 2: Iterative Row Generation -----------------
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1); // first element always 1

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            rowList.add((int) ans);
        }
        return rowList;
    }

    public static List<List<Integer>> pascalTriangle_Method2(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    /*
    Time Complexity: O(n^2) (better than Method 1)
    Space Complexity: O(1) extra (excluding result)
    */


    // ----------------- Utility function to print -----------------
    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }


    // ----------------- Main -----------------
    public static void main(String[] args) {
        int n = 5; // number of rows

        System.out.println(" Print first " + n + " rows of Pascal's Triangle");

        System.out.println("\nMethod 1 (Using nCr):");
        List<List<Integer>> ans1 = pascalTriangle_Method1(n);
        printTriangle(ans1);

        System.out.println("\nMethod 2 (Iterative Row Generation):");
        List<List<Integer>> ans2 = pascalTriangle_Method2(n);
        printTriangle(ans2);
    }
}
