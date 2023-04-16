package PPT20;

// Comparing path of two files in Java

import java.io.File;

public class JavaProgram12 {

    public static void main(String[] args)
    {

        File file1 = new File("/home/mayur/GFG.java");
        File file2 = new File("/home/mayur/file.txt");
        File file3 = new File("/home/mayur/GFG.java");

        // Path comparison
        if (file1.compareTo(file2) == 0) {
            System.out.println(
                    "paths of file1 and file2 are same");
        }
        else {
            System.out.println(
                    "Paths of file1 and file2 are not same");
        }

        // Path comparison
        if (file1.compareTo(file3) == 0) {
            System.out.println(
                    "paths of file1 and file3 are same");
        }
        else {
            System.out.println(
                    "Paths of file1 and file3 are not same");
        }
    }
}
