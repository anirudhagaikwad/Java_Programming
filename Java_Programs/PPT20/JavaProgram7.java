package PPT20;
/*
Java Program to Read and Print All Files From a Zip File

Input  : D:/progs.zip
Output : The files in the Zip are as follows:
         Java program to print a number.java
         Java program to print your name.java
         Java program to calculate.java
         Java program to print a pattern.java
*/

// Importing input output classes
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// Importing zip classes and Scanner class
// from java.util package
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Class to Read and print the Zip Files
public class JavaProgram7 {

    // Function to read and print the file names.
    public void printFileContent(String filePath)
    {

        // Creating objects for the classes and
        // initializing them to null
        FileInputStream fs = null;
        ZipInputStream Zs = null;
        ZipEntry ze = null;

        // Try block to handle if exception occurs
        try {

            // Display message when program compiles
            // successfully
            System.out.println(
                    "Files in the zip are as follows: ");

            fs = new FileInputStream(filePath);
            Zs = new ZipInputStream(
                    new BufferedInputStream(fs));

            // Loop to read and print the zip file name till
            // the end
            while ((ze = Zs.getNextEntry()) != null) {
                System.out.println(ze.getName());
            }

            // Closing the file connection
            Zs.close();
        }

        // Catch block to handle if any exception related
        // to file handling occurs
        catch (FileNotFoundException fe) {

            // Print the line line and exception
            // of the program where it occurred
            fe.printStackTrace();
        }

        // Catch block to handle generic exceptions
        catch (IOException ie) {

            // Print the line line and exception
            // of the program where it occurred
            ie.printStackTrace();
        }
    }

    public static void main(String[] args)
    {

        // Creating an object of the file
        JavaProgram7 zf = new JavaProgram7();

        // Taking input of the zip file from local directory
        // Name of the zip file to be read should be entered
        Scanner sc = new Scanner(System.in);

        // Display message asking user to enter
        // zip file local directory
        System.out.println(
                "Enter the location of the zip file: ");
        String str = sc.nextLine();

        // Print the zip files(compressed files)
        zf.printFileContent(str);
    }
}

