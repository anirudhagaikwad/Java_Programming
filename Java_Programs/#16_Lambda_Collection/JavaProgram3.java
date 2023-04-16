package PPT16;


// Converting ArrayList to HashMap  in Java 8 using a Lambda Expression
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

// here we are making a class , and we will make
class JavaProgram3 {

    // key will act as an id of the value
    private Integer key;

    // value will be the value of the above key
    private String value;

    // create constructor for reference
    public JavaProgram3(Integer id, String name)
    {

        // assigning the value of key and value
        this.key = id;
        this.value = name;
    }

    // return private variable key
    public Integer getkey() { return key; }

    // return private variable name
    public String getvalue() { return value; }
}
class Main {
    public static void main(String[] args)
    {
        // Write your code here

        // Creating a List of type ListItems using ArrayList
        List<JavaProgram3> list = new ArrayList<JavaProgram3>();

        // add the member of list
        list.add(new JavaProgram3(1, "I"));
        list.add(new JavaProgram3(2, "Love"));
        list.add(new JavaProgram3(3, "INDIA"));
        list.add(new JavaProgram3(4, "AND"));
        list.add(new JavaProgram3(5, "INDIANS"));

        // Map which will store the list items
        Map<Integer, String> map = new HashMap<>();

        // for (ListItems n : list) { map.put(n.getkey(),
        // n.getvalue()); }
        // the below lambda performs the same task as the
        // above given for loop will do
        // put the list items in the Map
        list.forEach(
                (n) -> { map.put(n.getkey(), n.getvalue()); });

        // Printing the given map
        System.out.println("Map : " + map);
    }
}
