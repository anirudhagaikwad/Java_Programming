package arrays;

import java.util.Arrays;

/*
Sorting is a fundamental operation in computer science that involves arranging the elements of an array in a particular order. In Java, there are several built-in methods that can be used to sort arrays. In this answer, we will discuss the most commonly used sorting algorithms and their implementation in Java.
*/
public class SortingArray {
/*
Bubble Sort
Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.
*/
	public static void bubbleSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n-1; i++) {
	        for (int j = 0; j < n-i-1; j++) {
	            if (arr[j] > arr[j+1]) {
	                int temp = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1] = temp;
	            }
	        }
	    }
	}

/*
Selection Sort
Selection sort is another simple sorting algorithm that works by selecting the smallest element from the unsorted part of the array and placing it at the beginning of the sorted part of the array.	
*/
	public static void selectionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n-1; i++) {
	        int min_idx = i;
	        for (int j = i+1; j < n; j++) {
	            if (arr[j] < arr[min_idx]) {
	                min_idx = j;
	            }
	        }
	        int temp = arr[min_idx];
	        arr[min_idx] = arr[i];
	        arr[i] = temp;
	    }
	}

/*
Insertion Sort
Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.	
*/
	public static void insertionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 1; i < n; i++) {
	        int key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && arr[j] > key) {
	            arr[j+1] = arr[j];
	            j--;
	        }
	        arr[j+1] = key;
	    }
	}

/*
Quick Sort
Quick sort is a divide and conquer algorithm that works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. 	
*/
	public static void quickSort(int[] arr, int low, int high) {
	    if (low < high) {
	        int pivot_index = partition(arr, low, high);
	        quickSort(arr, low, pivot_index - 1);
	        quickSort(arr, pivot_index + 1, high);
	    }
	}

	public static int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    int temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp;
	    return i+1;
	}

/*
Merge sort is another popular sorting algorithm that works by dividing the unsorted array into n sub-arrays, each containing one element, and then repeatedly merging sub-arrays to produce new sorted sub-arrays until there is only one sub-array remaining.	
*/
	public static void mergeSort(int[] arr, int l, int r) {
	    if (l < r) {
	        int m = (l+r)/2;
	        mergeSort(arr, l, m);
	        mergeSort(arr, m+1, r);
	        merge(arr, l, m, r);
	    }
	}

	public static void merge(int[] arr, int l, int m, int r) {
	    int n1 = m - l + 1;
	    int n2 = r - m;
	    int[] L = new int[n1];
	    int[] R = new int[n2];
	    for (int i = 0; i < n1; i++) {
	        L[i] = arr[l+i];
	    }
	    for (int j = 0; j < n2; j++) {
	        R[j] = arr[m+1+j];
	    }
	    int i = 0, j = 0;
	    int k = l;
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i];
	            i++;
	        } else {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}

	public static void main(String[] args) {
	    int[] arr = {5, 2, 7, 3, 9, 4, 1, 8, 6};
	    System.out.println("Original array: " + Arrays.toString(arr));
	    
	    // Bubble sort
	    bubbleSort(arr);
	    System.out.println("Sorted array using bubble sort: " + Arrays.toString(arr));
	    
	    // Selection sort
	    int[] arr2 = {5, 2, 7, 3, 9, 4, 1, 8, 6}; // create a new array since the previous one is already sorted
	    selectionSort(arr2);
	    System.out.println("Sorted array using selection sort: " + Arrays.toString(arr2));
	    
	    // Insertion sort
	    int[] arr3 = {5, 2, 7, 3, 9, 4, 1, 8, 6}; // create a new array since the previous one is already sorted
	    insertionSort(arr3);
	    System.out.println("Sorted array using insertion sort: " + Arrays.toString(arr3));
	    
	    // Merge sort
	    int[] arr4 = {5, 2, 7, 3, 9, 4, 1, 8, 6}; // create a new array since the previous one is already sorted
	    mergeSort(arr4, 0, arr4.length-1);
	    System.out.println("Sorted array using merge sort: " + Arrays.toString(arr4));
	}


}//end class
