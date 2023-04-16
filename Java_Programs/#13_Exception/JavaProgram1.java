package PPT13;
/*
Write a Java program to illustrate multiple catch block using command line argument.
*/

class JavaProgram1
{
    public static void main(String[] args)
    {
        try
        {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            //if a and b are  non integer or out of index or b is 0 then exception occurs
            System.out.println("Result: "+c);
        }
        catch (ArithmeticException ae)
        {
            System.out.println("Enter second number except zero.");
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {
            System.out.println("Both numbers are required.");
        }
        catch(NumberFormatException ne)
        {
            System.out.println("Enter only integer value.");
        }
        finally
        {
            System.out.println("Finally Block");
        }
    }
}


