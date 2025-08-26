package Arrays;

import java.util.HashSet;

public class removeDuplicatesInPlaceFromSortedArray {

    public static int removeDuplicatesWithSet(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        int k = set.size();
        int j = 0;
        for(int x : set){
            arr[j++] = x;
        }
        return k;
    }

    public static int removeDuplicatesTwoPointers(int[] arr){
        if(arr.length == 0)
            return 0;

        int i = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        int[] arr1 = {1,1,2,2,2,3,3};
        int[] arr2 = {1,1,2,2,2,3,3};

        //Using Hashset
        int k1 = removeDuplicatesWithSet(arr1);
        System.out.println("Using HahSet: ");
        for(int i = 0; i < k1; i++){
            System.out.println(arr1[i] + " ");
        }
        System.out.println();

        //Using Two Pointers
        int k2 = removeDuplicatesTwoPointers(arr2);
        System.out.println("Using Two Pointer(sorted array): ");
        for(int i = 0; i < k2; i++){
            System.out.println(arr2[i] + " ");
        }
    }
}
