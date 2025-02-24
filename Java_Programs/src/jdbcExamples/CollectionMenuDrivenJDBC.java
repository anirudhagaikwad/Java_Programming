package jdbcExamples;

import java.sql.*;
import java.util.*;

interface DatabaseOperations {
    void execute();
}

// 🔹 Class to Create Table (Using ArrayList)
class CreateTable implements DatabaseOperations {
    private static final String QUERY = "CREATE TABLE IF NOT EXISTS employees (id SERIAL PRIMARY KEY, name VARCHAR(50), age INT, department VARCHAR(50))";
    private final List<String> logs = new ArrayList<>();

    public void execute() {
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(QUERY);
            logs.add("Table 'employees' created successfully.");
            System.out.println("✅ " + logs.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Insert Records (Using LinkedList)
class InsertRecord implements DatabaseOperations {
    private final LinkedList<String> logs = new LinkedList<>();
    private final String name;
    private final int age;
    private final String department;

    public InsertRecord(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public void execute() {
        String query = "INSERT INTO employees (name, age, department) VALUES (?, ?, ?)";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            logs.add("Record inserted successfully.");
            System.out.println("✅ " + logs.getLast());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Update Records (Using Vector)
class UpdateRecord implements DatabaseOperations {
    private final Vector<String> logs = new Vector<>();
    private final int id;
    private final String name;
    private final int age;
    private final String department;

    public UpdateRecord(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public void execute() {
        String query = "UPDATE employees SET name=?, age=?, department=? WHERE id=?";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            logs.add(rows > 0 ? "Record updated successfully." : "No record found.");
            System.out.println("✅ " + logs.lastElement());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Delete Record (Using ArrayList)
class DeleteRecord implements DatabaseOperations {
    private final List<String> logs = new ArrayList<>();
    private final int id;

    public DeleteRecord(int id) {
        this.id = id;
    }

    public void execute() {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            logs.add(rows > 0 ? "Record deleted successfully." : "No record found.");
            System.out.println("✅ " + logs.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Display Records (Using LinkedList)
class DisplayRecords implements DatabaseOperations {
    private final LinkedList<String> records = new LinkedList<>();

    public void execute() {
        String query = "SELECT * FROM employees";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📋 Employee Records:");
            while (rs.next()) {
                String record = String.format("ID: %d | Name: %s | Age: %d | Department: %s",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("department"));
                records.add(record);
            }
            records.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Describe Table (Using Vector)
class DescribeTable implements DatabaseOperations {
    private final Vector<String> structure = new Vector<>();

    public void execute() {
        String query = "SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'employees'";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📌 Table Structure of 'employees':");
            while (rs.next()) {
                structure.add("Column: " + rs.getString("column_name") + " | Type: " + rs.getString("data_type"));
            }
            structure.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Class to Show All Tables (Using ArrayList)
class ShowAllTables implements DatabaseOperations {
    private final List<String> tables = new ArrayList<>();

    public void execute() {
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        try (Connection conn = CollectionMenuDrivenJDBC.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📌 List of Tables in Database:");
            while (rs.next()) {
                tables.add(rs.getString("table_name"));
            }
            tables.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 🔹 Main Class
public class CollectionMenuDrivenJDBC {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n📌 PostgreSQL JDBC Menu:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Display All Records");
            System.out.println("6. Describe Table");
            System.out.println("7. Show All Tables");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> new CreateTable().execute();
                case 2 -> new InsertRecord(scanner.nextLine(), scanner.nextInt(), scanner.nextLine()).execute();
                case 3 -> new UpdateRecord(scanner.nextInt(), scanner.nextLine(), scanner.nextInt(), scanner.nextLine()).execute();
                case 4 -> new DeleteRecord(scanner.nextInt()).execute();
                case 5 -> new DisplayRecords().execute();
                case 6 -> new DescribeTable().execute();
                case 7 -> new ShowAllTables().execute();
                case 8 -> System.out.println("🚀 Exiting program...");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
