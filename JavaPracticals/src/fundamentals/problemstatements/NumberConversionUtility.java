package fundamentals.problemstatements;

/*
## Problem: Number Conversion Utility  
### Statement:  
Create a Java program using an interface that:  
- Converts a decimal number to binary, octal, and hexadecimal.  
- Implements separate conversion logic for each number system.
🔹 Concepts Used:  
- Interfaces for defining conversion rules  
- Mathematical number system conversions  
 
*/
public class NumberConversionUtility {

	public static void main(String[] args) {
		 NumberConverter converter = new Converter();
	        int number = 255;
	        System.out.println("Decimal: " + number);
	        System.out.println("Binary: " + converter.toBinary(number));
	        System.out.println("Octal: " + converter.toOctal(number));
	        System.out.println("Hexadecimal: " + converter.toHexadecimal(number));

	}

}

interface NumberConverter {
    String toBinary(int number);
    String toOctal(int number);
    String toHexadecimal(int number);
}

// Implementation class
class Converter implements NumberConverter {
    @Override
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    @Override
    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    @Override
    public String toHexadecimal(int number) {
        return Integer.toHexString(number).toUpperCase();
    }
}
