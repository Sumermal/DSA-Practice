package Arrays;

public class LeftRotateTheArrayByOne {

    public static void bruteForce(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        for(int i = 1; i < n; i++){
            temp[i-1] = arr[i];
        }
        temp[n-1] = arr[0];

        for(int i = 0; i < n; i++){
            System.out.print(temp[i]+" ");
        }

        /*-----------------------------------------------
        Time Complexity: O(n)
          (two loops, each runs n times max)
         Space Complexity: O(n)
            (because of temp[] array of size n is used)
        ------------------------------------------------*/
    }

    public static void optimal(int[] arr){
        int n = arr.length;

        int temp = arr[0];

        for(int i = 0; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;

        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }

        /*
            Time Complexity: O(n)
                (one loop shifts elements, one loop prints them)
            Space Complexity: O(1)
                (no extra array is used, only one temp variable)
         */
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        bruteForce(arr);
        System.out.println(" ");
        optimal(arr);
    }
}
