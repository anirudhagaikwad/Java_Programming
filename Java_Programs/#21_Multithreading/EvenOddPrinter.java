/*
Demonstrates how multithreading can be used to perform multiple tasks concurrently.
Prints N number of even and odd numbers using multithreading.
*/
public class EvenOddPrinter {
    private static final int MAX_NUMBER = 20;

    public static void main(String[] args) {
        EvenOddRunnable evenRunnable = new EvenOddRunnable(true);
        EvenOddRunnable oddRunnable = new EvenOddRunnable(false);

        Thread evenThread = new Thread(evenRunnable);
        Thread oddThread = new Thread(oddRunnable);

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class EvenOddRunnable implements Runnable {
        private final boolean isEven;

        public EvenOddRunnable(boolean isEven) {
            this.isEven = isEven;
        }

        @Override
        public void run() {
            int number = isEven ? 2 : 1;
            while (number <= MAX_NUMBER) {
                if ((number % 2 == 0) == isEven) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                } else {
                    Thread.yield();
                }
            }
        }
    }
}

/*
In this program, we have two threads running concurrently: one for printing even numbers and one for printing odd numbers. Each thread has its own EvenOddRunnable instance, which determines whether it should print even or odd numbers based on a boolean flag passed to the constructor.

The run() method of each EvenOddRunnable instance iterates through the numbers from 1 to MAX_NUMBER, and prints out the numbers that are either even or odd based on the isEven flag. If the number is not of the expected parity, the thread calls Thread.yield() to give up its remaining time slice and allow the other thread to run.
*/
