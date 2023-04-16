package PPT16;
/*
* Write a method that converts all strings in a list to their upper case.
* */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaProgram10 {

    public static List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("java");
        list.add("python");
        list.add("ruby");
        list.add("angular");
        System.out.println(upperCase(list));
    }
}
