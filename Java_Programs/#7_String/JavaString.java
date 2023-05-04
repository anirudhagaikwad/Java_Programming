

/*
 * String is an object that represents sequence of characters, In java string is represented by String class
 * String class located into java.lang package
 * String object is immutable : once string object is created it cannot be change
 * Immutable Object : An object whose state cannot be changed after it created is known as an immutable object
 * String objects are stored in special memory area known as string constant pool inside the heap memory
 */

public class JavaString {
	
	void stringMethods() {
		
		String str1="Hello";    // create object using String literal
		System.out.println(str1);
		String str2=new String("hello"); // create object using new keyword
		String str3="hello";
		
// concat()
		String str4=str1.concat(str2);
		System.out.println("str1.concat(str2)  : "+str4);
		
// using + operator
		String str5=new String("Java");
		String str6=str1+str5;
		String str7=str6+123;
		System.out.println("str1+str5 : "+str6);
		System.out.println("str6+123 : "+str7);
		
// equal()   compares the content of the string
		boolean bool=str1.equals(str2);
		System.out.println("str1.equals(str2) : "+bool); //false
		
// ==  compares two object referances to check wheter they refer to same instance
		bool=(str1==str2);
		System.out.println("str1==str2 : "+bool);
		
// compareTo() compares values and return integer value which tells if the string compared is less-than,greater-then or equal to , it compares string based on natural ordering
// Its compare string given with the current string in lexicographical manner, Comapres are done on basis of unicode value of characters avilable in String	
	
		int a=str1.compareTo(str5);
		System.out.println("str1.compareTo(str5) : "+a);//-2
		int b=str2.compareTo(str3); 
		System.out.println("str2.compareTo(str3) : "+b); //0
		int c="h".compareTo("j"); 
		System.out.println("\"h\".compareTo(\"j\") : "+c); //-2
		int d="j".compareTo("h"); 
		System.out.println("\"j\".compareTo(\"h\") : "+d); //2
		
//charAt()
		System.out.println("str7.charAt(5) : "+str7.charAt(5) );
		
// equalsIgnoreCase()
		 bool=str1.equalsIgnoreCase(str2);
		System.out.println("str1.equalsIgnoreCase(str2) : "+bool); //true
		
//indexOf()
		System.out.println("str1.indexOf('l') : "+str1.indexOf('l'));
		
// lenght()
		System.out.println("str7.length() : "+str7.length());
		
// replace() 
		System.out.println(str7.replace('o', 'O'));
		
//subString()
		System.out.println(" str7.substring(5) : "+str7.substring(5));
		System.out.println(" str7.substring(3,8) : "+str7.substring(3,8));
		
		//Capitalize first letter form String
		System.out.println(" Capitalize first letter form String: "+str2.substring(0,1).toUpperCase()+str2.substring(1));
		
//toUpperCase()
		System.out.println("str2.toUpperCase() "+str2.toUpperCase());
		
//toLowerCase()
		System.out.println("JAVA.toLowerCase() "+"JAVA".toLowerCase());	
		
//valueOf()
		String str8=String.valueOf(bool);
		String str9=String.valueOf(123);
		System.out.println("String.valueOf(bool)"+str8.getClass().getName());
		System.out.println("String.valueOf(123)"+str9.getClass().getName());
		
//contains()
		bool=str8.contains("true");
		System.out.println("str8.contains(\"true\")"+bool);
		
//endWith()
		System.out.println("str7.endsWith(\"3\") : "+str7.endsWith("3"));
		
//startsWith()
		System.out.println("str7.startsWith(\"H\") : "+str7.startsWith("H"));
		System.out.println("str7.startsWith(\"3\") : "+str7.startsWith("3"));
		
//isEmpty()
		String str10="";
		System.out.println(" str10.isEmpty() : "+str10.isEmpty());
		System.out.println("str7.isEmpty() :  "+str7.isEmpty());
		String str11="   ";
		System.out.println("str11.isEmpty() :  "+str11.isEmpty());
		
//isBlank()
		System.out.println("str11.isBlank() :  "+str11.isBlank());
		
//join()
		String str12=String.join("/","18","April","2022");
		System.out.println("String.join(\"/\",\"18\",\"April\",\"2022\") : "+str12);
		
//getChars()  its used to copy the content of string into char array
		char[] chArray=new char[12];
		str7.getChars(0, 12, chArray, 0); // Argument 1 : start to copy from String , Argument 2 : dest. copy , Argument 3 : copy in array , Argument 4 :start index to copy from char array
		System.out.println(chArray);
		
		
//getBytes() its used to copy the content of string into byte array
		byte[] byteArray=str2.getBytes();
		for(int i=0;i<byteArray.length;i++) {
			System.out.println(byteArray[i]);
		}
	
}

	public static void main(String[] args) {
		JavaString obj=new JavaString();
		obj.stringMethods();

//toString() If you want to represent any object as a string, toString() method comes into existence
		System.out.println("ToString : "+obj.toString());//JavaString@277c0f21
        System.out.println("hashCode : "+obj.hashCode());// hashCode() method returns an integer representation of the hash code value of the JavaString object.
      
	}//main()
	
	

}//JavaString
