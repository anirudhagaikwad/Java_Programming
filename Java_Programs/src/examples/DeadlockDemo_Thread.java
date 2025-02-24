package examples;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Deadlock occurs when two or more threads hold some resources and wait indefinitely for each 
other to release them.
🔹 Where Do Deadlocks Happen in Real Life?
✅ Database Transactions – Two queries waiting for each other’s lock
✅ Multi-threaded Banking Apps – When funds transfer locks accounts in the wrong order
✅ Operating Systems – When processes wait for resources like CPU or disk access

📌 Example: Deadlock Between Two Threads
Thread 1 locks Resource A and waits for Resource B
Thread 2 locks Resource B and waits for Resource A
Both threads are stuck forever – causing a deadlock.

🔹 Why This Causes a Deadlock?
Thread-1 locks Resource A, then waits for Resource B
Thread-2 locks Resource B, then waits for Resource A
Both threads never release resources, leading to deadlock 🔄
 */
class DeadlockExample {
    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    // Method where Thread-1 locks A then B
    public void methodA() {
        lockA.lock();
        System.out.println(Thread.currentThread().getName() + " locked Resource A");

        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockB.lock();
        System.out.println(Thread.currentThread().getName() + " locked Resource B");

        lockB.unlock();
        lockA.unlock();
    }

    // Method where Thread-2 locks B then A (Opposite order)
    public void methodB() {
        lockB.lock();
        System.out.println(Thread.currentThread().getName() + " locked Resource B");

        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockA.lock();
        System.out.println(Thread.currentThread().getName() + " locked Resource A");

        lockA.unlock();
        lockB.unlock();
    }
}

public class DeadlockDemo_Thread {
    public static void main(String[] args) {
        DeadlockExample deadlock = new DeadlockExample();

        Thread thread1 = new Thread(deadlock::methodA, "Thread-1");
        Thread thread2 = new Thread(deadlock::methodB, "Thread-2");

        thread1.start();
        thread2.start();
    }
}

/*
📌 How to Avoid Deadlocks?
1️ Use tryLock() Instead of lock()

If the lock isn’t available, avoid waiting indefinitely
2️ Always Lock in the Same Order
Ensure all threads lock Resource A first, then Resource B
3️ Use a Timeout
If the lock takes too long, abort the operation

Code - >

public void methodA() {
    if (lockA.tryLock()) {
        try {
            System.out.println(Thread.currentThread().getName() + " locked Resource A");
            Thread.sleep(100);
            if (lockB.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " locked Resource B");
                } finally {
                    lockB.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockA.unlock();
        }
    }
}


*/