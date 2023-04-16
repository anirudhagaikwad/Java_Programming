package PPT23;
/*
Delete Contents From Table Using JDBC
*/


import java.sql.*;

class conn {

    Connection con = null;

    public static Connection connectDB()

    {
        Connection con=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotelman",
                    "root", "1234");
            // here,root is the username and 1234 is the
            // password,you can set your own username and
            // password.
            return con;
        }
        catch (SQLException | ClassNotFoundException e) {

            System.out.println(e);
        }
        return con;
    }
}
public class JavaProgram3 {

    public static void main(String[] args)
    {
        Connection con=null;
        PreparedStatement p=null;
        con=conn.connectDB();
        try{
            String sql="delete from cuslogin where id=1";
            p =con.prepareStatement(sql);
            p.execute();
        }catch(SQLException e){
            System.out.println(e);

        }
    }

}

