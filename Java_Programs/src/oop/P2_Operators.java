package oop;
/*
### Java Operators and Precedence
In Java, operators are special symbols that perform operations on variables and values. 
Java provides a rich set of operators, categorized based on their functionality.

### 1. Arithmetic Operators
These operators perform mathematical operations such as addition, subtraction, multiplication, and division.
| Operator | Description         | Example  |
|----------|---------------------|----------|
| `+`      | Addition            | `a + b`  |
| `-`      | Subtraction         | `a - b`  |
| `*`      | Multiplication      | `a * b`  |
| `/`      | Division            | `a / b`  |
| `%`      | Modulus (Remainder) | `a % b`  |

### 2. Relational (Comparison) Operators
These operators compare two values and return a boolean result.
| Operator | Description              | Example  |
|----------|--------------------------|----------|
| `==`     | Equal to                 | `a == b` |
| `!=`     | Not equal to             | `a != b` |
| `>`      | Greater than             | `a > b`  |
| `<`      | Less than                | `a < b`  |
| `>=`     | Greater than or equal to | `a >= b` |
| `<=`     | Less than or equal to    | `a <= b` |

### 3. Logical Operators
Logical operators are used for boolean logic.
| Operator | Description  | Example  |
|----------|-------------|----------|
| `&&`     | Logical AND | `a && b` |
| `||`     | Logical OR  | `a || b` |
| `!`      | Logical NOT | `!a`     |

### 4. Bitwise Operators
Bitwise operators perform operations at the binary level.
| Operator | Description          | Example   |
|----------|----------------------|-----------|
| `&`      | Bitwise AND          | `a & b`   |
| `|`      | Bitwise OR           | `a | b`   |
| `^`      | Bitwise XOR          | `a ^ b`   |
| `~`      | Bitwise Complement   | `~a`      |
| `<<`     | Left shift           | `a << 2`  |
| `>>`     | Right shift          | `a >> 2`  |
| `>>>`    | Unsigned right shift | `a >>> 2` |

### 5. Assignment Operators
Assignment operators are used to assign values to variables.
| Operator | Description                     | Example                        |
|----------|---------------------------------|--------------------------------|
| `=`      | Assign                          | `a = b`                        |
| `+=`     | Add and assign                  | `a += b` (same as `a = a + b`) |
| `-=`     | Subtract and assign             | `a -= b`                       |
| `*=`     | Multiply and assign             | `a *= b`                       |
| `/=`     | Divide and assign               | `a /= b`                       |
| `%=`     | Modulus and assign              | `a %= b`                       |
| `&=`     | Bitwise AND and assign          | `a &= b`                       |
| `|=`     | Bitwise OR and assign           | `a |= b`                       |
| `^=`     | Bitwise XOR and assign          | `a ^= b`                       |
| `<<=`    | Left shift and assign           | `a <<= b`                      |
| `>>=`    | Right shift and assign          | `a >>= b`                      |
| `>>>=`   | Unsigned right shift and assign | `a >>>= b`                     |

### 6. Ternary Operator
A shorthand for `if-else` statements.
| Operator | Description           | Example                     |
|----------|-----------------------|-----------------------------|
| `?:`     | Conditional (ternary) | `result = (a > b) ? x : y;` |

### 7. Unary Operators
Operators that work with a single operand.
| Operator | Description        | Example        |
|----------|------------------|--------------|
| `+`      | Positive number    | `+a`         |
| `-`      | Negative number    | `-a`         |
| `++`     | Increment          | `a++` or `++a` |
| `--`     | Decrement          | `a--` or `--a` |
| `!`      | Logical NOT        | `!a`         |
| `~`      | Bitwise complement | `~a`         |

### 8. Instanceof Operator
Used to test if an object is an instance of a specific class or subclass.
| Operator     | Description        | Example                      |
|--------------|------------------|----------------------------|
| `instanceof` | Checks object type | `if (obj instanceof String)` |

### Operator Precedence
Operator precedence determines the order in which operations are performed. 
Higher precedence operators are evaluated first.

| Operator Type  | Operators                                    |
|---------------|---------------------------------------------|
| Postfix       | `expr++ expr--`                             |
| Unary         | `++expr --expr +expr -expr ~ !`             |
| Multiplicative| `* / %`                                     |
| Additive      | `+ -`                                       |
| Shift         | `<< >> >>>`                                 |
| Relational    | `< > <= >= instanceof`                      |
| Equality      | `== !=`                                     |
| Bitwise AND   | `&`                                         |
| Bitwise XOR   | `^`                                         |
| Bitwise OR    | `|`                                         |
| Logical AND   | `&&`                                        |
| Logical OR    | `||`                                        |
| Ternary       | `?:`                                        |
| Assignment    | `= += -= *= /= %= &= ^= |= <<= >>= >>>=`    |

Understanding operator precedence helps in writing efficient expressions without unnecessary parentheses.
However, using parentheses is recommended to improve code readability.

 
*/
public class P2_Operators {

	    // Method to demonstrate Arithmetic Operators
		    public static void arithmeticOperators() {
		        int a = 10, b = 5;
		        System.out.println("Arithmetic Operators:");
		        System.out.println("Addition: " + (a + b));
		        System.out.println("Subtraction: " + (a - b));
		        System.out.println("Multiplication: " + (a * b));
		        System.out.println("Division: " + (a / b));
		        System.out.println("Modulus: " + (a % b));
		    }

	   // Method to demonstrate Bitwise Operators
		    public static void bitwiseOperators() {
		        int a = 5, b = 3;
		        System.out.println("\nBitwise Operators:");
		        System.out.println("a & b (AND): " + (a & b));
		        System.out.println("a | b (OR): " + (a | b));
		        System.out.println("a ^ b (XOR): " + (a ^ b));
		        System.out.println("~a (Complement): " + (~a));
		        System.out.println("a << 1 (Left Shift): " + (a << 1));
		        System.out.println("a >> 1 (Right Shift): " + (a >> 1));
		    }

		    /*
		    Truth Table for Bitwise Operators:
		    ----------------------------------
		    A  |  B  | A & B | A | B | A ^ B
		    ----------------------------------
		    0  |  0  |   0   |   0   |   0  
		    0  |  1  |   0   |   1   |   1  
		    1  |  0  |   0   |   1   |   1  
		    1  |  1  |   1   |   1   |   0  
		    ----------------------------------
		    */

	  // Method to demonstrate Logical Operators
		    public static void logicalOperators() {
		        boolean x = true, y = false;
		        System.out.println("\nLogical Operators:");
		        System.out.println("x && y (AND): " + (x && y));
		        System.out.println("x || y (OR): " + (x || y));
		        System.out.println("!x (NOT): " + (!x));
		    }

	 // Method to demonstrate Assignment Operators
		    public static void assignmentOperators() {
		        int a = 10;
		        System.out.println("\nAssignment Operators:");
		        System.out.println("a = " + (a));
		        a += 5;
		        System.out.println("a += 5: " + (a));
		        a -= 3;
		        System.out.println("a -= 3: " + (a));
		        a *= 2;
		        System.out.println("a *= 2: " + (a));
		        a /= 2;
		        System.out.println("a /= 2: " + (a));
		    }

     // Method to demonstrate Ternary Operator
		    public static void ternaryOperator() {
		        int a = 10, b = 20;
		        int min = (a < b) ? a : b;
		        System.out.println("\nTernary Operator:");
		        System.out.println("Smaller number is: " + min);
		    }

	 // Method to demonstrate Operator Precedence
		    public static void operatorPrecedence() {
		        int result = 10 + 5 * 2;
		        System.out.println("\nOperator Precedence:");
		        System.out.println("10 + 5 * 2 = " + result); // Multiplication has higher precedence
		        System.out.println("(10 + 5) * 2 = " + ((10 + 5) * 2)); // Parentheses alter precedence
		    }

		    public static void main(String[] args) {
		        arithmeticOperators();
		        bitwiseOperators();
		        logicalOperators();
		        assignmentOperators();
		        ternaryOperator();
		        operatorPrecedence();
		    }
		}

/*
Bitwise AND Operator (&)
This operator returns 1 if both the operands are 1, otherwise, it returns 0.
Check out the below truth table for understanding the Bitwise AND Operator.
Let us consider two operands A and B that can only take the Binary Values 1 or 0.

| A | B | A & B |
|---|---|-------|
| 0 | 0 |   0   |
| 0 | 1 |   0   |
| 1 | 0 |   0   |
| 1 | 1 |   1   |

---

Bitwise OR Operator (|)
This operator returns 1 if either of the bits in the operand is 1, else it returns 0.
Below is the Truth Table for Bitwise OR Operator.

| A | B | A | B |
|---|---|-------|
| 0 | 0 |   0   |
| 0 | 1 |   1   |
| 1 | 0 |   1   |
| 1 | 1 |   1   |

---

Bitwise Complement Operator (~)
This operator inverts all of the bits of its operands. It is denoted by the symbol `~`.
However, this Bitwise Complement Operator in Java works with a single operand only, unlike others.

Example:
```
int a = 5;  // Binary: 0101
int result = ~a; // Binary: 1010 (2's complement representation)
```

---

Bitwise Exclusive OR Operator (^)
This operator returns 1 if the corresponding bits are different, else it returns 0.
If both the operands are 0 or both are 1, then the result is 0.

| A | B | A ^ B |
|---|---|-------|
| 0 | 0 |   0   |
| 0 | 1 |   1   |
| 1 | 0 |   1   |
| 1 | 1 |   0   |

---

Bitwise Left Shift (<<)
This means that the 1 in the ones place gets shifted to the left by the specified number of positions,
resulting in a new binary number.

Example:
```
int a = 5;  // Binary: 0101
int b = a << 2;  // Result: 10100 (equivalent to 5 * 2^2 = 20)
```
Note that the bitwise left shift operator can also be used to multiply an integer by a power of 2.

---

Bitwise Right Shift Zero Fill Operator (>>>)
This operator shifts bits to the right and fills the leftmost bits with 0 (for unsigned shift).

Example:
```
int a = -5;  // Binary: 1111...1011 (two's complement representation)
int b = a >>> 2; // Result: 0011...1110 (fills left bits with 0)
```

It is different from `>>` (arithmetic right shift) which maintains the sign bit during shifting.

 
*/
	
