package PPT16;

import java.util.ArrayList;
import java.util.List;

/*
Write a method that returns the average of a list of integers.
*/
public class JavaProgram9 {

    public static Double average(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();

    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(23);
        list.add(5);
        list.add(64);
        list.add(20);
        list.add(75);
        System.out.println(average(list));
    }
}

