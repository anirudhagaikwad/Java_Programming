package CollectionCRUD;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeProgram {
    public static void main(String[] args) {
        // Initializing an deque
        Deque<String> dq
                = new ArrayDeque<String>();

        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");

        System.out.println(dq);

        //remove elements--
        System.out.println(dq.pop());
        System.out.println(dq.poll());
        System.out.println(dq.pollFirst()); //remove first
        System.out.println(dq.pollLast()); //remove last

        // clear() method
        dq.clear();

        // addFirst() method to insert the
        // elements at the head
        dq.addFirst("google");
        dq.addFirst("microsoft");

        // addLast() method to insert the
        // elements at the tail
        dq.addLast("infosys");
        dq.addLast("capgemini");

        //traverse--
        for (Iterator itr = dq.iterator();
             itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
    }
}
