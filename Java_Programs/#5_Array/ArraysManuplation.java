package fundamentals;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Arrays class located into java.util package
 * method contain by Arrays class are used to manipulation of array
 * method contain by Arrays class are static,so we can call them using class name
 */

public class ArraysManuplation {
	
	int[] arr1= {11,66,99,44,33,77,88,22,33};
	int[] arr2= {55,66,88,22,11,77,99};
	String[] strArray= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

	
	void arraysManuplation() {
		System.out.println("Converted String array to list using asList() : "+Arrays.asList(strArray));
		System.out.println("Its return String Representation of specified array containts : "+Arrays.toString(arr2));
		Arrays.sort(arr1); // sort array into accending order
		System.out.println("After sort array in accending order : "+Arrays.toString(arr1));
		int key=88;
		int index_no=Arrays.binarySearch(arr1, key); // search element using binary search
		System.out.println(key+" found in array at index "+index_no);
		
		int[] a=new int[5];
		Arrays.fill(a,401); // fill array
		System.out.println("Arrays.fill(a,401) : "+Arrays.toString(a));
		
		boolean eql=Arrays.equals(arr1, arr2);  // check equality of arrays
		if(eql) {System.out.println("Both array are equal");}else {System.out.println("Both array are not-equal");}
		
		// Copy one array into another array
		String[] strArray2=Arrays.copyOfRange(strArray, 3, 6);
		System.out.println("strArray : "+Arrays.toString(strArray));
		System.out.println("strArray2 : "+Arrays.toString(strArray2));
		
	}//arraysManuplation()
	
	public static void main(String[] args) {
		
		ArraysManuplation obj =new ArraysManuplation();
		obj.arraysManuplation();
		
		int arr[]={55,33,44,66,77,99};
		int l=arr.length;
		obj.printArray(arr, l, 0);
		
		
// for interest before learn collection and generics ---> llist in integer type

		List<int[]> objList= Arrays.asList(obj.arr1);  // way 1
		
		IntStream.of(obj.arr2).boxed().collect(Collectors.toList()); // way 2
		
		List<Integer> intList=new ArrayList<Integer>(obj.arr1.length); // way 3
		
	
		
		

	}//main()
	
	
/*
 * 1) Print array elements without using loops and without use any library from java,write method to perform this operation
      int arr[]={55,33,44,66,77,99};	
 */
	
	void printArray(int arr[],int length,int iterate) {
		if(iterate==length)
		{
			return;
		}
		System.out.print(arr[iterate]);
		iterate++;
		printArray(arr,length,iterate); //recursion
	}




}//JavaArraysManuplation
