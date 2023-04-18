package fundamentals;

import java.util.Scanner;

public class JavaControlStatement_Switch {
/*
 * switch(expression){
 * case val1:  code for execution ; break;
 * case val2:  code for execution ; break;
 * default : code ; break;
 * }
 */
	
	void controlStatement_switchDemo1(int monthNumber) {
		/* display name of month ,based on the value of month*/
		String monthName;
		switch(monthNumber) {
		case 1 : monthName="January"; break;
		case 2 : monthName="February"; break;
		case 3 : monthName="March"; break;
		case 4 : monthName="April"; break;
		case 5 : monthName="May"; break;
		case 6 : monthName="June"; break;
		case 7 : monthName="July"; break;
		case 8 : monthName="August"; break;
		case 9 : monthName="September"; break;
		case 10 : monthName="October"; break;
		case 11 : monthName="November"; break;
		case 12 : monthName="December"; break;
		default : monthName="Invalid Input"; break;
		}
		
		System.out.println(monthNumber+" = "+monthName);
	}
	
	
	void controlStatement_switchDemo2(int year,int monthNumber) {
		/* calculates number of days in particular month */
		int numDays=0;
		switch(monthNumber) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: numDays=31; break;
		case 4: case 6: case 9: case 11: numDays=30;break;
		case 2: if(((year%4==0)&& !(year%100==0)) || (year %400==0)) {numDays=29;}
		           else {numDays=28;} break;
        default : System.out.println("Invalid Input"); break;		           
		}
		System.out.println(numDays+" Number of Days in month "+monthNumber);
	}
	
	public static void main(String[] args) {
		JavaControlStatement_Switch obj=new JavaControlStatement_Switch();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Month Number : ");
		int monthNumber=scan.nextInt();
		obj.controlStatement_switchDemo1(monthNumber);
		System.out.println("Enter Year : ");
		int year=scan.nextInt();
		obj.controlStatement_switchDemo2(year, monthNumber);
		
		System.out.println("Enter Month Name : ");
		String monthName=scan.next();
		int num=obj.controlStatement_switchDemo3(monthName);
		System.out.println(num+" number is "+monthName);
		
       scan.close();
	} //main()
	
	
	int controlStatement_switchDemo3(String monthName) {
	 /* display number of month ,based on the month name*/
		int monthNumber=0;
		if(monthName==null) {return monthNumber;}
		switch(monthName.toLowerCase()) {
		case "january": monthNumber=1; break;
		case "february": monthNumber=2; break;
		case "march": monthNumber=3; break;
		case "april": monthNumber=4; break;
		case "may": monthNumber=5; break;
		case "june": monthNumber=6; break;
		case "july": monthNumber=7; break;
		case "august": monthNumber=8; break;
		case "september": monthNumber=9; break;
		case "october": monthNumber=10; break;
		case "november": monthNumber=11; break;
		case "december": monthNumber=12; break;
		default : monthNumber=0; break;
		}
		return monthNumber;
	}

}// JavaControlStatement_Switch
