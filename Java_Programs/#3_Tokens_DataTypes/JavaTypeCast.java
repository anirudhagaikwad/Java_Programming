package javaintro;


/*
 * Casting is process of changing one type value to another type in java
 * We can cast one type value to another type it is known type casting
 * 
 * 1) Implicit Type Casting(Widening Casting) :
 *                 byte-->short-->int-->long-->float-->double
 *                 This casting is possible when Two types are compatible  or when the target type is larger than the source type
 *                      
 *                
 *  2) Explicit Type Casting(Narrowing Casting)      
 *               double-->float-->long-->int-->short-->byte      
 *               This casting is possible when assigning larger type value to smaller type  
 */
public class JavaTypeCast {

	public static void main(String[] args) {
	
// Implicit Casting
		int iVar=200;
		long lVar=iVar; // Implicit Type Casting
		float fVar=lVar; // Implicit Type Casting
		
// Explicit Casting
		double dVar=500.65;
		long longVar=(long)dVar; // explicit Type Casting
		int intVar=(int)longVar; // explicit Type Casting
		
		
		


	}//main()

}//JavaTypeCast
