package examples;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {
    // Database credentials (Modify as needed)
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Connection method
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // 1️⃣ Create Table
    private static void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS employees (id SERIAL PRIMARY KEY, name VARCHAR(50), age INT, department VARCHAR(50))";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("✅ Table 'employees' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2️⃣ Insert Record
    private static void insertRecord(String name, int age, String department) {
        String query = "INSERT INTO employees (name, age, department) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("✅ Record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3️⃣ Update Record
    private static void updateRecord(int id, String name, int age, String department) {
        String query = "UPDATE employees SET name=?, age=?, department=? WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Record updated successfully." : "❌ No record found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4️⃣ Delete Record
    private static void deleteRecord(int id) {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Record deleted successfully." : "❌ No record found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5️⃣ Display All Records
    private static void displayRecords() {
        String query = "SELECT * FROM employees";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📋 Employee Records:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d | Department: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 6️⃣ Describe Table Structure
    private static void describeTable() {
        String query = "SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'employees'";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📌 Table Structure of 'employees':");
            while (rs.next()) {
                System.out.printf("Column: %s | Type: %s%n", rs.getString("column_name"), rs.getString("data_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 7️⃣ Show All Tables
    private static void showAllTables() {
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("📌 List of Tables in Database:");
            while (rs.next()) {
                System.out.println(rs.getString("table_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🏁 Menu-driven program
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
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTable();
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    insertRecord(name, age, dept);
                    break;
                case 3:
                    System.out.print("Enter ID to Update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = scanner.nextLine();
                    updateRecord(idToUpdate, newName, newAge, newDept);
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int idToDelete = scanner.nextInt();
                    deleteRecord(idToDelete);
                    break;
                case 5:
                    displayRecords();
                    break;
                case 6:
                    describeTable();
                    break;
                case 7:
                    showAllTables();
                    break;
                case 8:
                    System.out.println("🚀 Exiting program...");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}

