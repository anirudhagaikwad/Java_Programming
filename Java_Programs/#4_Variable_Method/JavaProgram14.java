package PPT4;

// Java Program to take input by using BufferedReader Class

// Importing required class
import java.io.*;

class JavaProgram14 {

    public static void main(String args[])
            throws IOException
    {

        // Creating object of class inside main() method
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter an integer");

        // Taking integer input
        int a = Integer.parseInt(br.readLine());

        System.out.println("Enter a String");

        String b = br.readLine();

        // Printing input entities above
        System.out.printf("You have entered:- " + a
                + " and name as " + b);
    }
}
