package PPT15;

// Java Program to demonstrate iterate  an Iterable using an Iterator

import java.io.*;
import java.util.*;

class JavaProgram14 {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();

        list.add("Solapur");
        list.add("Satara");
        list.add("Sangali");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}

