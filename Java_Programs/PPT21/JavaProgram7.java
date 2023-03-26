package PPT21;

/* Write a program to display all running threads in Java. */


class JavaProgram7 extends Thread
{
    public static void main(String[] args)
    {
        System.out.println("Main methods");
        JavaProgram7  obj = new JavaProgram7();
        //set the thread name2
        obj.setName("\nThreadName ");
        //calling run () method
        obj.start();

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup(); //get thread group
        int numThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[numThreads];
        currentGroup.enumerate(lstThreads);

        for (int i =1;i< numThreads ; i++)
        {
            System.out.println("Number of thread: "+i + "  " + lstThreads[i].getName());
        }

        //checking the current running thread
        Thread currentThread = Thread.currentThread();
        System.out.println("Current running thread: "+currentThread);
    }
}

