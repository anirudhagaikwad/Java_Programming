package oop;

/*
 *                                                              Access Level
 * ################################################################################################################################  
 *               Modifier                      Class        Package         SubClass           Project    
 *   --------------------------------------------------------------------------------------------------------------------------
 *                public                        Yes           Yes                Yes              Yes
 *                
 *                protected                   Yes           Yes                Yes               No
 *                
 *                private                       Yes           No                 No                No
 *                
 *                default                       Yes          Yes                 No                No
 *    ---------------------------------------------------------------------------------------------------------------------------     
 * ###################################################################################################################################       
 *  Modifier : types of access modifiers in java
 *  Class :  its second column which indicates whether the class itself has access to members.
 *  Package : its third column which indicates whether the classes in same package as the class have access to to members
 *  SubClass : its fourth column which indicates whether the subclasses of the class declared outside this package have access to the member
 *  Project :   its fifth column which indicates whether the project have access to members.                                        
 */
public class JavaAccessModifiers_Package {
    
	int a=5;   // default access modifier
	protected int x=10; // protected access modifier
	private int y=20; // private access modifier
	public int z=30; // public access modifier
	
	void methodDefaultAccessModifier() { // default access modifier
		System.out.println("a = "+a);
	}
	
	protected  void methodProtectedAccessModifier() { // protected access modifier
		System.out.println("x = "+x);
	}
	
	private void methodPrivateAccessModifier() { // private access modifier
		System.out.println("y = "+y);
	}
	
	public void methodPublicAccessModifier() { // public access modifier
		System.out.println("z = "+z);
	}
	
	public static void main(String[] args) {
		

	}//main()

}//JavaAccessModifiers_Package

/*
 * For class use public,final and abstract modifiers
 * for constructor,variable and method use default,protected,private and public modifiers
 */
