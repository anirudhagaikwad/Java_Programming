package jdbcExamples;
/*
Downloading the Driver
The PostgreSQL JDBC driver (postgresql-<version>.jar) can be downloaded from:
    Official website: https://jdbc.postgresql.org/
    Maven Repository: https://mvnrepository.com/artifact/org.postgresql/postgresql
    
-> psql -U postgres
    
#### 1. Introduction to JDBC  
JDBC (Java Database Connectivity) is an API that allows Java applications to interact with relational databases. It provides a standard interface for connecting to a database, executing queries, and handling results.  

#### 2. Purpose of JDBC  
- Provides a uniform interface for database interaction.  
- Supports different database vendors without code modifications.  
- Enables CRUD (Create, Read, Update, Delete) operations.  
- Facilitates transaction management and connection pooling.  

---

### 3. JDBC Architecture  
JDBC follows a layered architecture consisting of:  
1. JDBC API – Provides standard methods for database interaction.  
2. JDBC Driver Manager – Manages the registered database drivers.  
3. JDBC Drivers – Communicate with the database.  
4. Database – Stores and retrieves data.  

---

### 4. Types of JDBC Drivers  
JDBC provides four types of drivers:  

| Type | Name | Description | Pros | Cons |
|----------|---------|----------------|----------|----------|
| Type 1 | JDBC-ODBC Bridge Driver | Uses ODBC driver to connect to the database. | Simple to use | Performance issues, requires ODBC driver |
| Type 2 | Native API Driver | Uses vendor-specific libraries to communicate with the database. | Better performance than Type 1 | Platform-dependent |
| Type 3 | Network Protocol Driver | Uses a middleware server to communicate with the database. | Supports multiple databases | Requires additional server setup |
| Type 4 | Thin Driver (Pure Java) | Directly connects to the database using database-specific protocols. | Best performance, portable | Database-dependent |

---

### 5. Steps to Use JDBC  
JDBC follows a series of steps for database interaction:  

1. Load the Driver – Load the database-specific driver.  
2. Establish a Connection – Use `DriverManager` to establish a connection.  
3. Create a Statement – Create SQL statements using `Statement`, `PreparedStatement`, or `CallableStatement`.  
4. Execute Query – Run SQL queries using `executeQuery()` or `executeUpdate()`.  
5. Process the Results – Retrieve and process the query results.  
6. Close the Connection – Close all database resources.  

---

### 6. JDBC Interfaces and Classes  
| Component | Description |
|--------------|----------------|
| DriverManager | Manages database drivers and establishes connections. |
| Connection | Represents a connection to the database. |
| Statement | Executes SQL queries and returns results. |
| PreparedStatement | Precompiled SQL statements for better performance. |
| CallableStatement | Used for calling stored procedures. |
| ResultSet | Stores and processes query results. |
| SQLException | Handles SQL-related exceptions. |

---

### 7. Statements in JDBC  
| Statement Type | Usage | Characteristics |
|--------------------|----------|--------------------|
| Statement | Executes static SQL queries. | No query parameterization, slower. |
| PreparedStatement | Executes precompiled SQL queries. | Faster, supports query parameterization. |
| CallableStatement | Calls stored procedures. | Used for complex transactions. |

---

### 8. ResultSet and Its Types  
ResultSet allows traversal of query results.  

| Type | Description |
|----------|----------------|
| Forward-Only | Moves forward only. Default type. |
| Scrollable | Moves forward and backward. |
| Updatable | Allows updating retrieved records. |

ResultSet Concurrency Modes:  
- READ_ONLY – Cannot modify results.  
- UPDATABLE – Allows modification of data.  

---

### 9. Transaction Management in JDBC  
JDBC supports transaction control for ensuring data integrity.  

| Method | Purpose |
|-----------|------------|
| `setAutoCommit(false)` | Disables auto-commit mode. |
| `commit()` | Commits the transaction. |
| `rollback()` | Rolls back the transaction in case of failure. |

---

### 10. Connection Pooling  
- What is Connection Pooling?  
  Connection pooling reuses database connections instead of creating new ones, improving performance.  
- JDBC Connection Pool Implementations:  
  - Apache DBCP (Database Connection Pooling)  
  - HikariCP  
  - C3P0  

---

### 11. Stored Procedures and CallableStatement  
JDBC allows calling stored procedures from databases using `CallableStatement`. Stored procedures improve performance by reducing network traffic.

---

### 12. Handling BLOB and CLOB Data  
JDBC allows handling large binary and character data types.  

| Data Type | Usage |
|--------------|----------|
| BLOB (Binary Large Object) | Stores images, videos, or other binary data. |
| CLOB (Character Large Object) | Stores large text data. |

---

### 13. JDBC Batch Processing  
- Executes multiple queries in a batch for performance improvement.  
- Reduces network calls.  
- Uses `addBatch()` and `executeBatch()`.  

---

### 14. Common JDBC Exceptions  
| Exception | Cause |
|-------------|---------|
| SQLException | General SQL error. |
| SQLTimeoutException | Query execution timeout. |
| SQLSyntaxErrorException | Incorrect SQL syntax. |
| SQLIntegrityConstraintViolationException | Constraint violation (e.g., primary key conflict). |

---

### 15. Advantages of JDBC  
- Platform-independent.  
- Supports multiple databases.  
- Provides transaction management.  
- Offers connection pooling.  
- Improves security through prepared statements.  

---

### 16. Disadvantages of JDBC  
- Requires manual resource management.  
- Performance overhead compared to ORM frameworks like Hibernate.  
- More boilerplate code compared to modern data access technologies.  

---

### 17. JDBC vs Hibernate  
| Feature | JDBC | Hibernate |
|------------|--------|------------|
| Complexity | Requires more code | Simplifies database access |
| Performance | Fast for simple queries | Optimized for complex queries |
| Query Language | Uses SQL directly | Uses HQL (Hibernate Query Language) |
| Caching | No built-in caching | Supports first- and second-level caching |
| Database Independence | Database-dependent | More flexible with multiple databases |

---

### 18. When to Use JDBC?  
- When working on simple applications.  
- When performance is a priority.  
- When database operations are minimal.  

---

### 19. JDBC in Modern Java Applications  
- Often used with ORM frameworks like Hibernate.  
- JDBC DataSource is preferred over `DriverManager` for better connection management.  
- Integrated with Spring JDBC for ease of use.  

---
 
*/
import java.sql.*;
import java.util.Scanner;

/**
 * This program provides a menu-driven approach to manage a PostgreSQL database
 * using JDBC, covering CREATE, INSERT, DELETE, UPDATE, SHOW, and DESCRIBE operations.
 */
public class PostgreSQLJDBC {

    // Database connection details
   // private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String URL = "jdbc:postgresql://localhost:5432/employee?sslmode=disable";
    private static final String DB_NAME = "testdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "yourpassword";

    static Scanner scanner = new Scanner(System.in);

    /**
     * 🏆 Create a new database dynamically
     */
    public static void createDatabase(String dbName) {
        String sql = "CREATE DATABASE " + dbName;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Database '" + dbName + "' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    /**
     * 🏆 Create a new table dynamically
     */
    public static void createTable(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                     "id SERIAL PRIMARY KEY, " +
                     "name VARCHAR(100) NOT NULL, " +
                     "age INT NOT NULL, " +
                     "salary DECIMAL(10,2) NOT NULL)";
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * 🏆 Insert data into a specific table
     */
    public static void insertData(String tableName, String name, int age, double salary) {
        String sql = "INSERT INTO " + tableName + " (name, age, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Data inserted into '" + tableName + "' successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

    /**
     * 🏆 Delete a specific row by ID
     */
    public static void deleteRow(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting row: " + e.getMessage());
        }
    }

    /**
     * 🏆 Update table values dynamically
     */
    public static void updateData(String tableName, int id, String newName, int newAge, double newSalary) {
        String sql = "UPDATE " + tableName + " SET name = ?, age = ?, salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setDouble(3, newSalary);
            pstmt.setInt(4, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row with ID " + id + " updated successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
    }

    /**
     * 🏆 Show all data from a specific table
     */
    public static void showTable(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Data in table '" + tableName + "':");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving table data: " + e.getMessage());
        }
    }

    /**
     * 🏆 Describe table structure
     */
    public static void describeTable(String tableName) {
        String sql = "SELECT column_name, data_type FROM information_schema.columns WHERE table_name = ?";
        try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tableName);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Structure of table '" + tableName + "':");
            while (rs.next()) {
                System.out.println(rs.getString("column_name") + " - " + rs.getString("data_type"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving table structure: " + e.getMessage());
        }
    }

    // Method to show all tables
    public static void showAllTables() {
        String query = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";  // Query to fetch table names
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("List of Tables in Database:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("tablename"));  // Fetch table name column
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    public static void main(String[] args) {
        int choice;
        String tableName;
        
        while (true) {
            System.out.println("\n===== PostgreSQL JDBC Menu =====");
            System.out.println("1. Create Database");
            System.out.println("2. Create Table");
            System.out.println("3. Insert Data");
            System.out.println("4. Delete Row");
            System.out.println("5. Update Row");
            System.out.println("6. Show Table Data");
            System.out.println("7. Describe Table");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter database name: ");
                    String dbName = scanner.nextLine();
                    createDatabase(dbName);
                    break;
                case 2:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    createTable(tableName);
                    break;
                case 3:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    insertData(tableName, name, age, salary);
                    break;
                case 4:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter row ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    deleteRow(tableName, idToDelete);
                    break;
                case 5:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter row ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    updateData(tableName, idToUpdate, newName, newAge, newSalary);
                    break;
                case 6:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    showTable(tableName);
                    break;
                case 7:
                    System.out.print("Enter table name: ");
                    tableName = scanner.nextLine();
                    describeTable(tableName);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

