package PPT13;

//Write a java program to show unreachable code error
class JavaProgram10 {
    public static void main(String args[])
    {

        System.out.println("I will get printed");

        return;

        // it will never run and gives error
        // as unreachable code.
        //System.out.println("I want to get printed");
    }
}
