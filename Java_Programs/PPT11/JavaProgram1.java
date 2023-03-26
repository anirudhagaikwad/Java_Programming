package PPT11;

// Java Program to show the overriding using inheritance in subclasses

// Grandpa class is at the top of  the inheritance hierarchy
class Grandpa {
    public void show()
    {
        System.out.println(
                "Inside show() method of Grandpa class");
    }
}

class Dad extends Grandpa {

    // Overriding show method of Grandpa class
    @Override public void show()
    {
        System.out.println(
                "Inside show() method of Dad class");
    }
}

// class Me is inheriting Dad class (i.e.
// a subclass of Grandpa class)
class Me extends Dad {

    // Overriding show method of Dad class
    @Override public void show()
    {
        System.out.println(
                "Inside show() method of Me class");
    }
}

public class JavaProgram1 {
    public static void main(String[] args)
    {
        // Creating instance of Grandpa class
        Grandpa grandpa = new Grandpa();

        // Creating instance of Dad class
        Grandpa dad = new Dad();

        // Creating instance of Me class
        Grandpa me = new Me();

        // as discussed which show() function will get
        // execute depends upon the type of object

        // show function of Grandpa class will get execute
        grandpa.show();

        // show function of Dad class will get execute
        dad.show();

        // show function of Me class will get execute
        me.show();
    }
}
