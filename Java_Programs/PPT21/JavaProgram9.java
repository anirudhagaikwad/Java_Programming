package PPT21;

// Java program to demonstrate suspend() method of Thread class

import java.io.*;

class JavaProgram9 extends Thread {
    public void run()
    {
        for (int i = 1; i < 5; i++) {
            try {

                // thread to sleep for 500 milliseconds
                sleep(5);
                System.out.println(
                        "Currently running - "
                                + Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        // creating three threads
        JavaProgram9 t1 = new JavaProgram9();
        JavaProgram9 t2 = new JavaProgram9();
        JavaProgram9 t3 = new JavaProgram9();

        // call run() method
        t1.start();
        t2.start();

        // suspend t2 thread
       // t2.suspend();//throw error in new java version as it is deprecated

        // call run() method
        t3.start();
    }
}

