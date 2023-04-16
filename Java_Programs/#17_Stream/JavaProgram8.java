package PPT17;
/*
Given a Stream of Lists in Java, the task is to Flatten the Stream using forEach() method.

Examples:

Input: lists = [ [1, 2], [3, 4, 5, 6], [8, 9] ]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

Input: lists = [ ['G', 'e', 'e', 'k', 's'], ['F', 'o', 'r'] ]
Output: [G, e, e, k, s, F, o, r]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

class JavaProgram8 {

    // Function to flatten a Stream of Lists
    public static <T> Stream<T> flattenStream(List<List<T> > lists)
    {

        // Create an empty list to collect the stream
        List<T> finalList = new ArrayList<>();

        // Using forEach loop
        // convert the list into stream
        // and add the stream into list
        for (List<T> list : lists) {
            list.stream()
                    .forEach(finalList::add);
        }

        // Convert the list into Stream and return it
        return finalList.stream();
    }

    public static void main(String[] args)
    {

        // Get the lists to be flattened.
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(3, 4, 5, 6);
        List<Integer> c = Arrays.asList(7, 8, 9);

        List<List<Integer> > arr = new ArrayList<List<Integer> >();
        arr.add(a);
        arr.add(b);
        arr.add(c);

        // Flatten the Stream
        List<Integer> flatList = new ArrayList<Integer>();
        flatList = flattenStream(arr)
                .collect(Collectors.toList());

        // Print the flattened list
        System.out.println(flatList);
    }
}
