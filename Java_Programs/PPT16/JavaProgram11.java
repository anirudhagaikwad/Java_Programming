package PPT16;
/**
 * Write a method that returns the nth odd element of a list. If the index of the element exceeds the list size, then return -1.
 */

import java.util.ArrayList;
import java.util.List;

public class JavaProgram11 {
    public static Integer getElement(List<Integer> list, Integer n) {
        int elementIndex = 2 * (n-1);
        return elementIndex > list.size() - 1 ? -1 : list.get(elementIndex);
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(23);
        list.add(5);
        list.add(64);
        list.add(20);
        list.add(75);
        System.out.println(getElement(list,3));
        System.out.println(getElement(list,2));
    }
}
