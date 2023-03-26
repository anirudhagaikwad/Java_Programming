package PPT17;
/*
JAVA program to get Slice of a Stream in Java
Examples:

Input: [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
Output: [15, 16, 17, 18, 19]
Explanation: The output contains a slice of the stream from index 4 to 8.

Input: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Output: [2, 3, 4]
Explanation: The output contains a slice of the stream from index 1 to 3.
*/

import java.util.*;
import java.util.stream.Stream;

class JavaProgram11 {

    // Generic function to get Slice of a  Stream from startIndex to endIndex
    public static <T> Stream<T>
    getSliceOfStream(Stream<T> stream, int startIndex,
                     int endIndex)
    {
        return stream
                // specify the number of elements to skip
                .skip(startIndex)

                // specify the no. of elements the stream
                // that should be limited
                .limit(endIndex - startIndex + 1);
    }
    public static void main(String[] args)
    {

        // Create a new List with values 11 - 20
        List<Integer> list = new ArrayList<>();
        for (int i = 11; i <= 20; i++)
            list.add(i);

        // Create stream from list
        Stream<Integer> intStream = list.stream();

        // Print the stream
        System.out.println("List: " + list);

        // Get Slice of Stream
        // containing of elements from the 4th index to 8th
        Stream<Integer>
                sliceOfIntStream = getSliceOfStream(intStream, 4, 8);

        // Print the slice
        System.out.println("\nSlice of Stream:");
        sliceOfIntStream.forEach(System.out::println);
    }
}


