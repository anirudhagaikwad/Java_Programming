package PPT17;

/* Java program to demonstrate the continuous scanning
 by BufferedReader.lines() method and return the stream
 of lines that contains the specific word
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class JavaProgram16 {
    public static void main(String[] args)
    {
        FileReader f= null;
        try {
            f = new FileReader("JavaProgram16.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader b = new BufferedReader(f);

        // taking the stream as a string
        Stream<String> i = b.lines();

        i.filter(line -> line.contains("Hello")).findAny().ifPresent(System.out::println);

        // filter the stream that line contains Hello is reset output
        try {
            b.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
