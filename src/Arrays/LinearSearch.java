package Arrays;

public class LinearSearch {

    /*
      Time Complexity: O(N)
      In the worst-case scenario, we have to iterate through all 'N' elements of the
      array to find the target (if the target is the last element or not present at all).
      Therefore, the time taken is directly proportional to the number of elements.

      Space Complexity: O(1)
      The algorithm uses a constant amount of extra memory. It only requires a few
      variables (like the loop counter 'i') regardless of the size of the input array.
      The space requirement does not grow as the array size increases.
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {22, 1, 45, 13, 8, 30, 99, 4};
        int targetElement = 30;

        int resultIndex = linearSearch(numbers, targetElement);

        if (resultIndex != -1) {
            System.out.println("Element " + targetElement + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + targetElement + " not found in the array.");
        }
    }
}