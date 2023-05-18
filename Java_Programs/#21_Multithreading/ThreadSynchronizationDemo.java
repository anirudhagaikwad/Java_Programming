
public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        Thread thread1 = new Thread(new IncrementTask(counter));
        Thread thread2 = new Thread(new IncrementTask(counter));
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter value: " + counter.getValue());
    }
}

class Counter {
    private int value;
    
    public synchronized void increment() {
        value++;
    }
    
    public int getValue() {
        return value;
    }
}

class IncrementTask implements Runnable {
    private Counter counter;
    
    public IncrementTask(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}

/*
In this example, we have a Counter class that maintains a value. The increment() method of the Counter class is marked as synchronized, which ensures that only one thread can execute this method at a time.

We create two threads (thread1 and thread2), and both threads share the same Counter object. Each thread executes the run() method of the IncrementTask class, which invokes the increment() method on the shared Counter object.

By synchronizing the increment() method, we guarantee that only one thread can increment the counter at a time. This prevents data race conditions where multiple threads may interfere with each other and produce incorrect results.

The join() method is used to wait for both threads to complete their execution before printing the final value of the counter.

The output of the program will be Counter value: 200000, indicating that both threads executed the increment() method in a synchronized manner, resulting in the correct counter value.
*/
