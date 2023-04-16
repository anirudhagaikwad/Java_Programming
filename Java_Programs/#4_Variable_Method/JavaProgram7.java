package PPT4;

// Java program to illustrate Accessing the Static method(s) of the class.

import java.io.*;

class Geek {

    public static String geekName = "";

    public static void geek(String name)
    {
        geekName = name;
    }
}

class JavaProgram7 {
    public static void main(String[] args)
    {

        // Accessing the static method geek()
        // and field by class name itself.
        Geek.geek("vaibhavi");
        System.out.println(Geek.geekName);

        // Accessing the static method geek()
        // by using Object's reference.
        Geek obj = new Geek();
        obj.geek("sayali");
        System.out.println(obj.geekName);
    }
}
