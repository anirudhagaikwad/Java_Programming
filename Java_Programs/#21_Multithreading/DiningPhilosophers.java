/* Dining Philosophers Problem */

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Object[] forks = new Object[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            if (i == NUM_PHILOSOPHERS - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
        }
    }

    private static class Philosopher implements Runnable {
        private final Object leftFork;
        private final Object rightFork;

        public Philosopher(Object leftFork, Object rightFork) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // thinking
                    System.out.println(Thread.currentThread().getName() + " is thinking");
                    Thread.sleep(1000);

                    // pick up left fork
                    synchronized (leftFork) {
                        System.out.println(Thread.currentThread().getName() + " picked up left fork");
                        // pick up right fork
                        synchronized (rightFork) {
                            // eating
                            System.out.println(Thread.currentThread().getName() + " picked up right fork and is eating");
                            Thread.sleep(1000);
                            // put down right fork
                            System.out.println(Thread.currentThread().getName() + " put down right fork");
                        }
                        // put down left fork
                        System.out.println(Thread.currentThread().getName() + " put down left fork");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

/*In this program, we have five philosophers sitting at a table, each with a fork on their left and right. The philosophers alternate between thinking and eating, but can only eat if they have both the left and right forks. To prevent deadlock, we ensure that each philosopher picks up the forks in a specific order: the philosopher with the highest index picks up the right fork first, while all others pick up the left fork first. */
