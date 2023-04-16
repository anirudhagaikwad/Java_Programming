package PPT6;
/*
Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
*/

import java.util.Scanner;

public class JavaProgram1
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        int number;
        char choice;
        int evenSum = 0;
        int oddSum = 0;

        do
        {
            System.out.print("Enter the number ");
            number = console.nextInt(); //input number

            if( number % 2 == 0) //check for even
            {
                evenSum += number;
            }
            else
            {
                oddSum += number;
            }

            System.out.print("Do you want to continue y/n? ");
            choice = console.next().charAt(0);

        }while(choice=='y' || choice == 'Y'); //check condition

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }
}

