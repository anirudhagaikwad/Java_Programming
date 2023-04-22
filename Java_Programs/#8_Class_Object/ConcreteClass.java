class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class ConcreteClass{
public static void main(String[] args) {
        Rectangle rect = new Rectangle(4.0, 5.0);
        double area = rect.getArea();
        double perimeter = rect.getPerimeter();
        System.out.println("Rectangle area: " + area);
        System.out.println("Rectangle perimeter: " + perimeter);
    }
}

/*
In this example, the Rectangle class is a concrete class because it is fully implemented and can be instantiated to create objects. It has a constructor that initializes the width and height of a rectangle, as well as methods that calculate its area and perimeter.

The getArea method returns the product of the width and height, while the getPerimeter method returns the sum of the width and height multiplied by two. These methods provide concrete implementations for the behavior of a rectangle, which can be used by other parts of a program that need to work with rectangles.

It's also worth noting that this class is not meant to be inherited or extended by other classes, as there are no abstract methods or modifiers in the class definition. This means that it provides a complete implementation of the Rectangle behavior, and other classes can simply use it as is.
*/