package PPT11;

/* Java program to show that
if the static method is redefined by
a derived class, then it is not
overriding, it is hiding
 */

class Cls1 {
    // Static method in base class
    // which will be hidden in subclass
    static void m1()
    {
        System.out.println("From parent "
                + "static m1()");
    }

    // Non-static method which will
    // be overridden in derived class
    void m2()
    {
        System.out.println("From parent "
                + "non-static(instance) m2()");
    }
}

class Cls2 extends Cls1 {
    // This method hides m1() in Parent
    static void m1()
    {
        System.out.println("From child static m1()");
    }

    // This method overrides m2() in Parent
    @Override
    public void m2()
    {
        System.out.println("From child "
                + "non-static(instance) m2()");
    }
}


class JavaProgram11 {
    public static void main(String[] args)
    {
        Cls1 obj1 = new Cls2();

        // As per overriding rules this
        // should call to class Child static
        // overridden method. Since static
        // method can not be overridden, it
        // calls Parent's m1()
        obj1.m1();

        // Here overriding works
        // and Child's m2() is called
        obj1.m2();
    }
}
