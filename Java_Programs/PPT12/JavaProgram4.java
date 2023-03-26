package PPT12;
/*
* Java program to illustrate volatile non access modifier
* */
import java.io.*;
import java.util.*;

class Geeks extends Thread
{
    volatile boolean running = true;
    @Override public void run()
    {
        while (running) {
            System.out.println("java");
        }
    }
    public void shutDown() { running = false; }
}

class JavaProgram4 {
    public static void main(String[] args)
    {
        Geeks obj = new Geeks();
        obj.start();
        Scanner input = new Scanner(System.in);
        input.nextLine();
        obj.shutDown();
    }
}
