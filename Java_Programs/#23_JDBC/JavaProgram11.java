package PPT23;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// write a jdbc program to execute any type of query

public class JavaProgram11 {

    public static void main(String a[]){

        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.
                    getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
                            ,"user","password");
            Statement stmt = con.createStatement();
            //The query can be update query or can be select query
            String query = "select * from emp";
            boolean status = stmt.execute(query);
            if(status){
                //query is a select query.
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    System.out.println(rs.getString(1));
                }
                rs.close();
            } else {
                //query can be update or any query apart from select query
                int count = stmt.getUpdateCount();
                System.out.println("Total records updated: "+count);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(con != null) con.close();
            } catch (Exception ex){}
        }
    }
}

