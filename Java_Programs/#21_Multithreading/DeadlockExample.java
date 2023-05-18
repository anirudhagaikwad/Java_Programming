/*
A deadlock is a situation in concurrent programming where two or more processes or threads are unable to proceed because each is waiting for the other to release a resource or take a particular action. It is a state where the involved entities are stuck in a circular waiting pattern, and none of them can progress.

Deadlocks typically occur in systems where multiple resources are shared among different processes or threads. To understand deadlock, it is essential to understand the four necessary conditions, known as the Coffman conditions, which must be present simultaneously:

Mutual Exclusion: At least one resource must be held in a non-shareable mode, meaning that only one process or thread can use it at a time.

Hold and Wait: A process holding at least one resource is waiting to acquire additional resources that are currently being held by other processes.

No Preemption: Resources cannot be forcibly taken away from a process; they must be released voluntarily by the process holding them.

Circular Wait: There exists a circular chain of two or more processes, each of which is waiting for a resource held by the next process in the chain.

When all four conditions are satisfied, a deadlock can occur. Once in a deadlock state, the involved processes or threads can remain there indefinitely, leading to a system that is unresponsive and unable to make progress.

Detecting and resolving deadlocks can be challenging, and it often requires careful system design, resource allocation strategies, and the use of synchronization techniques like locks, semaphores, or monitors to prevent or recover from deadlock situations.
*/
public class DeadlockExample {
    private static final Object laptop = new Object();
    private static final Object printer = new Object();

    public static void main(String[] args) {
        Thread aliceThread = new Thread(() -> {
            synchronized (laptop) {
                System.out.println("Alice acquired the laptop.");
                try {
                    Thread.sleep(100); // Introducing delay to increase the chance of deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (printer) {
                    System.out.println("Alice acquired the printer and is printing.");
                }
            }
        });

        Thread bobThread = new Thread(() -> {
            synchronized (printer) {
                System.out.println("Bob acquired the printer.");
                synchronized (laptop) {
                    System.out.println("Bob acquired the laptop and is printing.");
                }
            }
        });

        aliceThread.start();
        bobThread.start();
    }
}

/*
In this example, we have two threads representing Alice and Bob. Each thread tries to acquire the resources (laptop and printer) in a different order, leading to a potential deadlock.

When you run this code, it's possible that it may result in a deadlock situation. Alice acquires the laptop and waits to acquire the printer, while Bob acquires the printer and waits to acquire the laptop. As a result, both threads are stuck, unable to proceed and complete their tasks.

Please note that deadlocks are not guaranteed to occur every time you run this code. They depend on various factors such as timing and the system's scheduling behavior.
*/
