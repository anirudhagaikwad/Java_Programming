package javaintro;

import java.util.StringTokenizer;

/*
 * StringTokenizer class is located in java.util pakage
 * StringTokenizer class is used to break a string into tokens based on provided delimiter
 * StringTokenizer class is deprecated and its avilable pnly for compatibility resons.
 */

public class JavaStringTokenizer {
	
	void tokenizer1() {
		StringTokenizer obj=new StringTokenizer("String is an object that represents sequence of characters, In java string is represented by String class"," ");
		while(obj.hasMoreTokens()) {
			System.out.println(obj.nextToken());
		}
	}
	
	void tokenizer2() {
		String str1=":";
		String str2="Immutable Object : An object whose : state cannot be : changed after it : created is known as an : immutable object";
		StringTokenizer obj=new StringTokenizer(str2,str1);
		int count=obj.countTokens();
		for(int i=0;i<count;i++) {
			System.out.println("token ["+i+"] :"+obj.nextToken());
		}
	}

	public static void main(String[] args) {
		JavaStringTokenizer obj=new JavaStringTokenizer();
		obj.tokenizer1();
		obj.tokenizer2();
		obj.stringSplit();

	}//main()
	
// Its recommended by oracle use String.split or java.util.regex insted StringTokenizer class	
	void stringSplit() {
		String[] str="String is an object that represents sequence of characters, In java string is represented by String class".split("\\s");
		for(int x=0;x<str.length;x++) {
			System.out.println(str[x]);
		}
	}

}//JavaStringTokenizer
