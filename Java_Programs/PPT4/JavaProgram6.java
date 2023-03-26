package PPT4;


// Example to illustrate accessing the instance method .
class Foo {

    String name = "";

    // Instance method to be called within the
    // same class or from a another class defined
    // in the same package or in different package.
    public void geek(String name) { this.name = name; }
}

class JavaProgram6 {
    public static void main(String[] args)
    {

        // create an instance of the class.
        Foo ob = new Foo();

        // calling an instance method in the class 'Foo'.
        ob.geek("Jack");
        System.out.println(ob.name);
    }
}
