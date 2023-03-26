package PPT23;

/*
Write a program to show the commit and rollback in java.

*/

import java.sql.*;
import java.io.*;
class JavaProgram10
{
    static String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    static String DBUSER = "local";
    static String DBPASS = "test";
    public static void main(String args[])
    {
        try
        {
            //Loading the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Cretae the connection object
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            con.setAutoCommit(false);
            //Insert the record
            String sql = "INSERT INTO Employee (empid, empname) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //Used to take user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                System.out.print("Enter employee Id: ");
                String s1 = br.readLine();
                int empid = Integer.parseInt(s1);

                System.out.print("Enter employee name: ");
                String name = br.readLine();

                ps.setInt(1, empid);
                ps.setString(2, name);
                ps.executeUpdate();
                System.out.println("commit/rollback");
                String answer = br.readLine();
                if (answer.equals("commit"))
                {
                    con.commit();
                }
                if (answer.equals("rollback"))
                {
                    con.rollback();
                }
                System.out.println("Want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n"))
                {
                    break;
                }
            }
            con.commit();
            System.out.println("record successfully saved");
            con.close();//before closing connection commit() is called
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}


