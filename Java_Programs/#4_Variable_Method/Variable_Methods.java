package fundamentals;


/*
 * Instance Variable : Declare inside class but outside any method and declare without static keyword
 * 					   Instance variable is also called object variable
 * 					   Each object has its own copy of instance variable
 * 					   It doesn't effect the instance variable if any object changes value of variable.		
 * 	
 * Static Variable / Class Variable  : Declare inside class but outside any method and Its allocate memory once and its declare with static keyword
 * 
 * Local Variable : Its declare inside method,constructor and block
 *                  Scope of local variable is limited , within that block 
 */
public class Variable_Methods {
//Instance Variable	
	byte byteVar=10;
	short shortVar=20;
	int intVar=30;
	long longVar=40;
	float floatVar=55.4f;
	double doubleVar=88.5;
	char charVar='A';
	boolean boolVar=false;
	
//Static Variable
	static int intStaticVar=0;
	
//Method without returntype and without parameter
	void method1() {
		System.out.println("Access Instance Variable inside Instance Method : "+intVar);
		System.out.println("Access Static Variable inside Instance Method : "+intStaticVar);
		System.out.println("Access Static Variable inside Instance Method : "+Variable_Methods.intStaticVar);
		int x=5; //local variable
		}
//Method with returntype and without parameter
	int method2() {
		System.out.println("Method with return type and without argument");
		return 2;
	}
//Method with returntype and with parameter
	float method3(float x,float y) {
		System.out.println("Method with return type and with argument");
		return x+y;
	}
//Method without returntype and with parameter
	void method4(int i) {
		System.out.println("Method without return type and with argument : i="+i);
		staticMethod(); // directly call static method inside instance method
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Variable_Methods obj=new Variable_Methods(); // create object
		obj.method1(); // method call
		int a=obj.method2();
		float b=obj.method3(5.5f, 6.8f);
		obj.method4(a);
        System.out.println("Access Instance Variable inside Static Method : "+obj.byteVar);
        System.out.println("Access Static Variable inside Static Method : "+intStaticVar);
		System.out.println("Access Static Variable inside Static Method : "+Variable_Methods.intStaticVar);
		staticMethod();// directly call static method inside static method
		Variable_Methods.staticMethod(); // call static method using class name
		
		//Typecasting 
		short x=(short)obj.byteVar;
	}
	
	static void staticMethod() {
		System.out.println("Its Static method...");
	}

}
