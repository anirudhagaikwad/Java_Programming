package PPT3;
/*
Given a number x and two positions (from the right side) in the binary representation of x, write a function that swaps n bits at the given two positions and returns the result.
It is also given that the two sets of bits do not overlap.

Example:
Input:
x = 47 (00101111)
p1 = 1 (Start from the second bit from the right side)
p2 = 5 (Start from the 6th bit from the right side)
n = 3 (No of bits to be swapped)

Output:
227 (11100011)
The 3 bits starting from the second bit (from the right side) are
swapped with 3 bits starting from 6th position (from the right side)
* */
class JavaProgram15 {

    static int swapBits(int x, int p1, int p2, int n)
    {
        // Move all bits of first set
        // to rightmost side
        int set1 = (x >> p1) & ((1 << n) - 1);

        // Move all bits of second set
        // to rightmost side
        int set2 = (x >> p2) & ((1 << n) - 1);

        // XOR the two sets
        int xor = (set1 ^ set2);

        // Put the xor bits back to
        // their original positions
        xor = (xor << p1) | (xor << p2);

        // XOR the 'xor' with the original number
        // so that the two sets are swapped
        int result = x ^ xor;

        return result;
    }

    public static void main(String[] args)
    {
        int res = swapBits(28, 0, 3, 2);
        System.out.println("Result = " + res);
    }
}


