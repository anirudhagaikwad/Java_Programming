package examples;

import java.util.Arrays;

public class SingleDimensionalArrayOperations {

    // Method 1: Find the second largest and second smallest numbers in an array
    public static void findSecondLargestAndSmallest(int[] arr) {
        System.out.println("===== Second Largest & Second Smallest =====");

        if (arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        // Sort the array to find second largest and smallest
        Arrays.sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Second Smallest: " + arr[1]);
        System.out.println("Second Largest: " + arr[arr.length - 2]);
    }

    // Method 2: Check if an array is a palindrome
    public static void checkPalindrome(int[] arr) {
        System.out.println("\n===== Palindrome Check =====");

        int left = 0, right = arr.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println(isPalindrome ? "The array is a palindrome." : "The array is NOT a palindrome.");
    }

    // Method 3: Rotate an array to the left or right
    public static void rotateArray(int[] arr, int positions, boolean left) {
        System.out.println("\n===== Array Rotation (" + (left ? "Left" : "Right") + ") =====");
        
        int n = arr.length;
        positions %= n; // Handle cases where positions > n
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = left ? (i - positions + n) % n : (i + positions) % n;
            rotated[newIndex] = arr[i];
        }

        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Rotated: " + Arrays.toString(rotated));
    }

    // Method 4: Find missing numbers in a consecutive sequence
    public static void findMissingNumbers(int[] arr) {
        System.out.println("\n===== Missing Numbers =====");

        Arrays.sort(arr); // Sorting helps find missing numbers
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr[i] + 1; j < arr[i + 1]; j++) {
                System.out.println("Missing number: " + j);
            }
        }
    }

    // Method 5: Check if an array follows an arithmetic or geometric progression
    public static void checkProgression(int[] arr) {
        System.out.println("\n===== Progression Check =====");

        if (arr.length < 3) {
            System.out.println("Array must have at least three elements.");
            return;
        }

        boolean isArithmetic = true, isGeometric = true;
        int diff = arr[1] - arr[0];
        double ratio = (double) arr[1] / arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) isArithmetic = false;
            if ((double) arr[i + 1] / arr[i] != ratio) isGeometric = false;
        }

        System.out.println("Array: " + Arrays.toString(arr));
        if (isArithmetic) {
            System.out.println("The array follows an **Arithmetic Progression (AP)** with difference " + diff);
        } else if (isGeometric) {
            System.out.println("The array follows a **Geometric Progression (GP)** with ratio " + ratio);
        } else {
            System.out.println("The array does NOT follow an arithmetic or geometric progression.");
        }
    }

    // Main method to call all operations
    public static void main(String[] args) {
        int[] array1 = {10, 5, 3, 8, 15, 2};
        findSecondLargestAndSmallest(array1);

        int[] array2 = {1, 2, 3, 2, 1};
        checkPalindrome(array2);

        int[] array3 = {1, 2, 3, 4, 5};
        rotateArray(array3, 2, true); // Left rotation
        rotateArray(array3, 2, false); // Right rotation

        int[] array4 = {1, 3, 4, 7, 8, 10};
        findMissingNumbers(array4);

        int[] array5 = {2, 4, 6, 8, 10};
        int[] array6 = {3, 9, 27, 81};
        int[] array7 = {5, 12, 19, 27}; // No AP or GP

        checkProgression(array5);
        checkProgression(array6);
        checkProgression(array7);
    }
}

