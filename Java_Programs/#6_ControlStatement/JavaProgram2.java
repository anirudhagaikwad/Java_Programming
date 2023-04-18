package PPT6;

/*
Write a program to calculate HCF of Two given number.

The full form of HCF is Highest Common Factor. HCF of two numbers is the highest factor that can divide the two numbers, evenly. HCF can be evaluated for two or more than two numbers.  It is the greatest divisor for any two or more numbers, that can equally or completely divide the given numbers.
For Example: The Highest common factor of 60 and 75 is 15 because 15 is the largest number which can divide both 60 and 75 exactly.
*/
import java.util.Scanner;

public class JavaProgram2
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        int dividend, divisor;
        int remainder, hcf = 0;

        System.out.print("Enter the first number ");
        dividend = console.nextInt();

        System.out.print("Enter the second number ");
        divisor = console.nextInt();

        do
        {
            remainder = dividend % divisor; // calculate remainder

            if(remainder == 0)//divisibility check
            {
                hcf = divisor;
            }
            else
            {
                dividend = divisor;
                divisor = remainder;
            }

        }while(remainder != 0);

        System.out.println("HCF: " + hcf);
    }
}

