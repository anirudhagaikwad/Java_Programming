package PPT8;
/* Java program to demonstrate
 object creation using newInstance() method
 */

class Example {
    void message()
    {
        System.out.println("Hello Geeks !!");
    }
}

class JavaProgram12 {
    public static void main(String args[])
    {
        try {
            Class c = Class.forName("Example");
            Example s = (Example)c.newInstance();
            s.message();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

