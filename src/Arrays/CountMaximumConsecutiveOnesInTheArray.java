package Arrays;

public class CountMaximumConsecutiveOnesInTheArray {

    public static int findMaxConsecutiveOnes(int[] arr, int n){
        int cnt = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                cnt++;                  // increase count if element is 1
            } else {
                cnt = 0;                // reset count if element is 0
            }
            max = Math.max(max,cnt);    // update maximum
        }
        return max;                     // return the maximum consecutive 1's

        /*
         Time Complexity: O(n)
            - We traverse the array once (for loop runs n times).
            - Each operation inside loop is constant time.
         Space Complexity: O(1)
            - Only a few integer variables (cnt, max, ans).
            - No extra data structures used
         */
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 0, 1, 1, 1};
        int n = arr.length;

        int ans = findMaxConsecutiveOnes(arr,n);
        System.out.println("Maximum Consecutive 1's are "+ans);

    }
}
