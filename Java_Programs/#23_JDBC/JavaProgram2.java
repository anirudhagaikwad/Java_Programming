package PPT23;

/*
Java Program to Retrieve Contents of a Table Using JDBC connection
*/

import java.sql.*;


public class JavaProgram2 {

    public static void main(String[] args)
    {
        //Making connection using Connection type and inbuilt function on
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            // here,root is the username and 1234 is the
            // password,you can set your own username and
            // password.

        }
        catch (SQLException | ClassNotFoundException e) {

            System.out.println(e);
        }

        // Try block to catch exception/s
        try {

            // SQL command data stored in String datatype
            String sql = "select * from cuslogin";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("id\t\tname\t\temail");

            // Condition check
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "\t\t" + name
                        + "\t\t" + email);
            }
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
    }
}

