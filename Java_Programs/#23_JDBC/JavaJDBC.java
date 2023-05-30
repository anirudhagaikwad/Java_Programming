package javaoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC API : is application programming interface that can access anu kind of tabular data,especially data stored in a relational database
 * JDBC helps you to write java application that manages below three programming activities
 *                - Connect to data source ,like database
 *                - Send queries and update statements to the database
 *                - Retrieve and process the result received from the database in answer to query
 * Using JDBC API java application can execute SQL statements ,retrieve result and propagate changes back to an underlying  data source.
 * JDBC 4.0 API is devided into two pakages 1) java.sql  2) javax.sql   
 * 
 * JDBC Driver Manager : The JDBC Driver Manager class defines objects which can connect java application to a JDBC Driver
 *                                 This class has traditionally been the backbone of the JDBC architecture             
 *                
 */

public class JavaJDBC {
	/*
	 * following 5 steps are basic steps involve in connecting java application with database using JDBC
	 * 1. Register Driver
	 * 2. Create Connection
	 * 3. Create SQL Statement
	 * 4. Execute SQL Statements
	 * 5. Closing the Connection
	 */
	
	private final String USER="root";
	private final String PASSWD="";
	private final String DBURL="jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";

	/*
	 * jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false
	 * 
	 * jdbc : API
	 * mysql : Database Application Name
	 * localhost : Location where mysql is running
	 * 3306 : Port Number
	 * employee : database name
	 * ?autoReconnect=true&useSSL=false : by pass SSL
	 * 
	 */
	
	void createTbl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query="create table empRegistration(empId integer not null,empName varchar(255),empAddress varchar(255))"; //Create SQL Statement
			Statement stmt=con.createStatement();
			stmt.executeLargeUpdate(query); //Execute SQL Statements
		}catch(SQLException e) {e.printStackTrace();}
		
	} //createTbl() 
	
	
	void insertTbl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query=" insert into empRegistration values(101,'Anirudha','Solapur')"; //Create SQL Statement
			String query1=" insert into empRegistration values(102,'Dinesh','Pune')"; //Create SQL Statement
			String query2=" insert into empRegistration values(103,'Swarupa','Mumbai')"; //Create SQL Statement
			String query3=" insert into empRegistration values(104,'Maithili','Nagpur')"; //Create SQL Statement
			Statement stmt=con.createStatement();
			stmt.executeLargeUpdate(query); //Execute SQL Statements
			stmt.executeLargeUpdate(query1); //Execute SQL Statements
			stmt.executeLargeUpdate(query2); //Execute SQL Statements
			stmt.executeLargeUpdate(query3); //Execute SQL Statements
			System.out.println("Data inserted into table sucessfully.....");
		}catch(SQLException e) {e.printStackTrace();}
		
	} //insertTbl()
	
	
	
	void fetchTbl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query=" select * from empRegistration"; //Create SQL Statement
			Statement stmt=con.createStatement();
			//stmt.executeLargeUpdate(query); //Execute SQL Statements
			ResultSet rs=stmt.executeQuery(query); 
			while(rs.next()) {
				System.out.println("Employee ID : "+rs.getInt("empId"));
				System.out.println("Employee Name : "+rs.getString("empName"));
				System.out.println("Employee Address : "+rs.getString("empAddress"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
	} //fetchTbl()
	
	
	void updateTbl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query=" update empRegistration set empName='Radhika' where empId in (102,103)"; //Create SQL Statement
			Statement stmt=con.createStatement();
			stmt.executeLargeUpdate(query); //Execute SQL Statements
			
			String query1=" select * from empRegistration"; //Create SQL Statement
			ResultSet rs=stmt.executeQuery(query1); 
			while(rs.next()) {
				System.out.println("Employee ID : "+rs.getInt("empId"));
				System.out.println("Employee Name : "+rs.getString("empName"));
				System.out.println("Employee Address : "+rs.getString("empAddress"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
	} //updateTbl()
	
	
	void deleteTbl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query=" delete from empRegistration where empId=102"; //Create SQL Statement
			Statement stmt=con.createStatement();
			stmt.executeLargeUpdate(query); //Execute SQL Statements
			
			String query1=" select * from empRegistration"; //Create SQL Statement
			ResultSet rs=stmt.executeQuery(query1); 
			while(rs.next()) {
				System.out.println("Employee ID : "+rs.getInt("empId"));
				System.out.println("Employee Name : "+rs.getString("empName"));
				System.out.println("Employee Address : "+rs.getString("empAddress"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
	} //deleteTbl()
	
	
	public static void main(String[] args) {
	
		JavaJDBC obj=new JavaJDBC();
		//obj.createTbl();
		//obj.insertTbl();
		//obj.fetchTbl();
		//obj.updateTbl();
		//obj.deleteTbl();
		obj.insertTbl_PreparedStatement();

	}//main()
	
	
	void insertTbl_PreparedStatement() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register Driver
        }catch(ClassNotFoundException e) {e.printStackTrace();}
		
		try(Connection con=DriverManager.getConnection(DBURL,USER,PASSWD)){  //Create Connection
			String query=" delete from empRegistration where empId=102"; //Create SQL Statement
			PreparedStatement stmt=con.prepareStatement("insert into empRegistration values(?,?,?)");
			stmt.setInt(1, 105); //Execute SQL Statements
			stmt.setString(2,"Akash");
			stmt.setString(3,"Satara");
			int i=stmt.executeUpdate();
			System.out.println(i+" number of record inserted into table");
			String query1=" select * from empRegistration"; //Create SQL Statement
			ResultSet rs=stmt.executeQuery(query1); 
			while(rs.next()) {
				System.out.println("Employee ID : "+rs.getInt("empId"));
				System.out.println("Employee Name : "+rs.getString("empName"));
				System.out.println("Employee Address : "+rs.getString("empAddress"));
			}
		}catch(SQLException e) {e.printStackTrace();}
	}//insertTbl_PreparedStatement() 
	
	
	

}//JavaJDBC
