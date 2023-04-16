package PPT11;

// Java Program to Use Method Overloading for Printing Different Types of Array

class JavaProgram8 {

    // creating a method for printing integer
    // array with integer parameter
    public static void printArray(Integer[] arr)
    {
        System.out.println("\nThe Integer array is: ");

        // for loop for printing the elements of array
        for (Integer i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // overloading the above created method with different
    // parameter method contains a character parameter
    public static void printArray(Character[] arr)
    {
        System.out.println("\nThe Character array is: ");

        // for loop for printing the elements of array
        for (Character i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // now the parameter for the overloaded method is String
    public static void printArray(String[] arr)
    {
        System.out.println("\nThe String array is: ");

        // for loop for printing the elements of array
        for (String i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // now the parameter for the overloaded method is double
    public static void printArray(Double[] arr)
    {
        System.out.println("\nThe Double array is: ");

        // for loop for printing the elements of array
        for (Double i : arr)
            System.out.print(i + " ");
    }

    // main function
    public static void main(String args[])
    {

        // calling the parameters of all the
        // methods and taking the inputs
        Integer[] iarr = { 2, 4, 6, 6, 8 };
        Character[] carr = { 'H', 'E', 'L', 'L', 'O' };
        String[] sarr
                = { "Ram", "Nidhi", "John", "Raju", "Sara" };
        Double[] darr
                = { 10.0123, 89.123, 65.132, 78.321, 1.798 };

        // calling the methods and printing the arrays
        printArray(iarr);
        printArray(carr);
        printArray(sarr);
        printArray(darr);
    }
}
