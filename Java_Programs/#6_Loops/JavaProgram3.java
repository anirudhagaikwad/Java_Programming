package PPT6;

/*
Write a program to print Fibonacci series of n terms where n is input by user :
0 1 1 2 3 5 8 13 24 .....
*/
import java.util.Scanner;
public class JavaProgram3
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        int number;  // To hold number of terms

        int firstTerm = 0,
                secondTerm = 1,
                thirdTerm;

        System.out.print("Enter number of terms of series : ");
        number = console.nextInt();

        System.out.print(firstTerm + " " + secondTerm + " ");

        for(int i = 3; i <= number; i++)
        {
            thirdTerm = firstTerm + secondTerm; //third term is sum of first and second term
            System.out.print(thirdTerm + " ");
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }
    }
}

