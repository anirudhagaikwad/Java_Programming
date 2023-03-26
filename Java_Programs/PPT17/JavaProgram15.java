package PPT17;


// Java code to show the use of limit() function of stream
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

class JavaProgram15{

    // Function to limit the stream upto given range, i.e, 3
    public static Stream<String> limiting_func(Stream<String> ss, int range){
        return ss.limit(range);
    }

    // Driver code
    public static void main(String[] args){

        // list to save stream of strings
        List<String> arr = new ArrayList<>();

        arr.add("english");
        arr.add("science");
        arr.add("maths");
        arr.add("IT");
        arr.add("Hindi");

        Stream<String> str = arr.stream();

        // calling function to limit the stream to range 3
        Stream<String> lm = limiting_func(str,3);
        lm.forEach(System.out::println);
    }
}


