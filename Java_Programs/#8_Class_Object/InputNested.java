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

    class ABILITY {
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
}

public class INPUT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        REVERSE reverse = new REVERSE(number);
        REVERSE.ABILITY ability = reverse.new ABILITY();
        ability.display();
    }
}

/*
In this implementation, the REVERSE class contains the rev() method which takes an integer and returns its reverse, as well as an inner class called ABILITY. The ABILITY class contains the palindrome() method which returns true if the number is a palindrome (i.e., it is the same when read forward and backward) and false otherwise. The ABILITY class also contains the display() method which prints out whether the number is a palindrome or not.

Finally, the INPUT class accepts input from the user and creates an instance of the REVERSE class with the user input as the number. It then creates an instance of the ABILITY class using the new keyword and the dot notation with the REVERSE instance, like this: reverse.new ABILITY(). Finally, it calls the display() method to print out whether the number is a palindrome or not.
*/
