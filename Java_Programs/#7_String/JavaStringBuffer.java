package javaintro;

/*
 * StringBuffer class is used to create mutable string object,StringBuffer class located in java.lang package
 * mutable object : An object whose state can be changed after it created is known as an mutable object
 * Its Thread Safe : multiple threads cannot access it simultaneously
 * It is Synchronized
 */

public class JavaStringBuffer {
	
	void stringBufferMethod() {
		StringBuffer sbObj=new StringBuffer("Hello Java");
		System.out.println(sbObj);
//append()		
		sbObj.append(" and Rust");
		System.out.println(sbObj);
		
//insert()
		sbObj.insert(5, "Hi");
		System.out.println(sbObj);
		
//reverse()
		sbObj.reverse();
		System.out.println(sbObj);
		
//capacity()
		StringBuffer sbObj1=new StringBuffer();
		System.out.println(sbObj1.capacity()); // Empty constructor reserve space for 16 characters
		System.out.println(sbObj.capacity()); // 16+10 =26

//ensureCapacity()
		sbObj.ensureCapacity(22); // if the argument of the ensureCapacity() is less than the existing capacity ,then there will be no change in existing capacity
		System.out.println(sbObj.capacity());
		sbObj.ensureCapacity(27); // (26*2)+2 = 54
		System.out.println(sbObj.capacity()); // if the argument of the ensureCapacity() is greater than the existing capacity ,then there will be change in existing capacity using rule ;--> newCapacity=(oldCapacity x 2)+2
		
	}

	public static void main(String[] args) {
		JavaStringBuffer obj =new JavaStringBuffer();
		obj.stringBufferMethod();

	}//main()

}//JavaStringBuffer
