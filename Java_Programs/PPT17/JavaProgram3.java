package PPT17;
/*
Given a stream containing some elements, the task is to find the duplicate elements in this stream in Java.

Examples:

Input: Stream = {5, 13, 4, 21, 13, 27, 2, 59, 59, 34}
Output: [59, 13]
Explanation:
The only duplicate elements in the given stream are 59 and 13.

Input: Stream = {5, 13, 4, 21, 27, 2, 59, 34}
Output: []
Explanation:
There are no duplicate elements in the given stream, hence the output is empty.
*/

import java.util.*;
import java.util.stream.*;

public class JavaProgram3 {

    // Function to find the
    // duplicates in a Stream
    public static <T> Set<T>
    findDuplicateInStream(Stream<T> stream)
    {

        // Set to store the duplicate elements
        Set<T> items = new HashSet<>();

        // Return the set of duplicate elements
        return stream

                // Set.add() returns false
                // if the element was
                // already present in the set.
                // Hence filter such elements
                .filter(n -> !items.add(n))

                // Collect duplicate elements
                // in the set
                .collect(Collectors.toSet());
    }

    public static void main(String[] args)
    {

        // Initial stream
        Stream<Integer> stream
                = Stream.of(5, 13, 4,
                21, 13, 27,
                2, 59, 59, 34);

        // Print the found duplicate elements
        System.out.println(
                findDuplicateInStream(stream));
    }
}


