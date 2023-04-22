package oop;

/*
 * OOP : Object Oriented Programming is approach which provides solution to real life problems with the help of algorithms based on real world.
 *          OOP is paradigm - A programming paradigm is the classification, style or way of programming. It is an approach to solve problems by using programming languages.
 *                    
 * Class : Class defined as a template that describe the behaviours(methods) and states(variables) of perticular entity.
 *            In class there are Instance Variables and Methods its called Class Members
 *            Class also called blueprint of an object
 * 
 * Object : Its is instance of class ,Its also called real-time entity
 *             Object represent the class and its properties and behavior
 */

public class JavaClasses {

	public static void main(String[] args) {
	
		MathOperation objMathOperation=new MathOperation();
		System.out.println(objMathOperation);
		objMathOperation.methodFromMathOperation();
		
		System.out.println(" ");
		
		MathOperation.ArithmeticOperation objArithmeticOperation=objMathOperation.new ArithmeticOperation();
		System.out.println(objArithmeticOperation);
		objArithmeticOperation.methodFromArithmeticOperation();
		
		System.out.println(" ");
		
		MathOperation.ArithmeticOperation.AddOperation objAddOperation=objArithmeticOperation.new AddOperation();
		objAddOperation.addition();
		objAddOperation.accessArithmeticOperationClass_Members();
		objAddOperation.accessMathOperationClass_Members();
		
		System.out.println(" ");
		
		MathOperation.ArithmeticOperation.SubstractOperation objSubstractionOperation =objArithmeticOperation.new SubstractOperation();
		objSubstractionOperation.substraction();
		objSubstractionOperation.accessArithmeticOperationClass_Members();
		objSubstractionOperation.accessMathOperationClass_Members();
		
		System.out.println(" ");
		
		MathOperation.ArithmeticOperation.MultipliOperation objMultipliOperation=objArithmeticOperation.new MultipliOperation();
		objMultipliOperation.multiplication();
		objMultipliOperation.accessArithmeticOperationClass_Members();
		objMultipliOperation.accessMathOperationClass_Members();
		
		System.out.println(" ");
		
		AnonymousTest objAnonymousTest=new AnonymousTest();
		objAnonymousTest.methodFromAnonymousTest();
		
		System.out.println(" ");
		
		LocalClassExample objLocalClassExample =new LocalClassExample();
		objLocalClassExample.validatePhoneNumber("9158888605","123456");

	}//main()

}//JavaClasses




/* Nested Class : A class defined within another class is known as nested class 
 *                      Nested class enables you to logically group classes that are use in only one place
 *                      Its increases the use of encapsulation and create more readable,maintainable code                       
*/

class MathOperation{
	
	String str1="Its MathOperation Class....";
	int a=10;
	
	public String toString() {
		return str1;
	}
	
	void methodFromMathOperation() {
		System.out.println(str1+" Method....");	}
	
	
	class ArithmeticOperation{
		
		String str="Its ArithmeticOperation Class....";
		int b=20;
		
		public String toString() {
			return str;
		}
		
		void methodFromArithmeticOperation() {
			System.out.println(str+" Method....");	}
		
		class AddOperation{
			
			void addition() {
				System.out.println("Addition from filed MathOperation Class + ArithmeticOperation Class");
				System.out.println(a+"+"+b+"="+(a+b));
			}
			
			void accessMathOperationClass_Members() {
				System.out.println("Direct access MathOperation Class Variable inside AddOperation Class  : "+str1);
				System.out.println("Direct access MathOperation Class Method inside AddOperation Class  :  "+new MathOperation());
				methodFromMathOperation();			
			}
			
			void accessArithmeticOperationClass_Members() {
				System.out.println("Direct access ArithmeticOperation Class Variable inside AddOperation Class  : "+str);
				System.out.println("Direct access ArithmeticOperation Class Method inside AddOperation Class  :  "+new ArithmeticOperation());
				methodFromArithmeticOperation();			
			}
			
		}//AddOperation // inner class of ArithmeticOperation
		
		class SubstractOperation{
			void substraction() {
				System.out.println("Substraction from filed MathOperation Class + ArithmeticOperation Class");
				System.out.println(a+"-"+b+"="+(a-b));
			}
			
			void accessMathOperationClass_Members() {
				System.out.println("Direct access MathOperation Class Variable inside SubstractOperation Class  : "+str1);
				System.out.println("Direct access MathOperation Class Method inside SubstractOperation Class  :  "+new MathOperation());
				methodFromMathOperation();			
			}
			
			void accessArithmeticOperationClass_Members() {
				System.out.println("Direct access ArithmeticOperation Class Variable inside SubstractOperation Class  : "+str);
				System.out.println("Direct access ArithmeticOperation Class Method inside SubstractOperation Class  :  "+new ArithmeticOperation());
				methodFromArithmeticOperation();			
			}
		}//SubstractOperation // inner class of ArithmeticOperation
		
		
		class MultipliOperation{
			void multiplication() {
				System.out.println("Multiplication from filed MathOperation Class + ArithmeticOperation Class");
				System.out.println(a+"x"+b+"="+(a*b));
			}
			
			void accessMathOperationClass_Members() {
				System.out.println("Direct access MathOperation Class Variable inside MultipliOperation Class  : "+str1);
				System.out.println("Direct access MathOperation Class Method inside MultipliOperation Class  :  "+new MathOperation());
				methodFromMathOperation();			
			}
			
			void accessArithmeticOperationClass_Members() {
				System.out.println("Direct access ArithmeticOperation Class Variable inside MultipliOperation Class  : "+str);
				System.out.println("Direct access ArithmeticOperation Class Method inside MultipliOperation Class  :  "+new ArithmeticOperation());
				methodFromArithmeticOperation();			
			}
		}//MultipliOperation // inner class of ArithmeticOperation
			
	}//ArithmeticOperation // inner class of MathOperation class & outer class of SubstractOperation,MultipliOperation,AddOperation class
	
}//MathOperation //outer class of  ArithmeticOperation class




/*
 * Anonymous Class : A class without any name is called Anonymous Class
 *                            Anonymous Class enables you to make your code more concise
*/

interface CalOperation{
	void mathOperationType();
} // interface

class AnonymousTest{
	
	void methodFromAnonymousTest() {
		CalOperation cObj=new CalOperation() // Anonymous class create
				{
						public void mathOperationType() {
							System.out.println("Implemented Method from Interface inside Anonymous Class...");
						}
				};
				
				cObj.mathOperationType();
		
	}//methodFromAnonymousTest()
	
}//AnonymousTest




/* Local Class : You can define Local Class inside block ... inside method*/

class LocalClassExample{
	
	String regularExpression="[^0-9]";
	
	public void validatePhoneNumber(String phoneNumber1,String phoneNumber2) {
		
		final int numLenght=10;
		
		class PhoneNumber{
			String formattedPhoneNumber=null;
			public PhoneNumber(String phoneNumber) {
				
				String currentNumber=phoneNumber.replaceAll(regularExpression," ");
				if(currentNumber.length()==numLenght) {
					formattedPhoneNumber=currentNumber;
				}// if end
				else {formattedPhoneNumber=null;}
			}// constructor PhoneNumber
			
			public String getNumber() {
				return formattedPhoneNumber;
			}//getNumber()
			
			public void printOriginalNumber() {
				System.out.println("Original Numbers are  "+phoneNumber1+" and "+phoneNumber2);
			}//rintOriginalNumber()
			
		}//Local class PhoneNumber
		
		PhoneNumber obj1=new PhoneNumber(phoneNumber1);
		PhoneNumber obj2=new PhoneNumber(phoneNumber2);
		
		obj1.printOriginalNumber();
		 
		if(obj1.getNumber()==null) {System.out.println("Number 1 is Invalid.... ");}
		else {System.out.println("Number 1 is Valid.... ");}
		
		if(obj2.getNumber()==null) {System.out.println("Number 2 is Invalid.... ");}
		else {System.out.println("Number 2 is Valid.... ");}
		
	}//validatePhoneNumber()
	
}//LocalClassExample


























