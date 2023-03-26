package PPT11;
// Java program to override the hashCode() and toString() method

public class JavaProgram15 {
    static int last_roll = 100;
    int roll_no;

    // Constructor
    JavaProgram15()
    {
        roll_no = last_roll;
        last_roll++;
    }

    // Overriding hashCode()
    @Override public int hashCode() { return roll_no; }

    public static void main(String args[])
    {
        JavaProgram15 s = new JavaProgram15();

        // Below two statements are equivalent
        System.out.println(s);
        System.out.println(s.toString());
    }
}

