package PPT23;
/*
Java Program to Search the Contents of a Table in JDBC
*/

// Importing required classes
import java.sql.*;

class connectionDB {

    final String DB_URL
            = "jdbc:mysql://localhost:3306/testDB?useSSL=false";

    // Database credentials

    // We need two parameters to access the database
    // Root and password

    // 1. Root
    final String USER = "root";

    // 2. Password to fetch database
    final String PASS = "Imei@123";

    // Connection class for our database connectivity
    public Connection connectDB()
    {
        // Initially setting NULL
        // to connection class object
        Connection con = null;

        // Try block to check exceptions
        try {

            // Loading DB(SQL) drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Registering SQL drivers
            con = DriverManager.getConnection(DB_URL, USER,
                    PASS);
        }

        // Catch block to handle database exceptions
        catch (SQLException e) {

            // Print the line number where exception occurs
            e.printStackTrace();
        }

        // Catch block to handle exception
        // if class not found
        catch (ClassNotFoundException e) {

            // Function prints the line number
            // where exception occurs
            e.printStackTrace();
        }

        // Returning Connection class object to
        // be used in (App/Main) GFG class
        return con;
    }
}

public class JavaProgram4 {

    public static void main(String[] args)
    {
        // Step 2: Establishing a connection
        connectionDB connection = new connectionDB();

        // Assigning NULL to object of Connection class
        // as shown returned by above program
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        // Step 3: Loading and registereding drivers
        // Loaded and registered in Connection class
        // shown in above program
        con = connection.connectDB();

        // Try block to check exceptions
        try {

            // Step 4: Write a statement
            String sql
                    = "select * from cuslogin where id=1";

            // Step 5: Execute the query
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Step 6: Process the results
            System.out.println(
                    "id\t\tname\t\temail\t\tpassword");

            // Condition check using next() method
            // Holds true till there is single element remaining
            // in the object
            if (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                // Print and display name, emailID and password
                System.out.println(id + "\t\t" + name
                        + "\t\t" + email + "\t\t"
                        + password);
            }
        }

        // Catch block to handle exceptions
        catch (SQLException e) {

            // Print the exception
            System.out.println(e);
        }
    }
}


