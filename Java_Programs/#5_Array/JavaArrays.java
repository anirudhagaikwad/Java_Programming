package fundamentals;

import java.util.Arrays;
import java.util.Scanner;


/*
 * Array is container object that holds a fix number of values of single type
 * The length of array is established when the array is created
 * After create array its length is fixed
 * Array index start with 0
 * Each item of array its called element
 */

public class JavaArrays {
/*
 * datatype[] arrayName;
 * datatype arrayName[] ; 
 */
	
	void arrayDemo1() {
		int[] arrayInt; // array decleration
		arrayInt=new int[10]; // array initialization - allocate memory for array
		// initialize elements
		arrayInt[0]=101;
		arrayInt[1]=102;
		arrayInt[2]=103;
		arrayInt[3]=104;
		arrayInt[4]=105;
		arrayInt[5]=106;
		arrayInt[6]=107;
		arrayInt[7]=108;
		arrayInt[8]=102;
		arrayInt[9]=102;
		System.out.println("access element arrayInt[7] : "+arrayInt[7]); // index 7 value i.e 108
		arrayInt[9]=110;  //update array element
		System.out.println("access element arrayInt[9] : "+arrayInt[9]);
	}//arrayDemo1()
	
	
	void arrayDemo2() {
		// int[] arrayInt=new int[10];
		int[] arrayInt= {101,102,103,104,105,106};
		System.out.println("access element arrayInt[4] : "+arrayInt[4]);
		
		arrayInt[4]=110;  //update array element
		System.out.println("access element arrayInt[4] : "+arrayInt[4]);
		
		System.out.println("Array Length = "+arrayInt.length); // check array length
		
		System.out.println("Array Elements : "+Arrays.toString(arrayInt)); // print array elements
		
		for(int i=0;i<arrayInt.length;i++) {
			System.out.println("Array Element = "+arrayInt[i]);
		}
		
	}//arrayDemo2()
	
	public static void main(String[] args) {
		JavaArrays obj=new JavaArrays();
		obj.arrayDemo1();
		obj.arrayDemo2();
		obj.multiDimentionalArray();
		int[] arr=new int[5];
		Scanner ob=new Scanner(System.in);
		arr[0]=ob.nextInt();
		arr[1]=ob.nextInt();
		obj.arrayDemo(arr);

	}//main()
	
	/*
	 * datatype[][] arrayName=new datatype[no_of_rows][no_of_columns]
	 * datatype[][] arrayName={{no_of_rows},{no_of_columns}};
	 */
	
	void multiDimentionalArray() {
		
		String[][] names= {{"Mr.","Mrs.","Ms."},{"Danish","Shukla","Patil"}};
		
		System.out.println(names[0][0]+names[1][0]); // Mr.Danish
		System.out.println(names[0][2]+names[1][1]); // Ms.Shukla
		System.out.println(names[0][1]+names[1][2]); // Mrs.Patil
		
		// update element
		names[1][0]="Anirudha";
		System.out.println(names[0][0]+names[1][0]); // Mr.Anirudha
	
		for(int i=0;i<names.length;i++){ // for over rows
			for(int j=0;j<names[i].length;j++) { //for over columns
				System.out.println(names[i][j]);
			}
			System.out.println(); // for new line
		}
		//System.out.println("Array Elements : "+Arrays.toString(names)); // print array elements
	}//multiDimentionalArray()
	
	int[] sum(int[] arr) {
		 arr[1]=1+2;
		arr[2]=5-2;
		return arr;
	}
	
	void arrayDemo(int[] arr) {
		System.out.println(arr.toString());
	}
	
	
	
	
	
	

	
	
}//JavaArrays
