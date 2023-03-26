package PPT17;
/*
Given a Parallel Stream in Java, the task is to reverse its elements.

Examples:

Input: Parallel Stream = {11, 22, 33, 44}
Output: {44, 33, 22, 11}

Input: Parallel Stream = {a, b, c, d}
Output: {d, c, b, a}
*/

import java.util.*;
import java.util.stream.*;

class JavaProgram5 {

    // Generic function to reverse
    // the elements of the parallel stream
    public static <T> Collector<T, ?, Stream<T> > reverseStream()
    {
        return Collectors
                .collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        });
    }

    public static void main(String[] args)
    {

        // Get the parallel stream
        List<Integer> lists = Arrays.asList(11, 22, 33, 44);
        Stream<Integer> stream = lists.parallelStream();

        // Reverse and print the elements
        stream.collect(reverseStream())
                .forEach(System.out::println);
    }
}

