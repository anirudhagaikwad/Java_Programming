package fundamentals;


/*
 * 1)Static Block : Its set of statements which are execute by JVM before the main method 
 * 2)Instance Block : Its Execute whenever object is created ,its execute before constructor call
 */
public class JavaBlocks {
	static {
		System.out.println("Its Static Block1");
	}
    
	{System.out.println("Its Instance Block1");}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello sysout1...");
		{System.out.println("Its Instance Block2");}
		JavaBlocks obj=new JavaBlocks();
		System.out.println("Hello sysout2...");
	}
	static {
		System.out.println("Its Static Block2");
	}

	{System.out.println("Its Instance Block3");}

}