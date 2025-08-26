package Arrays;

import java.util.Arrays;

public class FindSecondSmallestAndSecondLargestElementInAnArray {

    public static void bruteForce(int[] arr){
        int n = arr.length;

        if(n == 0 || n == 1){
            System.out.println(-1);
            System.out.println(" ");
            System.out.println(-1);
            System.out.println("\n");
        }
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n-2];
        System.out.println("BRUTE FORCE - Second Smallest is "+small);
        System.out.println("BRUTE FORCE - Second Largest is "+large);
    }

    public static void better(int[] arr){
        int n = arr.length;

        if(n==0 || n==1){
            System.out.println(-1);
            System.out.println(" ");
            System.out.println(-1);
            System.out.println("\n");
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            small = Math.min(small,arr[i]);
            large = Math.max(large,arr[i]);
        }

        for(int i=0; i<n; i++){
            if(arr[i] < second_small && arr[i] != small){
                second_small = arr[i];
            }
            if(arr[i] > second_large && arr[i] != large){
                second_large = arr[i];
            }
        }
        System.out.println("BETTER SOLUTION - Second Smallest is "+second_small);
        System.out.println("BETTER SOLUTION - Second Largest is "+second_large);
    }

    public static void optimal(int[] arr){
        int n = arr.length;

        if(n<2){
            System.out.println("Array is too Small.");
            return;
        }

        int small = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int num = arr[i];

            if(num < small){
                secondSmall = small;
                small = num;
            } else if (num < secondSmall && num != small) {
                secondSmall = num;
            }

            if(num > large){
                secondLarge = large;
                large = num;
            } else if (num > secondLarge && num != large) {
                secondLarge = num;
            }
        }

        System.out.println("OPTIMAL SOLUTION - Second smallest Element is "+secondSmall);
        System.out.println("OPTIMAL SOLUTION - Second largest Element is "+secondLarge);
    }

    public static void main(String[] args){
        int[] arr = {12,23,4,1,65,22};

        bruteForce(arr);
        better(arr);
        optimal(arr);
    }
}
