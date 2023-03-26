package PPT17;
/* Java Program to convert Map<Key, Value> into Stream */

import java.util.*;
import java.util.stream.*;

class JavaProgram9s {

    // Generic function to convert List of
    // String to List of Integer
    public static <K, V> Stream<Map.Entry<K, V> >
    convertMapToStream(Map<K, V> map)
    {

        // Return the obtained Stream
        return map

                // Convert the Map to Set
                .entrySet()

                // Convert the Set to Stream
                .stream();
    }

    public static void main(String args[])
    {

        // Create a Map
        Map<Integer, String> map = new HashMap<>();

        // Add entries to the Map
        map.put(1, "java");
        map.put(2, "cpp");
        map.put(3, "python");

        // Print the Map
        System.out.println("Map: " + map);

        // Convert the Map to Stream
        Stream<Map.Entry<Integer, String> > stream =
                convertMapToStream(map);

        // Print the TreeMap
        System.out.println("Stream: "
                + Arrays.toString(stream.toArray()));
    }
}


