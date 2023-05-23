
/*
Generics provide flexibility and type safety, allowing you to create reusable code that works with different data types while catching type-related errors at compile-time. They are commonly used in collections, algorithms, and many other areas of Java programming.
 * Generic programming enables the programmer to create classes,interfaces and methods in which type of data is specified as a parameter. 
 * It provides a facility to write an algorithm independent of any specific type of data. Generics also provide type safety. 
 * Type safety means ensuring that an operation is being performed on the right type of data before executing that operation.
 * 
 * Class_name <data type> reference_name = new Class_name<data type> ();  OR  Class_name <data type> reference_name = new Class_name<>(); 
 * This is also known as Diamond Notation of creating an object of Generic type.
 * 
 * Generics work only with objects i.e the type argument must be a class type.
 * You cannot use primitive datatypes such as int, char etc. with Generics type.
 * 
 * Generics add stability to your code by making more of your bugs detectable at compile time.
 */
public class JavaGenerics {

	public static void main(String[] args) {
		
		
		Genri<Integer> obj=new Genri<Integer>(100);
		int x=obj.getObj();
		System.out.println(x);
		
		
		Genri<String> str=new Genri<>("Hello");
		String st=str.getObj();
		System.out.println(st);
/*
 * In Genri<Integer> & Genri<String> we first passed an Integer type parameter to the Generic class. Then, we passed a String type parameter to the same Generic class.
 *  Hence, we reused the same class for two different data types. Thus, Generics helps in code reusability with ease.		
 */

//#########################################################################################################################		
		
		Genri_2<Integer,Double> obj1=new Genri_2<Integer,Double>(200,996.586);
		System.out.println(obj1.getT1()+"   obj1.getT1() = "+obj1.getT1().getClass().getName());
		System.out.println("obj1.getT2() = "+obj1.getT2().getClass().getName());
		
		Genri_2<String,Float> obj3=new Genri_2<>("200",996.586f);
		System.out.println("obj1.getT1() = "+obj3.getT1().getClass().getName());
		System.out.println("obj1.getT2() = "+obj3.getT2().getClass().getName());
		
		
		display(88,"Java");
		
		
		display(88.65,98L);
		
	}//main
	
/* You can also create generic methods that can be called with different types of arguments. 
 * Based on the type of arguments passed to generic method, the compiler handles each method. */	
	static <V,T> void display(V v,T t) {
		System.out.println(v.getClass().getName());
		System.out.println(t.getClass().getName());
	}

}//JavaGenerics

class Genri<T>{
	T obj;

	public Genri(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
		
}//Genri<T>



class Genri_2<T1,T2>{
/* Generic parameterized types, we can pass more than one data type as parameter.
 * here are two parameters in Generic class - T1 and T2, therefore,
 * while creating an instance of this Generic class, we need to mention two data types that needs to be passed as parameter to this class.  */	
	
	
	T1 t1; T2 t2;


	public Genri_2(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}//constructor


	public T1 getT1() {
		return t1;
	}


	public void setT1(T1 t1) {
		this.t1 = t1;
	}


	public T2 getT2() {
		return t2;
	}


	public void setT2(T2 t2) {
		this.t2 = t2;
	}
	
			
}//Genri_2<T1,T2>
