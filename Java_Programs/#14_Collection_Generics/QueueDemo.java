import java.util.NoSuchElementException;

class Queue<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Size: " + queue.size());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());
    }
}
/*
In this implementation, the Queue class 
is parameterized with a type parameter E, 
allowing you to create a queue of any type.
It uses a linked list approach, 
where each element is represented by a Node containing 
the data and a reference to the next node. 
The front and rear variables keep track of the front and rear elements of the queue, respectively.
*/

/*

enqueue(E element): Inserts the specified element at the rear of the queue.

dequeue(): Removes and returns the element at the front of the queue. If the queue is empty, it throws a NoSuchElementException.

peek(): Returns the element at the front of the queue without removing it. If the queue is empty, it throws a NoSuchElementException.

isEmpty(): Checks if the queue is empty and returns a boolean value accordingly.

size(): Returns the number of elements in the queue.
*/
