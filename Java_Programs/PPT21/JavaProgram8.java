package PPT21;

/*
* Java Program to Use isAlive() to prevent concurrency problems:
* */


public class JavaProgram8 extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        JavaProgram8 thread = new JavaProgram8();
        thread.start();
        // Wait for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }
        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
    }
    public void run() {
        amount++;
    }
}


