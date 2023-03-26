package PPT21;
/*
Write a program to set the priorities of the thread.

Thread priorities:
In Java, each thread has a priority. Priorities are represented by number from 0 to 10. The default priority of NORM_PRIORITY is 5, MIN_PRIORITY is 1 and MAX_PRIORITY is 10.
*/

public class JavaProgram2 extends Thread
{
    public void run()
    {

        String threadName = Thread.currentThread().getName();
        Integer threadPrio = Thread.currentThread().getPriority();
        System.out.println("run() method - "+threadName);
        System.out.println(threadName + " has priority " + threadPrio);
    }
    public static void main(String[] args) throws InterruptedException
    {
        //create thread
        JavaProgram2 t1 = new JavaProgram2();
        JavaProgram2 t2 = new JavaProgram2();
        JavaProgram2 t3 = new JavaProgram2();

        //set priorities
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        //run thread
        t1.start();
        t2.start();
        t3.start();
    }
}

