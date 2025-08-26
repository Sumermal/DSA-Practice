package Arrays;

public class CheckIfAnArrayIsSorted {

    public static boolean bruteForce(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean optimal(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }
}
