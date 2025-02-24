package examples;

import java.lang.reflect.Array;

/**
 * This class contains multiple generic algorithm problems and their solutions.
 */
public class GenericAlgorithms {

    /**
     * 🏆 PROBLEM 1: Find the Maximum of Three Elements
     * Given three values of a generic type, return the maximum.
     */
    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }

    /**
     * 🏆 PROBLEM 2: Swap Two Elements
     * Given a generic array and two indices, swap the elements at these positions.
     */
    public static <T> void swap(T[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * 🏆 PROBLEM 3: Reverse an Array
     * Given a generic array, reverse its elements.
     */
    public static <T> void reverseArray(T[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * 🏆 PROBLEM 4: Count Occurrences of an Element
     * Given a generic array and a target element, count how many times the element appears.
     */
    public static <T> int countOccurrences(T[] array, T target) {
        int count = 0;
        for (T element : array) {
            if (element.equals(target)) count++;
        }
        return count;
    }

    /**
     * 🏆 PROBLEM 5: Linear Search
     * Given a generic array and a target element, return its index. If not found, return -1.
     */
    public static <T> int linearSearch(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) return i;
        }
        return -1;
    }

    /**
     * 🏆 PROBLEM 6: Find Minimum and Maximum in an Array
     * Given a generic array of comparable elements, return both min and max values.
     */
    public static <T extends Comparable<T>> T[] findMinMax(T[] array, Class<T> clazz) {
        if (array.length == 0) return null;

        T min = array[0], max = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) min = element;
            if (element.compareTo(max) > 0) max = element;
        }

        T[] result = (T[]) Array.newInstance(clazz, 2);
        result[0] = min;
        result[1] = max;
        return result;
    }

    /**
     * 🏆 PROBLEM 7: Check if an Array is Sorted
     * Given a generic array, check if it is sorted in non-decreasing order.
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) return false;
        }
        return true;
    }

    /**
     * 🏆 PROBLEM 8: Find the Middle Element
     * Given a generic array, return the middle element.
     */
    public static <T> T findMiddle(T[] array) {
        if (array.length == 0) return null;
        return array[array.length / 2];
    }

    /**
     * 🏆 PROBLEM 9: Reverse a String (Using Generics for Characters)
     * Given a string, reverse its characters.
     */
    public static String reverseString(String str) {
        Character[] charArray = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        reverseArray(charArray);
        StringBuilder result = new StringBuilder();
        for (Character ch : charArray) {
            result.append(ch);
        }
        return result.toString();
    }

    /**
     * 🏆 PROBLEM 10: Check if Two Elements Exist in an Array
     * Given an array and two elements, check if both exist in the array.
     */
    public static <T> boolean containsBoth(T[] array, T first, T second) {
        boolean foundFirst = false, foundSecond = false;
        for (T element : array) {
            if (element.equals(first)) foundFirst = true;
            if (element.equals(second)) foundSecond = true;
            if (foundFirst && foundSecond) return true;
        }
        return false;
    }

    /**
     * 🏆 PROBLEM 11: Find Kth Smallest Element (Bubble Sort K Times)
     * Given an array and an index k, return the k-th smallest element.
     */
    public static <T extends Comparable<T>> T findKthSmallest(T[] array, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array[k - 1];
    }

    /**
     * 🏆 PROBLEM 12: Find First Non-Repeating Element
     * Given an array, find the first element that does not repeat.
     */
    public static <T> T firstNonRepeating(T[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean unique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i].equals(array[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique) return array[i];
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] numbers = {4, 1, 8, 3, 4, 7, 2, 8, 1};
        String[] words = {"apple", "banana", "cherry", "apple"};

        System.out.println("Max of (4, 7, 2): " + findMax(4, 7, 2));
        swap(numbers, 0, 2);
        System.out.println("After Swap (0,2): " + numbers[0] + ", " + numbers[2]);
        reverseArray(words);
        System.out.println("Reversed Words: " + words[0] + ", " + words[1]);
        System.out.println("Count of 'apple': " + countOccurrences(words, "apple"));
        System.out.println("Index of 7: " + linearSearch(numbers, 7));
        System.out.println("Is Sorted: " + isSorted(numbers));
        System.out.println("Middle Element: " + findMiddle(numbers));
        System.out.println("Reversed String: " + reverseString("Generics"));
        System.out.println("Contains 4 and 7: " + containsBoth(numbers, 4, 7));
        System.out.println("Kth Smallest (3rd): " + findKthSmallest(numbers, 3));
        System.out.println("First Non-Repeating: " + firstNonRepeating(numbers));
    }
}

