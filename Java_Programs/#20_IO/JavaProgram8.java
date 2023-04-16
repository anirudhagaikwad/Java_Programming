package PPT20;
// Java Program to Write into a File using FileWriterClass

import java.io.FileWriter;
import java.io.IOException;

public class JavaProgram8 {

    public static void main(String[] args)
    {

        // Content to be assigned to a file
        // Custom input just for illustration purposes
        String text
                = "Computer Science Portal";

        // Try block to check if exception occurs
        try {

            // Create a FileWriter object
            // to write in the file
            FileWriter fWriter = new FileWriter(
                    "/Users/abc/Desktop/demo.docx");

            // Writing into file
            // Note: The content taken above inside the
            // string
            fWriter.write(text);

            // Printing the contents of a file
            System.out.println(text);

            // Closing the file writing connection
            fWriter.close();

            // Display message for successful execution of
            // program on the console
            System.out.println(
                    "File is created successfully with the content.");
        }

        // Catch block to handle if exception occurs
        catch (IOException e) {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }
}


