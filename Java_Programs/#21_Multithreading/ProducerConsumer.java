import java.util.LinkedList;
/* Producer-Consumer Problem */
public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Thread(new Producer(buffer, maxSize));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Producer implements Runnable {
        private final LinkedList<Integer> buffer;
        private final int maxSize;

        public Producer(LinkedList<Integer> buffer, int maxSize) {
            this.buffer = buffer;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (buffer) {
                    while (buffer.size() == maxSize) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(i);
                    System.out.println("Produced: " + i);
                    buffer.notify();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private final LinkedList<Integer> buffer;

        public Consumer(LinkedList<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int num = buffer.removeFirst();
                    System.out.println("Consumed: " + num);
                    buffer.notify();
                }
            }
        }
    }
}

/*
In this program, we have two threads running concurrently: one for producing integers and one for consuming them. The producer adds integers to a buffer until it reaches a maximum size, at which point it waits for the consumer to remove an integer before continuing. The consumer removes integers from the buffer and prints them to the console.
*/
