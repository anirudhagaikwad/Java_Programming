package fundamentals;
import java.util.Scanner;

public class P5_DecisionMaking_Switch {
/*
 * The switch statement in Java is used to execute one block of code among many options.
 * It is an alternative to a long chain of if-else-if statements and provides better readability.
 *
 * In Java 12, switch expressions were introduced as a preview feature, and they were finalized in Java 14.
 * Java 21 enhances switch with pattern matching, allowing more flexible and readable code.
 *
 * Key Features of Modern Switch (Java 14+ and Java 21 improvements):
 * - Arrow syntax for concise expressions (no need for break statements)
 * - Switch as an expression returning values
 * - Pattern matching (Java 21) allowing type checks within case labels
 */
	
    void controlStatement_switchDemo1(int monthNumber) {
        // Using Java 14+ switch expression
        String monthName = switch (monthNumber) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid Input";
        };
        System.out.println(monthNumber + " = " + monthName);
    }

    void controlStatement_switchDemo2(int year, int monthNumber) {
        // Modern switch with concise syntax
        int numDays = switch (monthNumber) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
            default -> {
                System.out.println("Invalid Input");
                yield -1;
            }
        };
        if (numDays != -1)
            System.out.println(numDays + " Number of Days in month " + monthNumber);
    }

    int controlStatement_switchDemo3(String monthName) {
        if (monthName == null) return 0;
        return switch (monthName.toLowerCase()) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };
    }

    public static void main(String[] args) {
    	P5_DecisionMaking_Switch obj = new P5_DecisionMaking_Switch();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Month Number: ");
        int monthNumber = scan.nextInt();
        obj.controlStatement_switchDemo1(monthNumber);

        System.out.println("Enter Year: ");
        int year = scan.nextInt();
        obj.controlStatement_switchDemo2(year, monthNumber);

        System.out.println("Enter Month Name: ");
        String monthName = scan.next();
        int num = obj.controlStatement_switchDemo3(monthName);
        System.out.println(num + " number is " + monthName);
        scan.close();
        
        System.out.println(processObject(42));          // Integer input
        System.out.println(processObject(10.5));        // Double input
        System.out.println(processObject("Java 21"));   // String input
        System.out.println(processObject(null));        // Null input
        System.out.println(processObject(true));        // Boolean input
    }
 
    //Pattern matching
    static String processObject(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer: " + (i * 2);   // Type match Integer
            case Double d -> "Double: " + (d / 2);     // Type match Double
            case String s -> "String length: " + s.length(); // Type match String
            case null -> "Null value encountered!";    // Handle null safely
            default -> "Unknown type: " + obj;         // Handle other types
        };
    }
    
} 

/*
The condition  

(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

is used to check if a given year is a leap year.  


### Understanding Each Condition:
#### 1️) `(year % 4 == 0)` → Divisible by 4
- A leap year normally happens every 4 years (e.g., 2024, 2028, 2032).
  
#### 2️) `(year % 100 != 0)` → Not Divisible by 100
- Years divisible by 100 are not leap years unless they are also divisible by 400.  
  - Example: 1900 is not a leap year, but 2000 is.

#### 3️) `(year % 400 == 0)` → Divisible by 400 (Exception for century years)
- If a year is divisible by 400, then it is a leap year even if it’s divisible by 100.
  - Example: 1600 and 2000 are leap years, but 1700, 1800, and 1900 are not.

### Examples:
| Year   | `year % 4 == 0` | `year % 100 != 0` | `year % 400 == 0` | Leap Year? |
|--------|-----------------|-------------------|-------------------|------------|
| 2024   | ✅ Yes          | ✅ Yes            | ❌ No             | ✅ Yes     |
| 1900   | ✅ Yes          | ❌ No             | ❌ No             | ❌ No      |
| 2000   | ✅ Yes          | ❌ No             | ✅ Yes            | ✅ Yes     |
| 2100   | ✅ Yes          | ❌ No             | ❌ No             | ❌ No      |

So, 2024 is a leap year, but 2100 is not because it is divisible by 100 but not by 400.
*/