package fundamentals;
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

import java.util.Scanner;

public class P7_Arrays {
    // Method demonstrating array declaration, initialization, and access
    void arrayDemo1() {
        int[] arrayInt = new int[10]; // Array initialization - allocate memory

        // Initializing elements
        arrayInt[0] = 101;
        arrayInt[1] = 102;
        arrayInt[2] = 103;
        arrayInt[3] = 104;
        arrayInt[4] = 105;
        arrayInt[5] = 106;
        arrayInt[6] = 107;
        arrayInt[7] = 108;
        arrayInt[8] = 109;
        arrayInt[9] = 110;

        System.out.println("Access element arrayInt[7]: " + arrayInt[7]); // Index 7 value i.e. 108

        arrayInt[9] = 115; // Updating array element
        System.out.println("Updated element arrayInt[9]: " + arrayInt[9]);
    }

    // Method demonstrating array creation and iteration
    void arrayDemo2() {
        int[] arrayInt = {101, 102, 103, 104, 105, 106}; // Array initialization with values

        System.out.println("Access element arrayInt[4]: " + arrayInt[4]);

        arrayInt[4] = 110; // Updating array element
        System.out.println("Updated element arrayInt[4]: " + arrayInt[4]);

        System.out.println("Array Length: " + arrayInt.length); // Checking array length

        System.out.println("Array Elements: " + Arrays.toString(arrayInt)); // Printing array elements

        // Iterating with a traditional for-loop
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Array Element at index " + i + " = " + arrayInt[i]);
        }

        // Iterating using for-each loop with a manual index counter
        int index = 0;
        for (int num : arrayInt) {
            System.out.println("For-each loop -> Index: " + index + ", Value: " + num);
            index++;
        }
    }

    public static void main(String[] args) {
    	P7_Arrays obj = new P7_Arrays();
        obj.arrayDemo1();
        obj.arrayDemo2();
        obj.multiDimensionalArray();

        Scanner ob = new Scanner(System.in);
        int[] arr = new int[5];

        // User input for array values
        System.out.println("Enter 5 numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ob.nextInt();
        }

        obj.arrayDemo(arr);

        // Calculating sum using the new method
        int[] sumResult = obj.calculateSum(arr);
        System.out.println("Updated Array after calculations: " + Arrays.toString(sumResult));

        ob.close();
    }

  
    void multiDimensionalArray() {
        String[][] names = {{"Mr.", "Mrs.", "Ms."}, {"Danish", "Shukla", "Patil"}};

        System.out.println(names[0][0] + names[1][0]); // Mr.Danish
        System.out.println(names[0][2] + names[1][1]); // Ms.Shukla
        System.out.println(names[0][1] + names[1][2]); // Mrs.Patil

        // Updating element
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

    // Method to update array by calculating sum and difference of first two elements
    int[] calculateSum(int[] arr) {
        if (arr.length < 3) return arr; // Ensuring valid array length
        arr[1] = arr[0] + arr[1]; // Updating second element as sum of first two
        arr[2] = arr[0] - arr[1]; // Updating third element as difference
        return arr;
    }

}

