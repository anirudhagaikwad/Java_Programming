/*
Prepare a class REVERSE in java that holds a methods
rev() this is a method that has the ability to reverse a no
Followed by a class ABILITY  that inherits the class REVERSE so that it can check palindrome() 

display() displays whether the entered no is palindrome or not

Create a last class INPUT that actually accepts input from the user and passes it to the REVERSE class and calls the respective function to check whether the entered no is palindrome or not

*/
import java.util.Scanner;

class REVERSE {
    private int number;

    public REVERSE(int number) {
        this.number = number;
    }

    public int rev() {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        }
        return reversedNumber;
    }
}

class ABILITY extends REVERSE {
    public ABILITY(int number) {
        super(number);
    }

    public boolean palindrome() {
        int reversedNumber = rev();
        return number == reversedNumber;
    }

    public void display() {
        if (palindrome()) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }
}

public class INPUT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        ABILITY ability = new ABILITY(number);
        ability.display();
    }
}

/*
In this implementation, the REVERSE class contains the rev() method which takes an integer and returns its reverse. The ABILITY class inherits from REVERSE and contains the palindrome() method which returns true if the number is a palindrome (i.e., it is the same when read forward and backward) and false otherwise. The ABILITY class also contains the display() method which prints out whether the number is a palindrome or not.

Finally, the INPUT class accepts input from the user and creates an instance of the ABILITY class with the user input as the number. It then calls the display() method to print out whether the number is a palindrome or not.
*/
