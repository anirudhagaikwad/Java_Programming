package oop;

/*
 * Interface support multiple inheritance
 * It can be used to achieve loose coupling and abstraction
 * All methods declared inside interface are implicitly public and abstract
 * All variables declared inside interface are implicitly public,final & static
 * Interface can not be initiate
 * Inheritance of interface use extends keyword
 * To implement interface in class use implements keyword
 * Interface also have default,static,private method with body
 * default and static methods available from java 8
 * private method available from java 9
 */
public class JavaInterface {

	public static void main(String[] args) {
		XYZBank objXYZBank =new XYZBank();
		objXYZBank.simpleIntrestAbstractMethod(1500000, 20);
		
		ABCBank objABCBank=new ABCBank();
		objABCBank.defaultMethod_Interest(); // call default method from interface Interest
		objABCBank.compoundInterestAbstractMethod(500000,5, 3);
		objABCBank.simpleIntrestAbstractMethod(800000, 5);
		objABCBank.staticMethodCall();

	}//main()

}//JavaInterface


interface SimpleInterest{
	double HOME_INTREST_RATE=8;
	double VEHICLE_INTREST_RATE=11;
	double PERSONAL_INTREST_RATE=15;
	
// abstract method - implicitly public and abstract
	void simpleIntrestAbstractMethod(double principal,double time);
}//interface SimpleInterest


class XYZBank implements SimpleInterest{
	public void simpleIntrestAbstractMethod(double principal,double time) {
		double simpleIntrest=(principal*HOME_INTREST_RATE*time)/100;
		System.out.println("Home Loan from XYZBank");
		System.out.println("Principal Amount : "+principal);
		System.out.println("Home Loan Interest rate per year :  "+HOME_INTREST_RATE);
        System.out.println("Loan Duration : "+time);
        System.out.println("Simple Interest = "+simpleIntrest);
	}// implemented abstract method
	
}//XYZBank


interface CompoundInterest{
	// abstract method - implicitly public and abstract	
	void compoundInterestAbstractMethod(double principal,double time,int n);
}//interface CompoundInterest

interface Interest extends SimpleInterest,CompoundInterest{
// private method
	private void privateMethod_Interest() {
		System.out.println("Its Private Method from Interface");
	}
	
//static method
	static void staticMethod_Interest() {
		System.out.println("Its Static Method from Interface");
	}
	
// default method
	default void defaultMethod_Interest() {
		System.out.println("Its Default Method from Interface");
		privateMethod_Interest(); // call private method
	}
}//interface Interest

class ABCBank implements Interest{
	public void simpleIntrestAbstractMethod(double principal,double time) {
		double simpleIntrest=(principal*VEHICLE_INTREST_RATE*time)/100;
		System.out.println("Vehicle Loan from ABCBank");
		System.out.println("Principal Amount : "+principal);
		System.out.println("Home Loan Interest rate per year :  "+VEHICLE_INTREST_RATE);
        System.out.println("Loan Duration : "+time);
        System.out.println("Simple Interest = "+simpleIntrest);
	}// implemented SimpleInterest abstract method 
	
	
	public void compoundInterestAbstractMethod(double principal,double time,int n) {
		double compoundInterest=(principal*Math.pow(1+(VEHICLE_INTREST_RATE/ n),n*time));
		System.out.println("Vehicle Loan from ABCBank");
		System.out.println("Principal Amount : "+principal);
		System.out.println("Home Loan Interest rate per year :  "+VEHICLE_INTREST_RATE);
        System.out.println("Loan Duration : "+time);
        System.out.println("Number of time that interest compounded : "+n);
        System.out.println("compound Interest : "+compoundInterest);
		
	}// implemented CompoundInterest abstract method 
	
	void staticMethodCall() {
		Interest.staticMethod_Interest(); // call static method from interface Interest
	}
	
}//ABCBank

