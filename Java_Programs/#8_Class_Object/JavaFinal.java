package oop;

/*
 * Final modifier is use to declared class,variable,method as final that means constant 
 * When declared variable is final then its prevents its content from being modified, final variable must be initialize when it is declared
 *  When declared class is final then its prevents it from being inherited
 *   When declared method is final its prevents it from being overridden
 */
public class JavaFinal {
 
	final int x=10;
	
	final int y;
	
	public JavaFinal(int y) {
		this.y=y;
	}
	
	public static void main(String[] args) {
		JavaFinal obj=new JavaFinal(20);
		System.out.println("Final int x = "+obj.x);
		//obj.x=60;
		System.out.println("Final int y = "+obj.y);

	}//main()
	
	final void display() {
		System.out.println("Its Final Method.....");
	}
	


}//JavaFinal


final class ChildClass extends JavaFinal{

	public ChildClass(int y) {
		super(y);
		}//constructor
	
/*	 void display() {
		System.out.println("Its Final Method.....");
	}
	
*/
	
}//ChildClass


/*
class ChildChildClass extends ChildClass{
	
}
*/

