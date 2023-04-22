// Shape class (base class)
class Shape {
    public double area() {
        return 0.0;
    }
}

// Rectangle class (derived from Shape)
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Circle class (derived from Shape)
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Square class (derived from Rectangle)
class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Triangle class (derived from Shape)
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Main class to test inheritance and area calculation
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(3, 4);
        Rectangle square = new Square(6);

        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Circle area: " + circle.area());
        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Square area: " + square.area());
    }
}

