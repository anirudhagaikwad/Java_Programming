package PPT11;

// Override of non-static method

class Parent {
    void show()
    {
        System.out.println("Parent");
    }
}

// Parent inherit in Child class
class Child extends Parent {

    // override show() of Parent
    void show()
    {
        System.out.println("Child");
    }
}

class JavaProgram3 {
    public static void main(String[] args)
    {
        Parent p = new Parent();
        // calling Parent's show()
        p.show();

        Parent c = new Child();
        // calling Child's show()
        c.show();
    }
}
