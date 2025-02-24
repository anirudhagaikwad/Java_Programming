package oop;
/*
### Java Literals 
In Java, literals are constant values assigned to variables. 
They represent fixed values and do not change during execution.

### Types of Java Literals:
1. Integer Literals
   - Used to represent whole numbers.
   - Can be in decimal (base 10), octal (base 8), hexadecimal (base 16), or binary (base 2) formats.
   
2. Floating-Point Literals
   - Used to represent decimal numbers.
   - Can be represented in standard or scientific notation.
   - by default, Java treats all decimal numbers as double ,use f or F to indicate a float literal.

3. Character Literals
   - Represent a single character enclosed in single quotes (`' '`).
   - Can be a Unicode character or escape sequence.
   
4. String Literals
   - Represent a sequence of characters enclosed in double quotes (`" "`).
   - Strings in Java are immutable objects of the `String` class.

5. Boolean Literals
   - Only two possible values: `true` and `false`.
   - Used in conditional statements and logical operations.

6. Null Literal
   - Represents the absence of a value in reference variables.
   - Used with objects, arrays, or any non-primitive data type.
   

### Summary Table:

| Literal Type         | Example                      | Notes                                           |
|----------------------|------------------------------|-------------------------------------------------|
| Integer Literals     | `100`, `0x64`, `0b1100100`   | Whole numbers in decimal, binary, octal, or hex |
| Floating-Point       | `3.14f`, `2.71828`, `1.5e3`  | Decimal numbers, requires `f` for float         |
| Character            | `'A'`, `'\n'`, `'\u0041'`    | Single character enclosed in quotes             |
| String               | `"Hello"`, `"Java"`          | Text enclosed in double quotes                  |
| Boolean              | `true`, `false`              | Logical values                                  |
| Null                 | `null`                       | Represents no value                             |
| Numeric with `_`     | `1_000_000`                  | Improves readability                            |

These literals are fundamental to Java programming and are used in expressions, assignments, and method arguments.


*/
public class P1_Literals {

	public static void main(String[] args) {
	//Integer Literals	   
		int decimal = 100;      // Decimal (Base 10)
		int octal = 0144;       // Octal (Base 8, starts with 0)
		int hexadecimal = 0x64; // Hexadecimal (Base 16, starts with 0x)
		int binary = 0b1100100; // Binary (Base 2, starts with 0b)
    //Floating-Point Literals
		float pi = 3.14f;  // 'f' or 'F' is required for float
		double e = 2.71828; // Default type is double
		double scientific = 1.5e3; // Scientific notation (1.5 × 10³)
	//Character Literals
		char letter = 'A';
		char unicode = '\u0041'; // Unicode representation of 'A'
		char newline = '\n'; // Newline character
	//String Literals
		String greeting = "Hello, Java!";
	//Boolean Literals
		 boolean isJavaFun = true;
		 boolean isCold = false;
	//Null Literal
		 String myString = null;
	}

}
