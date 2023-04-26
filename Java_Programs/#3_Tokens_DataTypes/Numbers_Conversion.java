package fundamentals;

import java.util.Scanner;

public class Numbers_Conversion {
// using built-in method
	public static void binaryTodecimal(String bin) {
	int dec=Integer.parseInt(bin,2);
	System.out.println("Binary "+bin+" = "+dec+" Decimal");
	}
	
	public static void octalTodecimal(String octal) {
		int dec=Integer.parseInt(octal,8);
		System.out.println("Octal "+octal+" = "+dec+" Decimal");
		}
	
	public static void hexaTodecimal(String hexa) {
		int dec=Integer.parseInt(hexa,16);
		System.out.println("Hexadecimal "+hexa+" = "+dec+" Decimal");
		}
	
	public static void decimalTobinary(int dec) {
		String bin=Integer.toBinaryString(dec);
		System.out.println("Decimal "+dec+" = "+bin+" Binary");
		}
	
	public static void decimalTooctal(int dec) {
		String octal=Integer.toOctalString(dec);
		System.out.println("Decimal "+dec+" = "+octal+" Octal");
		}
	
	public static void decimalTohexadecimal(int dec) {
		String hexa=Integer.toHexString(dec);
		System.out.println("Decimal "+dec+" = "+hexa+" HexaDecimal");
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Binary : ");
		String var=sc.nextLine();
		
         
		int res=binToDec(var);
		System.out.println("Binary "+var+" = "+res+" Decimal");
		
		System.out.println("Enter Decimal : ");
		int dec=sc.nextInt();
	
		String binRes=decTobin(dec);
		System.out.println("Decimal "+dec+" = "+binRes+" Binary");
		sc.close(); // always close when scanner object not required 
	}
	
	public static int binToDec(String bin) {
		int dec=0,powr=0;
		for(int i=bin.length()-1;i>=0;i--) {
			if(bin.charAt(i)=='1') {
				dec+=Math.pow(2, powr);
			} powr++;
		} return dec;
	}
	
	public static String decTobin(int dec) {
		String bin="";
		while(dec>0) {
			int remidr=dec%2;
			bin=remidr+bin;
			dec=dec/2;
		}
		return bin;
	}

	
}//end class
