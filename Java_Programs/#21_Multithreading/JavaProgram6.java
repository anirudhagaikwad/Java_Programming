package PPT21;
/*
Write a Java program using Synchronized Threads, which demonstrates Producer Consumer concept.

Producer Consumer problem:
The producer-consumer problem is the classical concurrency of a multi process synchronization problem. It is also known as bound-buffer problem.

The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue. The producer generates a piece of data, put it into the buffer and starts again.
*/

public class JavaProgram6
{
    public static void main(String[] args)
    {
        Shop c = new Shop();
        //share same shop obj with producer and consumer
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        p1.start();
        c1.start();
    }
}
class Shop
{
    private int materials;
    private boolean available = false; //store availability
    public synchronized int get()
    {
        while (available == false)
        {
            try
            {
                wait();  //if material is not available wait
            }
            catch (InterruptedException ie)
            {
            }
        }
        available = false;
        notifyAll();
        return materials;
    }
    public synchronized void put(int value)
    {
        while (available == true)
        {
            try
            {
                wait();
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        materials = value;
        available = true;
        notifyAll();
    }
}
class Consumer extends Thread
{
    private Shop Shop;
    private int number;
    public Consumer(Shop c, int number)
    {
        Shop = c;
        this.number = number;
    }
    public void run()
    {
        int value = 0;
        for (int i = 0; i < 10; i++)
        {
            value = Shop.get(); //get material from producer
            System.out.println("Consumed value " + this.number+ " got: " + value);
        }
    }
}
class Producer extends Thread
{
    private Shop Shop;
    private int number;

    public Producer(Shop c, int number)
    {
        Shop = c;
        this.number = number;
    }
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            Shop.put(i); //produce material(val)
            System.out.println("Produced value " + this.number+ " put: " + i);
            try
            {
                sleep((int)(Math.random() * 100)); //random pause
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

