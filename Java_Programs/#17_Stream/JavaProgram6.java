package PPT17;
/*
Given a Stream, the task is to convert this Stream into ArrayList in Java 8.

Examples:

Input: Stream: [1, 2, 3, 4, 5]
Output: ArrayList: [1, 2, 3, 4, 5]

Input: Stream: ['G', 'e', 'e', 'k', 's']
Output: ArrayList: ['G', 'e', 'e', 'k', 's']
*/

import java.util.*;
import java.util.stream.*;

public class JavaProgram6 {

    // Function to get ArrayList from Stream
    public static <T> ArrayList<T>
    getArrayListFromStream(Stream<T> stream)
    {

        // Convert the Stream to List
        List<T>
                list = stream.collect(Collectors.toList());

        // Create an ArrayList of the List
        ArrayList<T>
                arrayList = new ArrayList<T>(list);

        // Return the ArrayList
        return arrayList;
    }


    public static void main(String args[])
    {

        Stream<Integer>
                stream = Stream.of(1, 2, 3, 4, 5);

        // Convert Stream to ArrayList in Java
        ArrayList<Integer>
                arrayList = getArrayListFromStream(stream);

        // Print the arraylist
        System.out.println("ArrayList: " + arrayList);
    }
}


