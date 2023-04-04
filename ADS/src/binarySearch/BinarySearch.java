package binarySearch;
/*
Binary search is a searching algorithm used to find a specific element in a sorted array or list. It works by repeatedly dividing the search interval in half until the target element is found or the search interval is empty.

The key steps in the binary search algorithm are as follows:

Find the middle element of the array.
If the middle element is equal to the target element, return its index.
If the target element is less than the middle element, search in the left half of the array.
If the target element is greater than the middle element, search in the right half of the array.
Repeat the above steps until the target element is found or the search interval is empty. 
*/
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // target element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 5;
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}

/*
In the above implementation, we first initialize low and high variables to the first and last indices of the array, respectively. We then use a while loop to repeatedly divide the search interval in half until the target element is found or the search interval is empty.

Inside the loop, we calculate the middle index using (low + high) / 2 and check if the middle element is equal to the target element. If it is, we return the index of the middle element.

If the target element is less than the middle element, we update the high variable to mid - 1, which means we need to search in the left half of the array. If the target element is greater than the middle element, we update the low variable to mid + 1, which means we need to search in the right half of the array.

If the target element is not found after the loop exits, we return -1 to indicate that the target element is not present in the array.
*/
