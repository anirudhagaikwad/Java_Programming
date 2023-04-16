package PPT23;

/*
Write a program to insert and read an image from the database table (Using BLOB).

*/

import java.sql.*;
import java.io.*;
class JavaProgram8
{
    static String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    static String DBUSER = "local";
    static String DBPASS = "test";
    public static void main(String args[])
    {
        try
        {
            //Load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Cretae the connection object
            Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            //Inserting the record in Image table
            String sql = "insert into Image values(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 101);
            ps.setString(2, "Samsung");
            //read the image file
            FileInputStream fin=new FileInputStream("mob.jpg");
            ps.setBinaryStream(2,fin,fin.available());
            int i=ps.executeUpdate();
            System.out.println(i+" records affected");
            //close
            fin.close();
            ps.close();
            con.close();

        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}

