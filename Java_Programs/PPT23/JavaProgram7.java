package PPT23;
/*
Write a program to insert the date value in different format in oracle database.
*/

import java.util.*;
import java.sql.*;
import java.text.*;

class JavaProgram7 {
    public static void main(String[] args) throws Exception {
        //read input value from keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the person id: ");
        int id = sc.nextInt();
        System.out.println("Enter the person name: ");
        String name = sc.next();
        System.out.println("Enter the date of birth: ");
        String dob = sc.next();
        System.out.println("Enter the date of joining: ");
        String doj = sc.next();
        //convert String date value to java.lang.Date class
        //for date of birth
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
        java.util.Date udob = sdf1.parse(dob);
        java.sql.Date sqdob = new java.sql.Date(udob.getTime());
        //for date of joining(yyyy-mm-dd)
        java.sql.Date sqdoj = java.sql.Date.valueOf(doj);
        //create JDBC connection object
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "local", "test");
        //create prepared Statement object
        PreparedStatement ps = con.prepareStatement("insert into person_tab values (?,?,?,?)");
        //set values to the parameters query
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDate(3, sqdob);
        ps.setDate(4, sqdoj);
        //execute the query
        int res = ps.executeUpdate();
        //processing the result
        if (res == 0) {
            System.out.println("Record is not inserted");
        } else
            System.out.println("Record is inserted");
        //close jdbc objects
        ps.close();
        con.close();
    }


}
