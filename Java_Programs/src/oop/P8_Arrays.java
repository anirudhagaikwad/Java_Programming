package oop;
/*
### What is an Array?
An array in Java is a data structure that allows you to store multiple values of the same 
type in a contiguous memory location. 
It is a fixed-size, indexed collection of elements where each element can be accessed using an 
index.

### Characteristics of Arrays:
1. Fixed Size: Once an array is created, its size cannot be changed.
2. Homogeneous Elements: All elements in an array must be of the same data type.
3. Index-Based Access: Elements can be accessed using an index, starting from `0`.
4. Stored in Contiguous Memory: Helps in fast access and manipulation.
5. Efficient Processing: Provides better performance due to sequential memory allocation.

### Summary:

- Arrays are useful when dealing with multiple elements of the same type.
- They provide fast access using an index but have a fixed size.
- Methods can be used to process arrays efficiently, as demonstrated in the program.

 
*/
import java.util.Arrays;

public class P8_Arrays {
 
	    // Method 1: Demonstrate array initialization and assignment
	    public static void initializeAndAssign() {
	        System.out.println("===== Array Initialization and Assignment =====");

	        // 1. Static Initialization (Direct Values)
	        int[] staticArray = {10, 20, 30, 40, 50};

	        // 2. Dynamic Initialization (Size Only)
	        int[] dynamicArray = new int[5]; // Default values (0)
	        
	        // Assigning values to dynamic array
	        for (int i = 0; i < dynamicArray.length; i++) {
	            dynamicArray[i] = (i + 1) * 5; // Assigning multiples of 5
	        }

	        System.out.println("Static Array: " + Arrays.toString(staticArray));
	        System.out.println("Dynamic Array (After Assignment): " + Arrays.toString(dynamicArray));
	    }

	    // Method 2: Update an array element
	    public static void updateArrayElement(int[] arr, int index, int newValue) {
	        System.out.println("\n===== Updating Array Element =====");
	        
	        if (index < 0 || index >= arr.length) {
	            System.out.println("Invalid index: " + index);
	            return;
	        }

	        System.out.println("Before Update: " + Arrays.toString(arr));
	        arr[index] = newValue; // Update element
	        System.out.println("After Update at index " + index + ": " + Arrays.toString(arr));
	    }

	    // Method 3: Print array length and iterate using different loops
	    public static void printArrayInfo(int[] arr) {
	        System.out.println("\n===== Array Length and Iteration =====");
	        System.out.println("Array Length: " + arr.length);

	        // Using for loop
	        System.out.print("Using for loop: ");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();

	        // Using enhanced for loop
	        System.out.print("Using enhanced for loop: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();

	        // Using while loop
	        System.out.print("Using while loop: ");
	        int i = 0;
	        while (i < arr.length) {
	            System.out.print(arr[i] + " ");
	            i++;
	        }
	        System.out.println();
	    }

	    // Method 4: Print indices and values of an array
	    public static void printArrayWithIndices(int[] arr) {
	        System.out.println("\n===== Printing Array with Indices =====");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.println("Index " + i + " -> Value: " + arr[i]);
	        }
	    }

	    // Method 5: Demonstrating Multi-Dimensional Array (2D Array)
	    public static void multiDimensionalArray() {
	        System.out.println("\n===== Multi-Dimensional Array Demonstration =====");

	        String[][] names = {
	            {"Mr.", "Mrs.", "Ms."},
	            {"Danish", "Shukla", "Patil"}
	        };

	        System.out.println(names[0][0] + names[1][0]); // Mr.Danish
	        System.out.println(names[0][2] + names[1][1]); // Ms.Shukla
	        System.out.println(names[0][1] + names[1][2]); // Mrs.Patil

	        // Updating an element
	        names[1][0] = "Anirudha";
	        System.out.println(names[0][0] + names[1][0]); // Mr.Anirudha

	        // Printing all elements using nested for-loops
	        for (int i = 0; i < names.length; i++) { // Iterate over rows
	            for (int j = 0; j < names[i].length; j++) { // Iterate over columns
	                System.out.println("names[" + i + "][" + j + "] = " + names[i][j]);
	            }
	            System.out.println(); // New line for readability
	        }
	    }

	    // Method 6: Updating an array based on sum and difference of first two elements
	    public static int[] calculateSum(int[] arr) {
	        System.out.println("\n===== Calculate Sum and Difference in Array =====");
	        
	        if (arr.length < 3) {
	            System.out.println("Array size must be at least 3 for calculations.");
	            return arr;
	        }

	        System.out.println("Original Array: " + Arrays.toString(arr));

	        arr[1] = arr[0] + arr[1]; // Updating second element as sum of first two
	        arr[2] = arr[0] - arr[1]; // Updating third element as difference

	        System.out.println("Updated Array: " + Arrays.toString(arr));
	        return arr;
	    }

	    // Main Method to Execute All Operations
	    public static void main(String[] args) {
	        initializeAndAssign(); // Demonstrating initialization and assignment

	        int[] sampleArray = {1, 2, 3, 4, 5}; // Example array
	        updateArrayElement(sampleArray, 2, 99); // Updating index 2

	        printArrayInfo(sampleArray); // Demonstrating array length and iteration
	        printArrayWithIndices(sampleArray); // Printing indices with values

	        multiDimensionalArray(); // Demonstrating 2D Array usage

	        int[] sumArray = {5, 10, 15}; // Example array for sum and difference method
	        calculateSum(sumArray); // Perform sum and difference update
	    }
	}

    



