package PPT11;

/* Java Program Illustrating Instance variables  Can not
be Overridden
 */

// Class 1
// Parent class
class ParentCls {
    // Declaring instance variable by name `a`
    int a = 10;
    public void print()
    {
        System.out.println("inside B superclass");
    }
}

// Class 2
// Child class
// Helper class
class ChildCls extends ParentCls {

    // Hiding Parent class's variable `a` by defining a
    // variable in child class with same name.
    int a = 20;

    // Method defined inside child class
    public void print()
    {
        // Print statement
        System.out.println("inside C subclass");
    }
}

public class JavaProgram6 {

    public static void main(String[] args)
    {
        // Creating a Parent class object
        // Reference Parent
        ParentCls obj = new ChildCls();

        // Calling print() method over object created
        obj.print();

        // Printing superclass variable value 10
        System.out.println(obj.a);

        // Creating a Child class object
        // Reference Child
        ChildCls obj2 = new ChildCls();

        // Printing childclass variable value 20
        System.out.println(obj2.a);
    }
}


