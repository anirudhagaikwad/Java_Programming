package PPT6;

import java.util.Scanner;

/*
Write a Java program to find the length of the longest sequence of zeros
in binary representation of an integer.

Input a Decimal Number : 7
Binary number is: 111
Length of the longest sequence: 0
* */
public class JavaProgram15 {
    public static void main(String[] args) {

        int dec_num, rem, quot, i = 1, j;
        int bin_num[] = new int[100];
        Scanner scan = new Scanner(System.in);

        System.out.print("Input a Decimal Number : ");
        dec_num = scan.nextInt();

        quot = dec_num;

        while (quot != 0) {
            bin_num[i++] = quot % 2;
            quot = quot / 2;
        }
        String binary_str = "";
        System.out.print("Binary number is: ");
        for (j = i - 1; j > 0; j--) {
            binary_str = binary_str + bin_num[j];
        }
        System.out.print(binary_str);
        i = binary_str.length() - 1;
        while (binary_str.charAt(i) == '0') {
            i--;
        }
        int length = 0;
        int ctr = 0;
        for (; i >= 0; i--) {
            if (binary_str.charAt(i) == '1') {
                length = Math.max(length, ctr);
                ctr = 0;
            } else {
                ctr++;
            }
        }
        length = Math.max(length, ctr);
        System.out.println("\nLength of the longest sequence: " + length);
    }
}
