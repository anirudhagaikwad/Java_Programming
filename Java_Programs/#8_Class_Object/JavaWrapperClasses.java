package oop;

/*
 * In Java wrapper class is used for converting primitive data type into object and object into primitive data type.
 * For each primitive data type predefined class is present which is known as wrapper class
 * 
 * ##################################################################
 *  Primitive_Data_Type         Wrapper_ClassName                            Conversion_Methods
 * ##########################################################################################
 *     byte                                     Byte                               public ststic byte parseByte(String)
 *     short                                    Short                              public ststic short parseShort(String)
 *     int                                       Integer                           public ststic int parseInt(String)
 *     long                                     Long                              public ststic long parseLong(String)
 *     float                                      Float                            public ststic float parseFloat(String)
 *     double                                  Double                          public ststic double parseDouble(String)
 *     char                                    Character
 *     boolean                               Boolean  
 *#######################################################################################
 */
public class JavaWrapperClasses {
	

void numberClass() {
	
	 //* Number class is super class of all the numeric wrapper classes --> Byte,Short,Integer,Long,Float,Double
	Double d1=new Double(4.356);
	byte v=d1.byteValue();
	short s=d1.shortValue();
	int i=d1.intValue();
	long l=d1.longValue();
	float f=d1.floatValue();
	double d=d1.doubleValue();
	System.out.println("converting Double to byte : "+v);
	System.out.println("converting Double to short : "+s);
	System.out.println("converting Double to int : "+i);
	System.out.println("converting Double to long : "+l);
	System.out.println("converting Double to float : "+f);
	System.out.println("converting Double to double : "+d);
		 
}//numberClass() 


void integer_wrapperClass() {
	int a=100;
	Integer x=new Integer(a);
	System.out.println("toString(a) : "+Integer.toString(a)); // toString() is used to get a string representation of the integer argument as an signed integer in base 10
	System.out.println("toHexString(a) : "+Integer.toHexString(a)); // toHexString() is used to get a string representation of the integer argument as an unsigned integer in base 16
	System.out.println("toOctalString(a) : "+Integer.toOctalString(a)); // toOctalString() is used to get a string representation of the integer argument as an unsigned integer in base 8
	System.out.println("toBinaryString(a) : "+Integer.toBinaryString(a)); // toBinaryString() is used to get a string representation of the integer argument as an unsigned integer in base 2
	Integer xx=Integer.valueOf(a); // valueOf() used to get an Integer object representing the specified int value
	String str="505";
	Integer s=Integer.parseInt(str);
	System.out.println("parseInt(str) : "+s.getClass().getName());
	
	String ss="sun.arch.data.model"; //sun.arch.data.model is the Java System property which determines the version of the JVM is used - 32 or 64bit.
	
	int aa=Integer.getInteger(ss);
	System.out.println("getInteger(sun.arch.data.model) : "+aa);
	// aa=Integer.getInteger("Hello"); // null
}


void long_wrapperClass() {
	long a=100;
	Long x=new Long(a);
	System.out.println("toString(a) : "+Long.toString(a)); // toString() is used to get a string representation of the long argument as an signed Long in base 10
	System.out.println("toHexString(a) : "+Long.toHexString(a)); // toHexString() is used to get a string representation of the long argument as an unsigned Long in base 16
	System.out.println("toOctalString(a) : "+Long.toOctalString(a)); // toOctalString() is used to get a string representation of the long argument as an unsigned Long in base 8
	System.out.println("toBinaryString(a) : "+Long.toBinaryString(a)); // toBinaryString() is used to get a string representation of the long argument as an unsigned Long in base 2
	Long xx=Long.valueOf(a); // valueOf() used to get an Long object representing the specified long value
	String str="505";
	Long s=Long.parseLong(str);
	System.out.println("parseLong(str) : "+s.getClass().getName());
}


void short_wrapperClass() {
	short a=100;
	Short x=new Short(a);
	System.out.println("toString(a) : "+Short.toString(a)); // toString() is used to get a string representation of the short argument as an signed Short in base 10
	Short xx=Short.valueOf(a); // valueOf() used to get an Short object representing the specified short value
	String str="505";
	Short s=Short.parseShort(str);
	System.out.println("parseShort(str) : "+s.getClass().getName());
}


void byte_wrapperClass() {
	byte a=100;
	Byte x=new Byte(a);
	System.out.println("toString(a) : "+Byte.toString(a)); // toString() is used to get a string representation of the byte argument as an signed Byte in base 10
	Byte xx=Byte.valueOf(a); // valueOf() used to get an Byte object representing the specified byte value
	String str="125";
	Byte s=Byte.parseByte(str);
	System.out.println("parseByte(str) : "+s.getClass().getName());
}


void float_wrapperClass() {
	float a=101.65F;
	Float x=new Float(a);
	System.out.println("toString(a) : "+Float.toString(a)); // toString() is used to get a string representation of the float argument as an signed Float in base 10
	Float xx=Float.valueOf(a); // valueOf() used to get an Float object representing the specified float value
	String str="505.68";
	Float s=Float.parseFloat(str);
	System.out.println("parseFloat(str) : "+s.getClass().getName());
}


void double_wrapperClass() {
	double a=101.65;
	Double x=new Double(a);
	System.out.println("toString(a) : "+Double.toString(a)); // toString() is used to get a string representation of the double argument as an signed Double in base 10
	Double xx=Double.valueOf(a); // valueOf() used to get an Double object representing the specified double value
	String str="505.658";
	Double s=Double.parseDouble(str);
	System.out.println("parseDouble(str) : "+s.getClass().getName());
}
	
	

	public static void main(String[] args) {
		JavaWrapperClasses obj=new JavaWrapperClasses();
		obj.numberClass();
		obj.integer_wrapperClass();
		obj.long_wrapperClass();
		obj.short_wrapperClass();
		obj.byte_wrapperClass();
		obj.float_wrapperClass();
		obj.double_wrapperClass();
		obj.boolean_wrapperClass();
		obj.character_wrapperClass();
		


	}//main()
	
	
	void boolean_wrapperClass() {
		boolean obj1=Boolean.parseBoolean("True"); //true
		boolean obj2=Boolean.parseBoolean("False"); //false
		boolean obj3=Boolean.parseBoolean("HelloHowru"); //false
		
		System.out.println("obj1 :"+obj1);
		System.out.println("obj2 :"+obj2);
		System.out.println("obj3 :"+obj3);
		
		
		Boolean obj4=new Boolean(obj1);
		Boolean obj5=new Boolean(obj2);
		
		boolean obj6=obj4.booleanValue();
		boolean obj7=obj5.booleanValue();
		System.out.println("obj6 :"+obj6);
		System.out.println("obj7 :"+obj7);
		
		Boolean obj8=Boolean.valueOf(obj1);
		System.out.println("obj8 :"+obj8);
		System.out.println("toString(obj3) : "+Boolean.toString(obj3)); 
	
	}
	
	
	
	void character_wrapperClass() {
		System.out.println("Character.isLetter('A') :"+Character.isLetter('A'));
		System.out.println("Character.isLetter('2') :"+Character.isLetter('2'));
		System.out.println("Character.isDigit('A') :"+Character.isDigit('A'));
		System.out.println("Character.isDigit('5') :"+Character.isDigit('5'));
		System.out.println("Character.isWhitespace(' ') :"+Character.isWhitespace(' '));
		System.out.println("Character.isUpperCase('5') :"+Character.isUpperCase('5'));
		System.out.println("Character.isUpperCase('A') :"+Character.isUpperCase('A'));
		System.out.println("Character.isLowerCase('A') :"+Character.isLowerCase('A'));
		System.out.println("Character.isLowerCase('b') :"+Character.isLowerCase('b'));
		System.out.println("Character.toUpperCase('b') :"+Character.toUpperCase('b'));
		System.out.println("Character.toLowerCase('D') :"+Character.toLowerCase('D'));
		System.out.println("Character.toString('D') :"+Character.toString('D'));		
		System.out.println("Character.charCount(0x9001) :"+Character.charCount(0x9001));
		
		Character obj=new Character('x');
		char ch=obj.charValue();
		
	}
	

}//JavaWrapperClasses
