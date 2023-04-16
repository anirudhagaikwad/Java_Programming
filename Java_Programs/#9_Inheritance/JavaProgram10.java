package PPT9;

// Java Program to Illustrate has-a relation

// Class1
// Parent class
class Car{
    // Instance members of class Car
    private String color;
    private int maxSpeed;

    // Methods implementation

    // Method 1
    // To set the maximum speed of car
    public void setMaxSpeed(int maxSpeed)
    {
        // This keyword refers to current object itself
        this.maxSpeed = maxSpeed;
    }

    // Method 2
    // To set the color of car
    public void setColor(String color)
    {
        // This keyword refers to current object
        this.color = color;
    }

    // Method 3
    // To display car information
    public void carInfo()
    {
        // Print the car information - color and speed
        System.out.println("Car Color= " + color
                + " Max Speed= " + maxSpeed);
    }
}
// Class2
// Child class
// Helper class
class Maserati extends Car {

    // Method in which it is shown
    // what happened with the engine of Puslar
    public void MaseratiStartDemo()
    {
        // Creating an object of Engine type
        // using stop() method
        // Here, MaseratiEngine is name of an object
        Engine MaseratiEngine = new Engine();
        MaseratiEngine.start();
        MaseratiEngine.stop();
    }
}

// Class 3
// Helper class
class Engine {

    // Method 1
    // To start a engine
    public void start()
    {
        // Print statement when engine starts
        System.out.println("Started:");
    }

    // Method 2
    // To stop a engine
    public void stop()
    {
        // Print statement when engine stops
        System.out.println("Stopped:");
    }
}

public class JavaProgram10 {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating an object of Car class
        Car nano = new Car();

        // Assigning car object color
        nano.setColor("RED");

        // Assigning car object speed
        nano.setMaxSpeed(329);

        // Calling carInfo() over object of Car class
        nano.carInfo();

        // Creating an object of Maserati class
        Maserati quattroporte = new Maserati();

        // Calling MaseratiStartDemo() over
        // object of Maserati class
        quattroporte.MaseratiStartDemo();
    }

}


