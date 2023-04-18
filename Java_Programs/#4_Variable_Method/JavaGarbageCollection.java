package javaintro;

public class JavaGarbageCollection {

	public static void main(String[] args) {
		JavaGarbageCollection obj=new JavaGarbageCollection();
		
/* object is able to get garbage collect it it is non reference */	
		
		obj=null; //make object non-reference by using null
		
		JavaGarbageCollection obj1=new JavaGarbageCollection();
		JavaGarbageCollection obj2=new JavaGarbageCollection();
		
		obj2=obj1; // make object non-reference by setting new reference to it 
		
		System.gc(); // it is used to call garbage collector explicitly , its present in System class

	}//main()
	
	public void finalize() {
		/*
		 * finalize method is called by garbage collection thread before collecting object
		 * finalize method is gets called only once by garbage collector thread
		 * finalize method is used to perform specific task before object destroy
		 * finalize method is define in java.lang.Object
		 * finalize method is decleared as protected modifier inside Object class
		 */
		System.out.println("Garbage Collected");
	}

}//JavaGarbageCollection
