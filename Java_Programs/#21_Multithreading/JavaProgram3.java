package PPT21;
/*
Write a program to demonstrate the Synchronization block.

Synchronization:
Synchronization is the process of allowing threads to execute one after another. It provides the control to access multiple threads to shared resources.  When we want to allow one thread to access the shared resource, then synchronization is the better option.
*/
class SynchTest {
    void printNumber(int n) {
        //synchronized block
        synchronized (this) {
            System.out.println("Table of " + n);
            System.out.println("==========");
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " * " + i + " = " + (n * i));
                try {
                    Thread.sleep(400);
                } catch (Exception e) { //catch exception thrown by sleep()
                    System.out.println(e);
                }
            }
        }
    }
}

//create second thread
class MyThread1 extends Thread {
    SynchTest t;

    MyThread1(SynchTest t) {
        this.t = t;
    }

    public void run() {
        t.printNumber(7);  //synchronize with thread 1
    }
}


public class JavaProgram3 {
    public static void main(String args[]) {
        SynchTest obj = new SynchTest();
        MyThread1 t1 = new MyThread1(obj);
        t1.start();//run thread
    }
}

