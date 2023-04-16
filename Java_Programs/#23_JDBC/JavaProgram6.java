package PPT23;
/*
Write java program to Sort Contents of a Table in JDBC
*/

/*
Write a JAVA program to Add a New Column to a Table Using JDBC API
*/


// dont forget to import below package
import java.sql.*;

public class JavaProgram6 {

    // url that points to mysql database,
    // 'db' is database name
    static final String url
            = "jdbc:mysql://localhost:3306/db";

    public static void main(String[] args)
            throws ClassNotFoundException
    {
        try {

            // this Class.forName() method is user for
            // driver registration with name of the driver
            // as argument i have used MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // getConnection() establishes a connection. It
            // takes url that points to your database,
            // username and password of MySQL connections as
            // arguments
            Connection conn = DriverManager.getConnection(
                    url, "root", "1234");

            // create.Statement() creates statement object
            // which is responsible for executing queries on table
            Statement stmt = conn.createStatement();

            // Executing the query, student is the table
            // name and age is the new column
            String query
                    = "ALTER TABLE student ADD COLUMN age INT";

            // executeUpdate() is used for INSERT, UPDATE,
            // DELETE statements.It returns number of rows
            // affected by the execution of the statement
            int result = stmt.executeUpdate(query);

            // if result is greater than 0, it means values
            // has been added
            if (result > 0)
                System.out.println("new column added.");
            else
                System.out.println(
                        "unable to add a column.");

            // closing connection
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
