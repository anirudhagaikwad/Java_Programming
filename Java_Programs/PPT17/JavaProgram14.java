package PPT17;

/* Java code to demonstrate Collectors  toCollection(Supplier collectionFactory) method
 */

import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class JavaProgram14 {

    public static void main(String[] args)
    {

        // Creating a string stream
        Stream<String> s = Stream.of("2.5", "6", "4");

        // Using Collectors toCollection()
        Collection<String> names = s
                .collect(Collectors
                        .toCollection(TreeSet::new));

        // Printing the elements
        System.out.println(names);
    }
}
