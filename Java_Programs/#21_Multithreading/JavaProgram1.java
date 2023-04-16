package PPT21;

/*
 Write a Java program to create multiple thread in Java.
*/

class ThreadTest extends Thread //extend Thread class
{
    private Thread thread;
    private String threadName;

    ThreadTest( String msg)
    {
        threadName = msg;
        System.out.println("Creating thread: " +  threadName );
    }
    public void run() //implement run method compulsorily
    {
        System.out.println("Running thread: " +  threadName );
        try
        {
            for(int i = 0; i < 5; i++)
            {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(500); //sleep thread
            }
        }
        catch (InterruptedException e) //catch exception
        {
            System.out.println("Exception in thread: " +  threadName);
        }
        System.out.println("Thread " +  threadName + " continue...");
    }
    public void start ()
    {
        System.out.println("Start method " +  threadName );
        if (thread == null)
        {
            thread = new Thread (this, threadName);
            thread.start ();//start thread it will call run() method
        }
    }
}
public class JavaProgram1
{
    public static void main(String args[])
    {
        ThreadTest thread1 = new ThreadTest( "First Thread");
        thread1.start();

        ThreadTest thread2 = new ThreadTest( "Second Thread");
        thread2.start();
    }
}

