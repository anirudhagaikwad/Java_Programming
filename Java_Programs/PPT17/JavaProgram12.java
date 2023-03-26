package PPT17;
/*
Write a JAVA program to Create Sequential Stream from an Iterator in Java
*/

import java.util.*;
import java.util.stream.*;

class JavaProgram12 {
    // Function to create a sequential Stream
    // from an Iterator
    public static <T> Stream<T>
    iteratorToSequentialStream(Iterator<T> itr)
    {
        // convert the iterator into a Spliterator
        Spliterator<T> spitr = Spliterators.spliteratorUnknownSize(
                itr, Spliterator.NONNULL);

        // Convert spliterator into a sequential stream
        // The second parameter "false" passess whether
        // the stream is to be created parallel or not
        return StreamSupport.stream(spitr, false);
    }

    public static void main(String[] args)
    {
        Iterator<String> iterator = Arrays.asList("G", "E", "E",
                "K", "S").iterator();

        Stream<String> stream = iteratorToSequentialStream(iterator);

        System.out.println("Sequential Stream : " +
                stream.collect(Collectors.toList()));
    }
}


