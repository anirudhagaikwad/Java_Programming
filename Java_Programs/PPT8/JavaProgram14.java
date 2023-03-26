package PPT8;

/* Java program to demonstrate an array
 of objects is declared with initial values.
 */

class JavaProgram14 {

    public static void main(String args[])
    {
        // Creating an array of objects
        // declared with initial values
        Object[] javaObjectArray
                = { "Maruti", new Integer(2019), "Suzuki",
                new Integer(2019) };

        // Printing the values
        System.out.println(javaObjectArray[0]);
        System.out.println(javaObjectArray[1]);
        System.out.println(javaObjectArray[2]);
        System.out.println(javaObjectArray[3]);
    }
}


