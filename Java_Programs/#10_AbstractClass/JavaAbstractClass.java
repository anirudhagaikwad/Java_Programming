package oop;

import java.util.Scanner;

/*
 * Abstract Class : A class which is declared using abstract keyword is known as abstract class 
 *                        It can have abstract methods and non-abstract methods,variables and constructors
 *                        We can not create object of abstract class
 *                        It is used to achieve abstraction
 *                        
 * Abstract Method : The method declared without any body within abstract class are called abstract method
 *                                    Any class that extends abstract class must implement all abstract methods
 *                                    abstract method never final and static , by default its public
 *                                                
 */

public class JavaAbstractClass {

	public static void main(String[] args) {
	
		TyerAirPressureConvertor obj=new TyerAirPressureConvertor();
		obj.convertor_BAR_To_PSI(); // call implemented abstract method
		obj.convertor_Kilopascal_To_PSI(); // call from abstract class
		obj.convertor_PSI_To_BAR(); // call implemented abstract method
		obj.convertor_PSI_To_Kilopascal(); // call from abstract class
     
	}//main()

}//JavaAbstractClass


abstract class TyerAirPressure{
	
	abstract void convertor_BAR_To_PSI();
	abstract void convertor_PSI_To_BAR();
	
   void convertor_PSI_To_Kilopascal() {
	   Scanner scObj=new Scanner(System.in);
		System.out.println("Enter psi : ");
	   	 int psi=scObj.nextInt();
	   //1 psi = 6.8947572932 kPa
	   	 double kpa=psi*6.8947572932;
	   	System.out.println(psi+" psi ="+kpa+" kpa");
   }
   
   
   void convertor_Kilopascal_To_PSI() {
	   Scanner scObj=new Scanner(System.in);
		System.out.println("Enter kpa : ");
	   	 int kpa=scObj.nextInt();
	   //1 kPa = 0.1450377377 psi
	   	 double psi=kpa*0.1450377377;
	   	System.out.println(kpa+" kpa ="+psi+" psi");
   }
	
}//TyerAirPressure


class TyerAirPressureConvertor extends TyerAirPressure{

	public void convertor_BAR_To_PSI() {
		Scanner scObj=new Scanner(System.in);
		System.out.println("Enter bar : ");
	   	 int bar=scObj.nextInt();
	   	 System.out.println("Convert bar to psi :");
	   	 // 1 bar = 14.503773773 psi
	   	 double psi =bar*14.503773773;
	   	 System.out.println(bar+" bar ="+psi+" psi");
	   	 	}
	
	public void  convertor_PSI_To_BAR() {
		Scanner scObj=new Scanner(System.in);
		System.out.println("Enter psi : ");
	   	 int psi=scObj.nextInt();
	   	 System.out.println("Convert psi to bar :");
	   	 // 1 psi = 0.0689475729 bar
	   	 double bar =psi*0.0689475729;
	   	 System.out.println(psi+" psi ="+bar+" bar");
	}
	

}//TyerAirPressureConvertor
