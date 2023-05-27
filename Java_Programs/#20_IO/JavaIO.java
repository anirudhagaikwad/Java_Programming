package corejava;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/*
 * Byte Stream Classes : BufferedInputStream,BufferedOutputStream,DataInputStream,DataOutputStream 
 * 						 FileInputStream,FileOutputStream,InputStream,OutputStram,PrintStream
 * Character Stream Classes : BufferedReader,BufferedWriter,FileReader,FileWriter,InputStreamReader
 * 							  OutputStreamReader,PrintWriter,Reader,Writer
 */


public class JavaIO {
void readConsoleInput() {
	BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	try {
		System.out.println("Enter Line : ");
		String str=obj.readLine();
		System.out.println("enter by user : "+str);
		System.out.println("Enter Number : ");
		int num=obj.read();
		System.out.println("enter by user : "+num);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

void copyByte() {
	/* Copy bytes */
	FileInputStream in=null;
	FileOutputStream out=null;
	try {
	in=new FileInputStream("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaBlocks.java");
	out=new FileOutputStream("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaCopy.java");
	int c;
	while((c=in.read())!=-1) { // c holds byte value 8bit
		out.write(c);
	}
	}
	catch(IOException e) {e.printStackTrace();}
	finally {if(in!=null) {try {
		in.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}} if(out!=null) {try {
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}}
}//copyBytes()

void copyCharacters() {
	//FileReader in=null;
	//FileWriter out=null;
	try(FileReader in=new FileReader("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaBlocks.java");FileWriter out=new FileWriter("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaCopy.java");){
		int c;
		while((c=in.read())!=-1) { // c hold character value 16bit
			out.write(c);
		}
	}
	catch(IOException e) {e.printStackTrace();}
}//copyCharacters()

void copyLines() {
	try(BufferedReader in=new BufferedReader(new FileReader("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaBlocks.java"));PrintWriter out=new PrintWriter(new FileWriter("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaCopy.java"));){
		String str;
		while((str=in.readLine())!=null) {
			out.println(str);
		}
	}catch(IOException e) {e.printStackTrace();}
}//copyLines()

void scannerTokens() throws FileNotFoundException {
	Scanner scObj=null;
			try{
			scObj=new Scanner(new BufferedReader(new FileReader("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/JavaCopy.java")));
			while(scObj.hasNext()) {System.out.println(scObj.next());}
			}finally {
				if(scObj!=null) {scObj.close();}
			}
}//scannerTokens()

void scannerSum() throws FileNotFoundException {
	Scanner scObj=null;
	double sum=0;
	try {
		scObj=new Scanner(new BufferedReader(new FileReader("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/sum.txt")));
		scObj.useLocale(Locale.US);
		while(scObj.hasNext()) {
			if(scObj.hasNextDouble()) {
				sum +=scObj.nextDouble();
			}
			else {scObj.next();}
		}
	}finally {
		scObj.close();
	}
	System.out.println("Sum = "+sum);
}//scannerSum()

void standard_console_stream() {
	/*Password verify, change */
	Console obj=System.console();
	if(obj==null) {
		System.err.println("Not Found Console...."); //standard stream
		System.exit(1);
	}
	String username=obj.readLine("Enter your username : ");
	char[] oldPassword=obj.readPassword("Enter your Old Password : ");
	if(verify(username,oldPassword)) {
		boolean noMatch;
		do {
			char[] newPasswd1=obj.readPassword("Enter new Password : ");
			char[] newPasswd2=obj.readPassword("Enter new Password again : ");
			noMatch=!Arrays.equals(newPasswd1,newPasswd2);
			if(noMatch) {
				obj.format("Password not match ... Try again %n");
			}else {changePasswd(username,newPasswd1);
			obj.format("Password for %s changed %n",username);}
			Arrays.fill(newPasswd1,' ');
			Arrays.fill(newPasswd2,' ');
		}while(noMatch);
	} Arrays.fill(oldPassword,' ');
}//standard_console_stream()

boolean verify(String username,char[] passwd) {
	//Dummy method, you can create logic to verify user
	return true;
}//verify
void changePasswd(String username,char[] passwd) {
	//Dummy method,you can create logic to change password
}//changePasswd()
	public static void main(String[] args) {
		JavaIO obj=new JavaIO();
		//obj.readConsoleInput();
		//obj.copyByte();
		//obj.copyCharacters();
		//obj.copyLines();
		/*try {
			obj.scannerTokens();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			obj.scannerSum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//obj.standard_console_stream();
		//obj.createFile("test.txt");
		//obj.readWriteFile();
		obj.methodsForManuplateFileDir();

	}//main()
	
void createFile(String fileName) {
	try{
		File obj=new File("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/"+fileName);
		if(obj.createNewFile()) {
			System.out.println("File created : "+obj.getName());
		}else {System.out.println("File already exists... "+obj.getName());}
	}
	catch(IOException e) {e.printStackTrace();}
}//createFile()

void readWriteFile() {
	try {
		FileWriter out=new FileWriter("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/test.txt");
		out.write("Java going to increase price ");
		out.close();
		File obj=new File("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/test.txt");
		Scanner scObj=new Scanner(obj);
		while(scObj.hasNextLine()) {
			String str=scObj.nextLine();
			System.out.println(str);
		}
		scObj.close();
	}catch(IOException e) {e.printStackTrace();}
}//readWriteFile()

void methodsForManuplateFileDir() {
	File obj=new File("/home/anirudha/eclipse-workspace/LPU_Java/src/corejava/test.txt");
	if(obj.exists()) {
		System.out.println("is File Executable : "+obj.canExecute());
		System.out.println("is File Readable : "+obj.canRead());
		System.out.println("is File Writable : "+obj.canWrite());
		System.out.println("is File Name : "+obj.getName());
		System.out.println("is File Path : "+obj.getAbsolutePath());
		System.out.println("is File Size in bytes : "+obj.length());
		//obj.delete();
	}
}
}//JavaIO
