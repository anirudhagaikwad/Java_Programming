package javaintro;

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

}//JavaOperators
