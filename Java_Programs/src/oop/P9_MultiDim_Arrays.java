package oop;
/*
## 1. What is a Multidimensional Array?  
A multidimensional array in Java is an array of arrays. 
It allows storing data in a tabular (row-column) format or even higher dimensions.  

### Key Points:  
- Two-dimensional (2D) arrays store data in a matrix format (rows and columns).  
- Three-dimensional (3D) arrays extend the concept further.  
- Each dimension is represented as an array of arrays.  
- Elements are accessed using multiple indices (e.g., `arr[row][col]` for 2D arrays).  

---

## Declaring Multidimensional Arrays  

### Declaration and Initialization  
A multidimensional array is declared using multiple square brackets `[ ]`.  

dataType[][] arrayName; // 2D Array declaration
dataType[][][] arrayName; // 3D Array declaration


### Memory Allocation (Instantiation)  
Once declared, memory needs to be allocated before usage.  

arrayName = new dataType[rows][columns]; // 2D Array
arrayName = new dataType[depth][rows][columns]; // 3D Array

---

## Types of Multidimensional Arrays  

### 1. Two-Dimensional (2D) Array
- Stores data in rows and columns like a matrix.
- Each row is an array containing elements.  

dataType[][] arrayName = new dataType[rows][columns];


### 2. Three-Dimensional (3D) Array
- Extends the concept of 2D arrays by adding a depth level.  
- Can be visualized as a stack of 2D arrays.  

dataType[][][] arrayName = new dataType[depth][rows][columns];


---

### 3. Jagged Arrays in Java  
A jagged array is an array of arrays where each sub-array can have different sizes.  

int[][] jaggedArray = new int[3][];
jaggedArray[0] = new int[2]; // First row has 2 elements
jaggedArray[1] = new int[4]; // Second row has 4 elements
jaggedArray[2] = new int[3]; // Third row has 3 elements
```
- Useful when each row has different data sizes.

---



## 6. Summary  

| Type           | Structure                  | Example Usage                             |
|----------------|----------------------------|-------------------------------------------|
| 2D Array       | Table (rows & columns)     | Matrices, Grids, Chess Board              |
| 3D Array       | Stack of 2D arrays         | Image Processing, 3D Game Data            |
| Jagged Array   | Variable-length sub-arrays | Storing student marks, Irregular datasets |

---

*/
public class P9_MultiDim_Arrays {

	    // Method 1: Demonstrate operations on a 2D array
	    public static void workWith2DArray() {
	        System.out.println("===== 2D Array Operations =====");
	        
	        // Step 1: Declare and Initialize
	        int[][] matrix = { 
	            {1, 2, 3}, 
	            {4, 5, 6}, 
	            {7, 8, 9} 
	        };

	        // Step 2: Assign a new value
	        matrix[1][2] = 99; // Updating value at row 1, column 2

	        // Step 3: Get dimensions
	        System.out.println("Number of rows: " + matrix.length);
	        System.out.println("Number of columns in row 0: " + matrix[0].length);

	        // Step 4: Iterate and Print index-value
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[i].length; j++) {
	                System.out.println("Index [" + i + "][" + j + "] = " + matrix[i][j]);
	            }
	        }
	    }

	    // Method 2: Demonstrate operations on a 3D array
	    public static void workWith3DArray() {
	        System.out.println("\n===== 3D Array Operations =====");

	        // Step 1: Declare and Initialize
	        int[][][] cube = new int[2][2][2]; // 2x2x2 3D array

	        // Step 2: Assign values
	        int value = 1;
	        for (int i = 0; i < cube.length; i++) {
	            for (int j = 0; j < cube[i].length; j++) {
	                for (int k = 0; k < cube[i][j].length; k++) {
	                    cube[i][j][k] = value++;
	                }
	            }
	        }

	        // Step 3: Update a value
	        cube[1][1][1] = 100;

	        // Step 4: Get dimensions
	        System.out.println("Depth: " + cube.length);
	        System.out.println("Rows in depth 0: " + cube[0].length);
	        System.out.println("Columns in row 0, depth 0: " + cube[0][0].length);

	        // Step 5: Iterate and Print index-value
	        for (int i = 0; i < cube.length; i++) {
	            for (int j = 0; j < cube[i].length; j++) {
	                for (int k = 0; k < cube[i][j].length; k++) {
	                    System.out.println("Index [" + i + "][" + j + "][" + k + "] = " + cube[i][j][k]);
	                }
	            }
	        }
	    }

	    // Method 3: Demonstrate operations on a Jagged array
	    public static void workWithJaggedArray() {
	        System.out.println("\n===== Jagged Array Operations =====");

	        // Step 1: Declare a jagged array
	        int[][] jaggedArray = new int[3][]; 

	        // Step 2: Initialize each row with different lengths
	        jaggedArray[0] = new int[2]; // 2 columns in row 0
	        jaggedArray[1] = new int[4]; // 4 columns in row 1
	        jaggedArray[2] = new int[3]; // 3 columns in row 2

	        // Step 3: Assign values dynamically
	        int value = 1;
	        for (int i = 0; i < jaggedArray.length; i++) {
	            for (int j = 0; j < jaggedArray[i].length; j++) {
	                jaggedArray[i][j] = value++;
	            }
	        }

	        // Step 4: Update a value
	        jaggedArray[1][2] = 999;

	        // Step 5: Get lengths of rows
	        System.out.println("Number of rows: " + jaggedArray.length);
	        for (int i = 0; i < jaggedArray.length; i++) {
	            System.out.println("Number of columns in row " + i + ": " + jaggedArray[i].length);
	        }

	        // Step 6: Iterate and Print index-value
	        for (int i = 0; i < jaggedArray.length; i++) {
	            for (int j = 0; j < jaggedArray[i].length; j++) {
	                System.out.println("Index [" + i + "][" + j + "] = " + jaggedArray[i][j]);
	            }
	        }
	    }

	    // Main method to call all operations
	    public static void main(String[] args) {
	        workWith2DArray();
	        workWith3DArray();
	        workWithJaggedArray();
	    }
	}

