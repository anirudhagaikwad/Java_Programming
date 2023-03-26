package PPT4;

// Java program to demonstrate working of compare()
// method using Integer Class

import java.lang.Integer;

class JavaProgram3 {

    // driver code
    public static void main(String args[])
    {
        int a = 10;
        int b = 20;

        // as 10 less than 20,
        // Output will be a value less than zero
        System.out.println(Integer.compare(a, b));

        int x = 30;
        int y = 30;

        // as 30 equals 30,
        // Output will be zero
        System.out.println(Integer.compare(x, y));

        int w = 15;
        int z = 8;

        // as 15 is greater than 8,
        // Output will be a value greater than zero
        System.out.println(Integer.compare(w, z));
    }
}

