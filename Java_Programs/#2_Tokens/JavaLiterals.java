package javaintro;

/*
 * Literals are numbers,text or anything that represent a value.
 * Types of Literal : Integral Literals , Floting-Point Literals,Character Literals,String Literals,Boolean Literals
 */
public class JavaLiterals {

	public static void main(String[] args) {

// Integral Literals 
		int decimalVar=101; // Decimal Literals Base 10 , Digits from 0-9 are allowed 
		int octalVar=0146; // Octal Literals Base 8 , Digits from 0-7 are allowed,It should always have prefix 0
		int hexaVar=0x123Face; // HexaDecimal Base 16 , Digits from 0-9 are allowed and also characters from 'a' to 'f' ,It should always have prefix 0x
		int binVar=0b1111; // Binary Literals Base 2 , Digits from 0-1 are allowed,It should always have prefix 0b
		int byteVar= 125; // Byte Literals
		int shortVar=12365;//Short Literals
		int intVar=4698752;//Integer Literals
		
// Floating Point Literals
		float folatVar=55.8F; // Float Literals - Every floting point type is double type and this the resone why we canont assign it directly to float variable

		double doubleVar=97.4; // Double Literal
		
// Char Literals
		char charVar='A'; // Character Literal  0 to 65535 Unicode
		char charUnicodeVar='\u0061'; // A Char literal can specify in Unicode representation ; '\u0061' --> here 0061 represent hexadecimal number 

		char charEscapSeqVar='\n'; // Escape Sequences char literals
		
		System.out.println("0 in marathi : "+"\u0966");
		System.out.println("1 in marathi : "+"\u0967");
		
// String Literals
		String str="Hello Java"; // // String Literals are any sequence of characters with a double quote

		
// Boolean Literals
		boolean bVar=true; // Boolean Literals only allow two values i.e. true and false
	}//main()

}//JavaLiterals
