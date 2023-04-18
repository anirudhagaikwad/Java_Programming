package oop;

/*
 *   Inheritance provided mechanism that allowed a class to inherit property of another class
 *   When a class extends another class it inherits all non-private members including fields ands methods.
 *   Parent Class also known Super Class or Base Class
 *   Child Class also known derived class or sub class 
 *   Super Keyword  : super keyword is used to refer to immediate parent class of a child class.
 *                           It is used to access Parent Class Members and Constructors
 *                           
 *                           When calling the parent class constructor from the child class using super keyword, 
 *                           super keyword should always be the first line in the method/constructor of the child class.
 *                           
 *   IS-A Relationship : Its depends on Inheritance ,when there is extends or implements keyword in the class decleration in java 
 *                              then the specific class said to be following the IS-A Relationship 
 *                              
 *  Java mainly supports only three types of inheritance that are listed below.
   --> Single Inheritance
   --> Multilevel Inheritance
   --> Heirarchical Inheritance
                             
 *   
*/

public class JavaInheritance  {

	public static void main(String[] args) {
		
		CircleShape objCircleShape=new CircleShape();
		objCircleShape.area(3.5);
		
		Coin objCoin=new Coin();
		objCoin.area(1.5);
		
		RectangleShape objRectangleShape=new RectangleShape();
		objRectangleShape.accessParentClassMembers();
		objRectangleShape.area(6.89, 5.6);
		
		TriangleShape objTriangleShape=new TriangleShape();
		objTriangleShape.area(55.3, 105.98);
		objTriangleShape.display(); // call parent class method using child class object
		

	}//main()

}//JavaInheritance


// Parent Class / Super Class / Base Class
class  Shape{
	
	double PI_VAL=3.14;
	
	void display() {
		System.out.println("PI Value = "+PI_VAL);
	}
	
	public Shape() {
		System.out.println("Constructor from Shape Class...");
	}//constructor
	
	
	
		
}//Shape


/*  Single Inheritance : Its define IS-A relationship between a Super Class and Sub Class 
                                 When a class extends to another class then it forms to single inheritance. 
*/

class CircleShape extends Shape{
	
	void area(double radius) {
		// A=pi(r*r)
		double areaCircle=PI_VAL*(radius*radius);
		System.out.println("Circle area = "+areaCircle);
	}

	public CircleShape() {
			super();
		
	}
	
	
	
}//CircleShape


/*
 * MultiLevel Inheritance : When a class extends to another class, that child class also extends some other class  then it forms of multilevel inheritance
*/

class Coin extends CircleShape{
	
	void area(double radius) {
		// radius = 1.15 cm 
		double areaCircle=PI_VAL*(radius*radius);
		System.out.println("10 RS Coin Area = "+areaCircle);
	}
	
}//Coin


/*
 * Hierarchical Inheritance : When a class extended by two or more classes then it forms of Hierarchical Inheritance
*/


class RectangleShape extends Shape{
	void area(double length,double breadth) {
		//Area of a Rectangle Is Length � Breadth
		double areaRectangle=length*breadth;
		System.out.println(" Area of RectangleShape = "+areaRectangle);
	}
	
	void accessParentClassMembers() {
		
		super.display(); // call parent class method using super
		double pi=PI_VAL; // access parent class fileds using super
	}
	
	public RectangleShape() {
		super(); // Constructor call using super must be the first statement in Constructor
		System.out.println("Constructor from RectangleShape Class...");
		
	}
	
}//RectangleShape


class TriangleShape extends Shape{
	void area(double base,double height) {
		// A = 1/2 � b � h.
		double areaTriangle=(base*height)/2;
	}
}//TriangleShape



