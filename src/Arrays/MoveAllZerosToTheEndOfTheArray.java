package Arrays;

import java.util.ArrayList;

public class MoveAllZerosToTheEndOfTheArray {

    public static void  bruteForce(int[] arr, int n){

        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i  < n; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }
        int tempSize = temp.size();

        for(int i = 0; i < tempSize; i++){
            arr[i] = temp.get(i);
        }

        for(int i = tempSize; i < n; i++){
            arr[i] = 0;
        }

        //Array Print
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] +" ");
        }

        /*
          Time Complexity: O(N)
          The code iterates through the array three times in the worst case (once to populate the list,
          once to copy non-zero elements back, and once to fill zeros). This simplifies to O(N) + O(N) = O(2N),
          which is O(N) because constants are dropped.

          Space Complexity: O(N)
          In the worst case (an array with no zeros), the 'temp' ArrayList will store all N elements,
          requiring extra space proportional to the input array size.
         */

    }

    public static void optimal(int[] arr, int n){
        int j = -1;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1){
            return;
        }

        for(int i = j+1; i <n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        // Array Print
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+ " ");
        }

        /*
          Time Complexity: O(N)
          This is a single-pass solution. The pointers 'i' and 'j' will collectively
          traverse the array only once.

          Space Complexity: O(1)
          No extra space is used; the array is modified in-place.
         */

    }

    public static void main(String[] args){

        // Test the bruteForce method
        int[] arr1 = {0, 1, 0, 3, 12};
        System.out.print("Brute Force Output: ");
        bruteForce(arr1, arr1.length);
        System.out.println();

        // Test the optimal method with a fresh array
        int[] arr2 = {0, 1, 0, 3, 12};
        System.out.print("Optimal Output:    ");
        optimal(arr2, arr2.length);
        System.out.println();
    }
}
