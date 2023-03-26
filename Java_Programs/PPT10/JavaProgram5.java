package PPT10;

// Java Program to Illustrate Abstract classes Can also have Final Methods

// Class 1
// Abstract class
abstract class Basee {

    final void fun()
    {
        System.out.println("Base fun() called");
    }
}

// Class 2
class Der_ extends Basee {

}

// Class 3
// Main class
class JavaProgram5 {

    public static void main(String args[])
    {
        {
            // Creating object of abstract class

            Basee b = new Der_();
            // Calling method on object created above
            // inside main method

            b.fun();
        }
    }
}
