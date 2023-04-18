package javaintro;

public class JavaBranchingStatement_Break_Continue_Return {

	int[] intArray= {55,88,99,44,66,33,77,6,7,2,4,6,9,8,785};
	int[][] intArrayMultiDim= {{459,852,679,421},{2,2466,854,125},{4687,215,794,3}};
	String str="Rust is a multi-paradigm, general-purpose programming language designed for performance and safety, especially safe concurrency. It is syntactically similar to C++, but can guarantee memory safety by using a borrow checker to validate references";
	
	void findNumber_unlabeledBreak(int[] arr , int key) {
		int i;
		boolean foundIt=false;
		for(i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				foundIt=true;
				break;  // Unlabeled Break
			}// if
		} //for
		if(foundIt) {
			System.out.println(key+" Found at array index "+i);
		}else {
			System.out.println(key+" Not-Found in array");
		}
	}//findNumber_unlabeledBreak(int[] arr , int key)
	
	
	void findNumber_labeledBreak(int[][] arr , int key) {
		int i;int j=0;
		boolean foundIt=false;
		found:
			for(i=0;i<arr.length;i++) {
				for(j=0;j<arr[i].length;j++) {
					if(arr[i][j]==key) {
						foundIt=true;
						break found; // labeled Break
					}//if
				}//inner for
			}//outer for
		if(foundIt) {System.out.println(key+" Found at array index  ["+i+"]"+"["+j+"]");}
		else {System.out.println(key+" Not-Found in array");}
	}//findNumber_labeledBreak(int[] arr , int key)
	
	
	public static void main(String[] args) {
		JavaBranchingStatement_Break_Continue_Return obj=new JavaBranchingStatement_Break_Continue_Return();
		obj.findNumber_unlabeledBreak(obj.intArray, 4);
		obj.findNumber_labeledBreak(obj.intArrayMultiDim,3);
		obj.findCharacter_unlabeledContinue(obj.str, 'r');
		obj.findSubString_labeledContinue(obj.str,"Java");
	}//main()
	
	
	void findCharacter_unlabeledContinue(String s,char ch) {
		int max=s.length();
		int numCh=0;
		for(int i=0;i<max;i++) {
			if(s.charAt(i) !=ch) {
				continue; // unlabeled Continue
			} //if
			numCh++;
		}//for
		System.out.println(ch+" Found in String "+numCh+" Number of time");
	}//findCharacter_unlabeledContinue(String s,char ch)
	
	
	void findSubString_labeledContinue(String s,String subS) {
		boolean foundIt=false;
		int max=s.length()-subS.length();
		found:
			for(int i=0;i<=max;i++) {
				int n=subS.length();
				int j=i; int k =0;
				while(n-- !=0) {
					if(s.charAt(j++) != subS.charAt(k++)) {
						continue found; // labeled Continue
					}
				} // inner while
				foundIt=true;
				break found; // labeled Break
			}// outer for
		System.out.println(foundIt?"Found It":"Didnt find it"); // ternary
	}//findSubString_labeledContinue(String s,String subS)
	

}//JavaBranchingStatement_Break_Continue_Return
