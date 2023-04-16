package PPT4;

// Java program to Illustrate Calling of a Non-Static Method

// Class 1
// Helper class
class Help {

    // Non-static method
    public int sum(int a, int b)
    {
        // Returning sum of numbers
        return a + b;
    }
}

// Class 2
// Main class
class JavaProgram2 {

    public static void main(String[] args)
    {
        // Input integers to be summed up
        int n = 3, m = 6;

        // Creating object of above class
        Help g = new Help();

        // Calling above method to compute sum
        int s = g.sum(n, m);

        // Calling the non-static method
        System.out.print("sum is = " + s);
    }
}
