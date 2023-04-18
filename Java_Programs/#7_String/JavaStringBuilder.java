package javaintro;


/*
 * StringBuilder class is used to create mutable string object,StringBuilder class located in java.lang package
 * mutable object : An object whose state can be changed after it created is known as an mutable object
 * Its not Thread Safe : multiple threads can access it simultaneously (its not synchronized)
 */

public class JavaStringBuilder {

	public static void main(String[] args) {
		StringBuilder sbObj=new StringBuilder("Hello");
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
				StringBuilder sbObj1=new StringBuilder();
				System.out.println(sbObj1.capacity()); // Empty constructor reserve space for 16 characters
				System.out.println(sbObj.capacity()); // 16+10 =26

		//ensureCapacity()
				sbObj.ensureCapacity(22); // if the argument of the ensureCapacity() is less than the existing capacity ,then there will be no change in existing capacity
				System.out.println(sbObj.capacity());
				sbObj.ensureCapacity(27); // (26*2)+2 = 54
				System.out.println(sbObj.capacity()); // if the argument of the ensureCapacity() is greater than the existing capacity ,then there will be change in existing capacity using rule ;--> newCapacity=(oldCapacity x 2)+2
		
				 /* System.out.println("Question");
				JavaStringBuilder obj=new JavaStringBuilder();
				obj.multiDimFetch();  */

	}//main()
	
/*	
	void multiDimFetch() {
		
		String[][] str= {{"1","2","3"},{"4","5","6"}};
		
		System.out.println("Featching 2 : "+str[0][1]); //its working
		System.out.println("Featching 6 : "+str[1][2]); // 
	}
	
	*/

}//JavaStringBuilder
