

/*
 * Operators are symbols that perform specific operation on one,two or three operands and then return result
 * ###########################################################
 *                                                  Operator Precedence
 *  ------------------------------------------------------------------------------------------------------------
 *                      Operator                                                Precedence
 *  ------------------------------------------------------------------------------------------------------------
 *                     Postfix                                                 expr++  expr-
 *                     Unary                                                  ++expr --expr +expr -expr ~ ! 
 *                     Multiplicative                                        * % /
 *                     additive                                               + -
 *                     shift                                                   << >> >>>
 *                     reational                                             < > <= >= instanceof
 *                     equality                                               == !=
 *                     bitwise AND                                         &
 *                     bitwise exclusive OR                             ^
 *                     bitwise inclusive OR                              |
 *                     logical AND                                         &&
 *                     logical OR                                           ||
 *                     ternary                                               ?:
 *                     assignment                                         = += -= /= %= &= ^= |= <<= >>= >>>=
 *                                         
 */

public class JavaOperators {

	public static void main(String[] args) {
		
// Assignment Operator
		int intVar=101;
		JavaOperators obj=new JavaOperators();
		
// Arithmetic Operators	
		int result =1+2 ;  // + Additive operator
		System.out.println("1 + 2 = "+result);
		int original_result=result;
		result=result-1; // - Substraction operator
		System.out.println(original_result+" - "+"1 = "+result);
		original_result=result;
		result=result*2; // * Multiplication operator
		System.out.println(original_result+" * "+" 2 = "+result);
		original_result=result;
		result=result/2; // / Division operator
		System.out.println(original_result+" / "+" 2 = "+result);
		original_result=result;
		result =result+8 ;  // + Additive operator
		System.out.println(original_result+" + "+" 8 = "+result);
		original_result=result;
		result=result%7; // % Reminder operator
		System.out.println(original_result+" % "+" 7 = "+result);
		
// Compound Assignments
		int x=0;
		x+=1;
		x=x+1; // both increment value of x by 1
		
// Concatenating operator
		String str="Hello Java";
		String str2=str+"Hi";
		System.out.println("Hi"+str);
		
// Unary Operators
		int unaryResult=+1; // + unary plus operator 
		System.out.println(unaryResult);
		unaryResult--; // -- Decrement operator 
		System.out.println("unaryResult--  "+unaryResult);
		unaryResult++; // ++ Increment operator 
		System.out.println("unaryResult++  "+unaryResult);
		unaryResult=-unaryResult; // + unary minus operator 
		System.out.println(unaryResult);
		boolean sucess=false;
		System.out.println(sucess); // false
		System.out.println(!sucess); // true   // ! Logical complement operator ,inverts the value of boolean 
		
/* Prefix and Postfix  - The code postfix++ & ++prefix will both end result being incremented by one
 *                             the only difference is that the prefix evalutes to the increment value and postfix evalutes to the original value
 */
		int i=3;
		i++; // postfix
		System.out.println(i); //4
		++i; // prefix;
		System.out.println(i); //5
		System.out.println(++i); // 6
		System.out.println(i++); // 6
		System.out.println(i); //7
		
// Equality Operator and Relational Operator
		int val1=1;int val2=2;
		if(val1==val2) {System.out.println("val1==val2");} // == equal to operator
		if(val1!=val2) {System.out.println("val1!=val2");} // != not-equal to operator
		if(val1>val2) {System.out.println("val1>val2");} // > greter than operator
		if(val1<val2) {System.out.println("val1<val2");} // < less than operator
		if(val1>=val2) {System.out.println("val1>=val2");} // >= greter than or equal to operator
		if(val1<=val2) {System.out.println("val1<=val2");} // <= less than or equal to operator
		
	
// Conditional operator
		if((val1==1)&&(val2==2)) {System.out.println("val1 is 1 AND val2 is 2");} // && conditional-AND operator
		if((val1==1)||(val2==1)) {System.out.println("val1 is 1 OR val2 is 1");} // || conditional-OR operator
		
		boolean someCondition=true;
		int res=someCondition?val1:val2;  // ?: ternary operator
		
// Type Comparison operator
		Integer intObj=Integer.valueOf(val2);
		Float floatObj=Float.valueOf(res);
		System.out.println("intObj instanceof Integer : "+(intObj instanceof Integer));
		System.out.println("floatObj instanceof Float : "+(floatObj instanceof Float));
		

/*
 * Bitwise and BitShift operator
 *  ############################################################
 *            Operator                                  Name
 *     -------------------------------------------------------------------------
 *               &                                    Bitwise AND
 *               |                                     Bitwise OR
 *              ^                                    Bitwise exclusive OR
 *              <<                                 Left Shift
 *              >>                                 Right Shift
 *               ~                                   Unary bitwise complement ioerator		
 *              >>>                                Unsigned right shift
 */
		
		int bitmask=0x000F;
		int val3= 0x2222;
		System.out.println(val3 & bitmask); //2
		
		
		/*
		 *  a     b      a&b       a|b       a^b
		 *  --------------------------------------
		 *  0     0        0          0          0
		 *  0     1        0          1          1
		 *  1     0        0          1          1
		 *  1     1        1          1          0
		 * 		
		 */
				
				int a=50,b=25,c=0;
				c=a&b; System.out.println("a&b ="+c);
				c=a|b; System.out.println("a|b ="+c);
				c=a^b; System.out.println("a^b ="+c);
				c=~a; System.out.println("~a ="+c);
				c=a<<2; System.out.println("a<<2 ="+c);
				c=a>>2; System.out.println("a>>2 ="+c);
				c=a>>>2; System.out.println("a>>>2 ="+c); //Unsigned right shift operator		
		 
		
	}//main()
	
	void bitwiseAND() {
/*
 Bitwise AND Operator (&)
This operator returns 1 if both the operands are 1 or else it returns 0.

Check out the below truth table for understanding the Bitwise AND Operator. Let us consider two operands A and B that can only take the Binary Values 1 or 0.

A	B	A & B
0	0	0
0	1	0
1	0	0
1	1	1
 */
		int a = 12; // Binary representation: 1100
		int b = 9;  // Binary representation: 1001
		                              //AND = 1000
		int c = a & b; // Bitwise AND operation binary 1000 = decimal 8
		System.out.println(c); // Output: 8 (Binary representation: 1000)

	}
	
	void biwiseOR() {
/*
Bitwise OR Operator (|)
This operator returns 1 if either of the bits in the operand is 1, else it returns 0.

Below is the Truth Table for Bitwise OR Operator and you can learn the demonstration of the Bitwise OR Operator. Here A, B are Two Operands on which Bitwise OR Operation is performed.

A	B	A | B
0	0	0
0	1	1
1	0	1
1	1	1		
 */
		int a = 3;   // binary representation: 0011
		int b = 6;   // binary representation: 0110
		int c = a | b;  // binary representation: 0111 (7 in decimal)
		System.out.println(c); // Output: 7

	}
	
	void bitwiseComplement() {
/*
Bitwise Complement Operator(~)
This operator inverts all of the bits of its operands. It is denoted by the symbol ~. However, this Bitwise Complement Operator in Java works with a single operand only unlike others.		 
 */
		int a = 10; // Binary representation of 10 is 1010
		int b = ~a; // Binary representation of ~a is 0101 (complement of 1010)
		System.out.println(b); // Output: -11
	}
	
	void bitwiseEclusiveOR() {
/*
Bitwise Exclusive OR Operator (^)
This operator returns 1 if the corresponding bits are different, else it returns 0. If both the operators are 0 or if both of them are 1 then the result is 0.

Check out the below truth table to understand the Bitwise Exclusive OR Operator clearly. Let A and B be two operands that take the binary values i.e. 0 or 1.

A	B	A ^ B
0	0	0
0	1	1
1	0	1
1	1	0
	
		 1 1 0 1   (1101)
     XOR 1 0 1 0   (1010)
 --------------------------
         0 1 1 1   (0111)
 */
		int a = 13;     // binary 1101
		int b = 10;     // binary 1010
		int c = a ^ b;  // binary 0111 (decimal 7)
	}

	void bitwiseShiftLeft() {
/*
	This means that the 1 in the ones place gets shifted to the left by 2 positions,
	 resulting in the binary number 10100
Note that the bitwise left shift operator can also be used to multiply an 
integer by a power of 2. In the example above, shifting a to the left by 2 positions is equivalent 
to multiplying a by 2^2, which is equal to 4. 
Therefore, b is equal to a multiplied by 4.	 	
 */
		int a = 5;      // decimal representation of 5 in binary is 101
		int b = a << 2; // left shift a by 2 positions
		System.out.println(b); // Output: 20


	}
	
	void bitwiseShiftRight() {
/*
The bitwise right shift operator (>>), shifts the bits of the first operand to the right by the number of positions specified by the second operand. 
The leftmost bits are filled with zeros for a non-negative number and with ones for a negative number.		
 */
		int num = 12; // binary representation: 0000 1100
		int result = num >> 2; // shift 2 positions to the right
		System.out.println(result); // output: 3 (binary representation: 0000 0011)

	}
	
	void bitwiseShiftRightZeroFill() {
/*
The Shift Right Zero Fill Operator (>>>) is a bitwise operator in Java
that shifts the bits of a number to the right and fills the leftmost positions with zeros.		

The shift right zero fill operator is useful when we want to shift the
bits of an unsigned number to the right and ensure that the leftmost 
positions are filled with zeros. Without the zero fill, a regular 
shift right operation would fill the leftmost positions with the sign
bit, which could result in unexpected behavior when working with 
unsigned numbers.
 */
		int x = 12; // Binary representation: 00001100
		int y = x >>> 2; // Binary representation: 00000011 = 3

	}
}//JavaOperators
