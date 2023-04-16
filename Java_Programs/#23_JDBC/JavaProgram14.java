package PPT23;

// java program for batch update using Statement in jdbc
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaProgram14 {

    public static void main(String a[]){

        Connection con = null;
        Statement st = null;
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            con.setAutoCommit(false);
            st = con.createStatement();

            // add update query batches
            st.addBatch("update emp set sal=3000 where empid=200");
            st.addBatch("insert into emp values (100,4000)");
            st.addBatch("update emp set emp name='Ram' where empid=345");

            // count array stores no. of updates done in each query
            int count[] = st.executeBatch();

            for(int i=1;i<=count.length;i++){
                System.out.println("Query "+i+" has effected "+count[i]+" times");
            }

            con.commit();
        } catch (ClassNotFoundException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally{
            try{
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}

