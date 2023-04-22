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
	
//Number Super Class
	void numberClassMethods() {
		Float f1=Float.valueOf(5.5f); // create Float wrapper class object
		System.out.println("Float Object : "+f1);
		byte byteVar=f1.byteValue();
		System.out.println("Float Object converted in byte primitive type: "+byteVar);
		short shortVar=f1.shortValue();
		System.out.println("Float Object converted in short primitive type: "+shortVar);
		int intVar=f1.intValue();
		System.out.println("Float Object converted in int primitive type: "+intVar);
		long longVar=f1.longValue();
		System.out.println("Float Object converted in long primitive type: "+longVar);
		float floatVar=f1.floatValue();
		System.out.println("Float Object converted in float primitive type: "+floatVar);
		double doubleVar=f1.doubleValue();
		System.out.println("Float Object converted in double primitive type: "+doubleVar);
	}
	
//Integer Wrapper Class
	void intergerWrapperClassMethods() {
		Integer obj=Integer.valueOf(5); // create wrapper class object
		int x=obj.intValue();
		System.out.println("toString(x) : "+Integer.toString(x));
		System.out.println("toHexString(x) : "+Integer.toHexString(x));
		System.out.println("toOctalString(x) : "+Integer.toOctalString(x));
		System.out.println("toBinaryString(x) : "+Integer.toBinaryString(x));
		String y="65";
		Integer obj1=Integer.parseInt(y);
		System.out.println("obj1=Integer.parseInt(65) : "+obj1);
		Integer obj2=Integer.decode(y);
	}
//Long Wrapper Class
	void longWrapperClassMethods() {
		Long obj=Long.valueOf(15);
		long x=obj.longValue();
		System.out.println("toString(x) : "+Long.toString(x));
		System.out.println("toHexString(x) : "+Long.toHexString(x));
		System.out.println("toOctalString(x) : "+Long.toOctalString(x));
		System.out.println("toBinaryString(x) : "+Long.toBinaryString(x));
		String y="66";
		Long obj1=Long.parseLong(y);
		System.out.println("obj1=Integer.parseInt(66) : "+obj1);
		Long obj2=Long.decode(y);
		System.out.println("decode(66) : "+obj2);
	}
//Sort Wrapper Class
	void shortWrapperClass() {
		short x=9;
		Short obj=Short.valueOf(x);
		System.out.println("toString(x) : "+Short.toString(x));
		//System.out.println("toHexString(x) : "+Short.toHexString(x));
		//System.out.println("toOctalString(x) : "+Short.toOctalString(x));
		//System.out.println("toBinaryString(x) : "+Short.toBinaryString(x));
		String y="67";
		Short obj1=Short.parseShort(y);
		System.out.println("parseShort(67) : "+obj1);
		Short obj2=Short.decode(y);
		System.out.println("decode(y) : "+obj2);
	}
	
//Byte Wrapper Class
	void byteWrapperClass() {
		byte x=88;
		Byte obj=Byte.valueOf(x);
		System.out.println("toString(x) : "+Byte.toString(x));
		//System.out.println("toHexString(x) : "+Byte.toHexString(x));
		//System.out.println("toOctalString(x) : "+Byte.toOctalString(x));
		//System.out.println("toBinaryString(x) : "+Byte.toBinaryString(x));
		String y="68";
		Byte obj2=Byte.parseByte(y);
		System.out.println("parseByte(68) : "+obj2);
		Byte obj3=Byte.decode(y);
		System.out.println("decode(68) : "+obj3);
	}

//Float Wrapper Class
	void floatWrapperClass() {
		Float obj=Float.valueOf(5.6f);
		float x=obj.floatValue();
		System.out.println("toString(x) :"+Float.toString(x));
		System.out.println("toHexString(x) : "+Float.toHexString(x));
		//System.out.println("toOctalString(x) : "+Float.toOctalString(x));
		//System.out.println("toBinaryString(x) : "+Float.toBinaryString(x));
		Float obj2=Float.parseFloat("55");
		
	}
	
	//Double Wrapper Class
		void doubleWrapperClassMethods() {
			Double obj=Double.valueOf(68.5);
			double x=obj.doubleValue();
			//System.out.println("toString(x) :"+Float.toString(x));
			//System.out.println("toHexString(x) : "+Float.toHexString(x));
			//System.out.println("toOctalString(x) : "+Float.toOctalString(x));
			//System.out.println("toBinaryString(x) : "+Float.toBinaryString(x));
			Double obj1=Double.parseDouble("66");
			System.out.println("parseDouble(\"66\") : "+obj1);
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer iobj=new Integer(55);
		Integer iObj=Integer.valueOf(55);
		System.out.println("Old Value :"+iObj);
        changeValue(iObj);
        System.out.println("New Value : "+iObj);
        
        JavaWrapperClasses obj=new JavaWrapperClasses();
        obj.numberClassMethods();
        obj.intergerWrapperClassMethods();
        obj.longWrapperClassMethods();
        obj.shortWrapperClass();
        obj.byteWrapperClass();
        obj.floatWrapperClass();
        obj.doubleWrapperClassMethods();
        obj.characterWrapperClass();
        obj.booleanWrapperClass();
	}
	
	
	private static void changeValue(Integer iObj) {
		/*
		 * All primitive wrapper classes are immutable ,when new object is created
		 * the old object is not modified.
		 */
		iObj=iObj+15;
	}//changeValue

//Character Wrapper Class
	void characterWrapperClass() {
		Character obj=Character.valueOf('A');
		char x=obj.charValue();
		System.out.println("Character.isLetter('A') : "+Character.isLetter(x));
		System.out.println("Character.isDigit('5') : "+Character.isDigit('5'));
		System.out.println("Character.isWhitespace(' ') : "+Character.isWhitespace(' '));
		System.out.println("Character.isUpperCase('c') : "+Character.isUpperCase('c'));
		System.out.println("Character.isLowerCase('c') : "+Character.isLowerCase('c'));
		System.out.println("Character.toUpperCase('a') : "+Character.toUpperCase('a'));
		System.out.println("Character.toLowerCase('a') : "+Character.toLowerCase('A'));
		System.out.println("Character.toString('W') : "+Character.toString('W'));
		System.out.println("Character.isAlphabetic('@') : "+Character.isAlphabetic('@'));
	
	}
	
//Boolean Wrapper Class
	void booleanWrapperClass() {
		Boolean obj=Boolean.valueOf(false);
		boolean x=obj.booleanValue();
		System.out.println("Boolean.toString(x) : "+Boolean.toString(x));
	}
}