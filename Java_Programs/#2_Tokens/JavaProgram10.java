package PPT2;
/*
Execute main() multiple times without using any other function or condition or recursion in Java
*/

class JavaProgram10 {

    // static block
    static
    {
        main(new String[] { "Hello" });
        main(new String[] { "Hello" });
    }
    public static void main(String[] args)
    {
        System.out.println("Hii");
    }
}

