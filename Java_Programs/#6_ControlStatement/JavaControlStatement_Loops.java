package fundamentals;

import java.util.Scanner;

public class JavaControlStatement_Loops {
	
	void controlStatement_for_loop(int num) {
		/*  for(initialization;condition;increment/decrement){//statements } */
		for(int i=1;i<=10;i++) {System.out.println(num+" x "+i+" = "+(num*i));}
	}
	
	void controlStatement_for_each_loop(int[] arr) {
		/*  for(type var : object){statements ;} */
		for(int x:arr) {System.out.println("Array Element : "+x);} // traversing array
	}

	public static void main(String[] args) {
		JavaControlStatement_Loops obj=new JavaControlStatement_Loops();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number : ");
		int num=scan.nextInt();
		obj.controlStatement_for_loop(num);
		
		int[] intArr= {11,22,55,66,88,44};
		obj.controlStatement_for_each_loop(intArr);
		
		obj.controlStatement_while_loop(num);
		
		obj.controlStatement_do_while_loop(num);

	}//main()
	
	void controlStatement_while_loop(int num) {
	/*  while(condition){statements; conunter;}  */
		int i=1;
		while(i<=10) {System.out.println(num+" x "+i+" = "+(num*i)); i++;}
	}
	
	void controlStatement_do_while_loop(int num) {
	/* do{statements;}while(condition); */
		int i=1;
		do {System.out.println(num+" x "+i+" = "+(num*i)); i++; }while(i<=10);
	}
	
}//JavaControlStatement_Loops
