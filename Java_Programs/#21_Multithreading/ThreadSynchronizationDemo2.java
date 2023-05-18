/*
Thread synchronization is the process of coordinating the execution of multiple threads to ensure safe and predictable behavior when accessing shared resources or critical sections of code. In multi-threaded environments, where multiple threads execute concurrently, thread synchronization mechanisms are used to prevent data races, inconsistencies, and conflicts that can arise when multiple threads access and modify shared data simultaneously.

The primary goal of thread synchronization is to ensure that only one thread at a time can access the shared resource or critical section of code, preventing simultaneous conflicting operations and maintaining data integrity.

Common scenarios where thread synchronization is required include:

Shared Data Access: When multiple threads read from or write to the same shared data structure or object, synchronization ensures that only one thread can access the data at a time. This prevents race conditions, where the final result depends on the interleaving of thread execution.

Critical Sections: Critical sections are portions of code that must be executed exclusively by a single thread at any given time to maintain consistency. Thread synchronization ensures that only one thread can enter the critical section, preventing concurrent execution by multiple threads.

Thread Communication: Synchronization mechanisms such as locks, conditions, and semaphores facilitate communication and coordination between threads. They allow threads to wait for certain conditions to be satisfied or notify other threads when specific events occur.

In Java, thread synchronization can be achieved using various mechanisms, including:

synchronized keyword: By marking methods or code blocks with the synchronized keyword, Java ensures that only one thread can execute that code at a time. This provides intrinsic locking and is the simplest way to achieve synchronization.

Lock interface: The java.util.concurrent.locks.Lock interface provides more advanced locking mechanisms. It offers finer-grained control and additional features compared to synchronized blocks, such as explicit locking and unlocking, timed waits, and support for multiple condition variables.

volatile keyword: The volatile keyword ensures that the variable is accessed directly from main memory and not cached locally by each thread. It guarantees visibility of changes made to the variable across threads.

Thread-safe classes: Java provides thread-safe classes in the java.util.concurrent package, such as AtomicInteger, ConcurrentHashMap, and CountDownLatch. These classes are designed to be safely used by multiple threads without requiring explicit synchronization.

Proper thread synchronization is crucial for preventing race conditions, deadlocks, and inconsistent states in multi-threaded applications. By carefully synchronizing access to shared resources, developers can ensure the correctness, reliability, and efficiency of concurrent programs.
*/

public class ThreadSynchronizationDemo2 {
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
    private final Object lock = new Object();
    
    public void increment() {
        synchronized (lock) {
            value++;
        }
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

