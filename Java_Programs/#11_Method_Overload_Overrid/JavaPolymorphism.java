package oop;


public class JavaPolymorphism {

	public static void main(String[] args) {
		MethodOveloding objMethodOveloding=new MethodOveloding();
		objMethodOveloding.addition();
		objMethodOveloding.addition(5, 10);
		objMethodOveloding.addition(5, 6, 9);
		objMethodOveloding.addition(9.4F,6.78F);
		objMethodOveloding.addition(458.35, 45.2F);
		
		MethodOverriding objMethodOverriding=new MethodOverriding();
		objMethodOverriding.addition(5, 2);

	}//main()

}//JavaPolymorphism


/*
 * Method Overloading is a concept that allows to declare multiple methods with same name but different parameters in same class.
 * Method Overloading is done by changing number of arguments or by changing the data type of arguments
 * If two or more methods have same name and same parameter list but differs in return type then it can not be overloaded
 */
class MethodOveloding{
	
	void addition() {
		int x=10;int y=20;
		System.out.println(x+"+"+y+"="+(x+y));
	}
		
	void addition(int x,int y) { // Method overloading by changing the data type of arguments
		System.out.println(x+"+"+y+"="+(x+y));
	}
	
	void addition(int x,int y,int z) { // Method overloading by changing the number of arguments
		System.out.println(x+"+"+y+"+"+z+"="+(x+y));
	}
	
	void addition(float x,float y) { // Method overloading by changing the data type of arguments
		System.out.println(x+"+"+y+"="+(x+y));
	}
	
/*	
	int addition() {
		int x=10;int y=20;
		System.out.println(x+"+"+y+"="+(x+y));
	}
*/
	
	String addition(double x,float y) { // Method overloading by changing the data type of arguments
		System.out.println(x+"+"+y+"="+(x+y));
		return "Method overloading by changing the data type of arguments";
	}
	
}//MethodOveloding



/*
 * Method Overriding performs only if two classes have IS-A relationship ,it means class must have inheritance
 * In Overriding method of both class must have same name and equal number of parameters
 * Method Overriding is also referred to as runtime polymorphism because calling method is decided by JVM during runtime
 * Private ,final and static methods cannot be overridden
 */
class MethodOverriding extends MethodOveloding{
	
	void addition(int x,int y) { // Method overriding --> override parent class method
		System.out.println("override parent class method...");
		System.out.println(x+"+"+y+"="+(x+y));
		
	}
	
}//MethodOverriding
