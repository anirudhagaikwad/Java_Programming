package PPT9;

// Java program to illustrate Constructor Chaining to
// other class using super() keyword

class B1
{
    String name;

    // constructor 1
    B1()
    {
        this("");
        System.out.println("No-argument constructor of" +
                " base class");
    }

    // constructor 2
    B1(String name)
    {
        this.name = name;
        System.out.println("Calling parameterized constructor"
                + " of base");
    }
}

class JavaProgram9 extends B1
{
    // constructor 3
    JavaProgram9()
    {
        System.out.println("No-argument constructor " +
                "of derived");
    }

    // parameterized constructor 4
    JavaProgram9(String name)
    {
        // invokes base class constructor 2
        super(name);
        System.out.println("Calling parameterized " +
                "constructor of derived");
    }

    public static void main(String args[])
    {
        // calls parameterized constructor 4
        JavaProgram9 obj = new JavaProgram9("test");

        // Calls No-argument constructor
        // Derived obj = new Derived();
    }
}
