package PPT23;
/*
Java Program to Join Contents of More than One Table & Display in JDBC
*/

import java.sql.*;

// Class for Joining of multiple tables
public class JavaProgram1 {

    // Main driver method
    public static void main(String[] args)
    {

        // Display message
        System.out.println(
                "Joining 2 MySQL tables using Natural Join");

        // DB 'Connection' object of Connection class
        Connection con = null;

        // Try block to check exceptions
        try {
            // Step 2: Load and register drivers

            // Loading driver
            // Jars(relevant) or mysql-connector-java-8.0.22
            // in build path of project
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creating jdbc connection

            // Registering driver


            // Step 3: Establishing a connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");
            Statement st=con.createStatement();
            // Try block to check java exceptions
            try {

                // Step 4: Write a statement
                ResultSet res = st.executeQuery(
                        "SELECT *FROM "
                                + "studentsdetails"
                                + " NATURAL JOIN "
                                + "studentspersonaldetails");

                // Step 5: Execute the query
                System.out.println(" StuName"
                        + " Gender"
                        + "	 Caste "
                        + "Neet Marks"
                        + "	 Email");

                // Step 6: Process the statements
                // Iterate the resultset and retrieve the required fields
                while (res.next()) {
                    String name = res.getString("Name");
                    String gender = res.getString("gender");
                    String caste = res.getString("caste");
                    String neetMarks
                            = res.getString("NeetMarks");
                    String email = res.getString("email");

                    // Beautification of output
                    System.out.format(
                            "%10s%10s%10s%10s%20s\n", name,
                            gender, caste, neetMarks, email);
                }

                // Step 7: Close the connection
                con.close();
            }

            // Catch block to handle DB exceptions
            catch (SQLException s) {

                // If there is error in SQL query, this exception occurs
                System.out.println(
                        "SQL statement is not executed!");
            }

            // Catch block to handle generic java exceptions
        }
        catch (Exception e) {

            // General exception apart from SQLException are caught here
            e.printStackTrace();
        }
    }
}

