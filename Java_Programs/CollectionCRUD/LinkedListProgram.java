package CollectionCRUD;

import java.util.*;

public class LinkedListProgram {

    public static void main(String args[])
    {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("Dominos");
        ll.add("BigBasket");
        ll.add(1, "Blinkit");

        //changing element
        ll.set(1, "Jiomart");
        System.out.println("Updated LinkedList " + ll);

        //removal--
        ll.remove(1);

        System.out.println("After the Index Removal " + ll);

        ll.remove("BigBasket");

        System.out.println("After the Object Removal "
                + ll);
        //Traversing---
        // Using the Get method and the for loop
        for (int i = 0; i < ll.size(); i++) {

            System.out.print(ll.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : ll)
            System.out.print(str + " ");

        //linked list to array
        Object[] a = ll.toArray();
        System.out.print("After converted LinkedList to Array: ");
        for(Object element : a)
            System.out.print(element+" ");

        // Displaying the size of the list
        System.out.println("The size of the linked list is: " + ll.size());

        //remove first--
        System.out.println("The  remove first element is: " + ll.removeFirst());
        // Displaying the final list
        System.out.println("Final LinkedList:" + ll);


    }
}
