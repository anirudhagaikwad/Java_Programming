package oop;

/*
 * Within an instance variables,methods and constructor 'this' is a referance to the current object
 * We can access instance variables and instance methods using 'this' keyword
 * We can call constructor in another constructor using 'this' keyword within same class ,its called explicit constructor invocation
 * Constructor call must be the first statement in Constructor
 */

public class JavaThis {
	int x,y;
	float z;
	
	public JavaThis() {
		this.x=20;
	}//constructor 1
	
	public JavaThis(int y) {
		this(); // call constructor 1
		this.y=y;
	}//constructor 2
	
	public JavaThis(float z) {
		this(30);  // call constructor 2
		this.z=z;
	}//constructor 3

	public static void main(String[] args) {
		JavaThis obj=new JavaThis(); // call constructor 1
		JavaThis obj1=new JavaThis(5); //call constructor 2
		JavaThis obj2=new JavaThis(6.9F);//call constructor 3
		
		System.out.println("obj2.x : "+obj2.x); // 20
		System.out.println("obj2.y : "+obj2.y); // 30
		System.out.println("obj2.z : "+obj2.z); //6.9
		
		JavaThis obj3=obj.display();
		obj3.greetMe();
		
		

	}//main()
	
	void greet() {
		System.out.println("Hello..");
	}
	
	
	void greetMe() {
		this.greet(); // call instance method using 'this'
	}
	
	public JavaThis display() {
		return this; // return current object using 'this'
	}

}//JavaThis
