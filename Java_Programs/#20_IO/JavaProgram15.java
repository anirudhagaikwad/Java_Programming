package PPT20;

// Java Program to Append a String to the End of a File

// Importing input output classes
import java.io.*;

class JavaProgram15 {

    // Method 1
    // TO append string into a file
    public static void appendStrToFile(String fileName,
                                       String str)
    {
        // Try block to check for exceptions
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));

            // Writing on output stream
            out.write(str);
            // Closing the connection
            out.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
    }

    // Method 2
    // main driver method
    public static void main(String[] args) throws Exception
    {
        // Creating a sample file with some random text
        String fileName = "demo.txt";

        // Try block to check for exceptions
        try {

            // Again operating same operations by passing
            // file as
            // parameter to read it
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName));

            // Writing on. file
            out.write("Hello World:\n");

            // Closing file connections
            out.close();
        }

        // Catch block to handle exceptions
        catch (IOException e) {

            // Display message when error occurs
            System.out.println("Exception Occurred" + e);
        }

        // Now appendinggiven str to above
        // created file
        String str = "This is java";

        // Calling the above method
        appendStrToFile(fileName, str);

        // Let us print modified file
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("Geek.txt"));

            String mystring;

            // TIll there is content in string
            // condition holds true
            while ((mystring = in.readLine()) != null) {
                System.out.println(mystring);
            }
        }

        // Catch block to handle IO exceptions
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }
}
