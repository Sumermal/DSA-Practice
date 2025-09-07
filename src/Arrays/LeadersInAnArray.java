package Arrays;

public class LeadersInAnArray {

    // ---------------------------------------------------
    // Brute Force Approach
    // ---------------------------------------------------
    // Idea:
    // For each element arr[i], check if it is greater than
    // all elements to its right. If yes, it's a leader.
    // ---------------------------------------------------
    // Time Complexity: O(n^2)
    //   (for each element, we may scan all to its right)
    // Space Complexity: O(n)
    //   (to store leaders in a temporary array)
    public static int[] printLeadersBruteForce(int[] arr, int n) {
        int[] temp = new int[n]; // temporary array to store leaders
        int count = 0; // to keep track of number of leaders

        for (int i = 0; i < n; i++) {
            boolean leader = true;

            // Check whether arr[i] is greater than all elements to its right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false; // found a bigger element, so not a leader
                    break;
                }
            }

            // If arr[i] is a leader, add it to temp
            if (leader) {
                temp[count++] = arr[i];
            }
        }

        // Copy leaders from temp[] to a new array of exact size
        int[] leaders = new int[count];
        for (int i = 0; i < count; i++) {
            leaders[i] = temp[i];
        }

        return leaders;
    }

    // ---------------------------------------------------
    // Optimal Approach
    // ---------------------------------------------------
    // Idea:
    // Leaders appear from right to left.
    // Keep track of the maximum element so far while scanning
    // from right. If arr[i] is greater than "max", it's a leader.
    // ---------------------------------------------------
    // Time Complexity: O(n)
    //   (single traversal from right to left)
    // Space Complexity: O(n)
    //   (to store leaders, though better than O(n^2))
    public static int[] printLeadersOptimal(int[] arr, int n) {
        int[] temp = new int[n]; // temporary array to store leaders
        int count = 0;

        // Last element is always a leader
        int max = arr[n - 1];
        temp[count++] = max;

        // Traverse array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                temp[count++] = arr[i];
                max = arr[i]; // update max for future comparisons
            }
        }

        // Leaders were stored in reverse order,
        // so reverse them into a new array
        int[] leaders = new int[count];
        for (int i = 0; i < count; i++) {
            leaders[i] = temp[count - i - 1];
        }

        return leaders;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {10, 22, 12, 3, 0, 6};

        // Run Brute Force
        System.out.print("Brute Force Leaders: ");
        int[] brute = printLeadersBruteForce(arr, n);
        for (int i = 0; i < brute.length; i++) {
            System.out.print(brute[i] + " ");
        }
        System.out.println();

        // Run Optimal
        System.out.print("Optimal Leaders: ");
        int[] optimal = printLeadersOptimal(arr, n);
        for (int i = 0; i < optimal.length; i++) {
            System.out.print(optimal[i] + " ");
        }
    }
}
