package PPT23;
/*
How to Update Contents of a Table using JDBC Connection?
*/


import java.sql.*;

class connection {

    public static Connection connectDB()
    {
        // Connection instance
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotelman",
                    "root", "1234");

            // here,root is the username and 1234 is the
            // password,you can set your own username and
            // password.
        }
        catch (SQLException | ClassNotFoundException e) {

            System.out.println(e);
        }
        return con;
    }
}

public class JavaProgram5 {

    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement p = null;
        con = connection.connectDB();
        try {
            String sql
                    = "update cuslogin set name='GFG' where id=2";
            p = con.prepareStatement(sql);
            p.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}


