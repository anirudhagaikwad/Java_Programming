package PPT12;

//java program to illustate static non access modifier in java

import java.io.*;
class static_gfg {

    // static variable
    static int count = 0;
    void myMethod()
    {
        count++;
        System.out.println(count);
    }
}
class JavaProgram1 {
    public static void main(String[] args)
    {
        // first object creation
        static_gfg obj1 = new static_gfg();

        // method calling of first object
        obj1.myMethod();

        // second object creation
        static_gfg obj2
                = new static_gfg();

        // method calling of second object
        obj2.myMethod();
    }
}
