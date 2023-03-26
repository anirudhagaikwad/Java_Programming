package PPT18;

/*
* Java Program to Convert Binary Code into Gray Code Without Using Recursion
Example:
Binary -> 0100
Gray   -> 0110
Binary -> 0101
Gray   -> 0111
* */


import java.io.*;

// Class
class JavaProgram13 {

    // converts the given binary string into its equivalent
    // gray code
    public static void toGray(String binary)
    {
        // a String variable to store the obtained gray  string.
        // the MSB of the gray code is the same as
        // the MSB of the binary string, i.e., binary[0]
        String gray = new String();

        gray += binary.charAt(0);

        for (int i = 1; i < binary.length(); i++) {
            // perform XOR on the previous bit and the
            // current bit of the binary string
            gray += (Integer.parseInt(String.valueOf(
                    binary.charAt(i - 1)))
                    ^ Integer.parseInt(
                    String.valueOf(binary.charAt(i))));
        }

        System.out.println("The gray code of " + binary
                + " is : " + gray);
    }

    public static void main(String[] args)
    {
        // a String variable to store the given binary  string
        String binary = "0011010101";

        toGray(binary);
    }
}
