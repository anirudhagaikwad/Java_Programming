package PPT23;
/*
write a java program to get primary key value (auto-generated keys)
from inserted queries using JDBC
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaProgram13 {

    public static void main(String a[]){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            // create query
            String query = "insert into emps (name, dept, salary) values (?,?,?)";
            // create prepare statement
            pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            // set prepare statement values
            pstmt.setString(1, "John");
            pstmt.setString(2, "Acc Dept");
            pstmt.setInt(3, 10000);
            pstmt.executeUpdate();

            // use getGeneratedKeys() method for fetching primary keys present at column 1
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }

}

