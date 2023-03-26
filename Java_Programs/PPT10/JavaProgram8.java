package PPT10;


// Java Program to crate shapes and find its area using concept of interfaces

import java.io.*;

// Interface
interface ShapeCls {

    // Abstract method
    void draw();
    double area();
}

// Class 1
// Helper class
class Rect implements ShapeCls {

    int length, width;

    // constructor
    Rect(int length, int width)
    {
        this.length = length;
        this.width = width;
    }

    @Override public void draw()
    {
        System.out.println("Rectangle has been drawn ");
    }

    @Override public double area()
    {
        return (double)(length * width);
    }
}

// Class 2
// Helper class
class Cir implements ShapeCls {

    double pi = 3.14;
    int radius;

    // constructor
    Cir(int radius) { this.radius = radius; }

    @Override public void draw()
    {
        System.out.println("Circle has been drawn ");
    }

    @Override public double area()
    {

        return (double)((pi * radius * radius));
    }
}

// Class 3
// Main class
class JavaProgram8 {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating the Object of Rectangle class
        // and using shape interface reference.
        ShapeCls rect = new Rect(2, 3);

        System.out.println("Area of rectangle: "
                + rect.area());

        // Creating the Objects of circle class
        ShapeCls cir = new Cir(2);

        System.out.println("Area of circle: "
                + cir.area());
    }
}
