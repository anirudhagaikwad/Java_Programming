package jdbc;

import java.sql.*;
import java.util.Collection;

public class DatabaseUtil {

    // create table in database
    public static void createTable(Connection conn){
        String q1="create table books(id int(10) primary key auto_increment,bookname varchar(20) not null,author varchar(30) not null,price int(20) )";

        try{
            //create statement
            Statement stmt=conn.createStatement();
            //call executeUpdate method because we are not fetching any data just updating it
            stmt.executeUpdate(q1);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    //insert data
    public static void insertData(Connection conn, Collection<Data> dataList) throws SQLException {

        String sql = "INSERT INTO books (bookname, author, price) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        for (Data data : dataList) {
            stmt.setString(1, data.getColumn1());
            stmt.setString(2, data.getColumn2());
            stmt.setInt(3, data.getColumn3());
            stmt.addBatch();
        }

        stmt.executeBatch();

        stmt.close();
    }

    //read data
    public static void readData(Connection conn) throws SQLException {

        String sql = "SELECT * FROM books";

        try {
            Statement stmt=conn.createStatement();
            //select all records from  table
            ResultSet result= stmt.executeQuery(sql);
            System.out.println("--------------------------------------");
            while (result.next()){
                String column1 = result.getString("column1");
                String column2 = result.getString("column2");
                int column3 = result.getInt("column3");
                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
                System.out.println("Column 3: " + column3);

            }
            System.out.println("--------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update data
    public static void updateData(Connection conn,Data dataList, int id) throws SQLException {

        String sql = "UPDATE books SET bookname = ?, author = ?, price = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, dataList.getColumn1());
            stmt.setString(2, dataList.getColumn2());
            stmt.setInt(3, dataList.getColumn3());
            stmt.setInt(3, id);

            stmt.executeUpdate();
            System.out.println("Record updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete data
    public static void deleteData(Connection conn, int id) throws SQLException {

        String sql = "DELETE FROM books WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Record deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Data {
    private String bookname;
    private String author;
    private int price;

    public Data(String bookname, String author, int price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public String getColumn1() {
        return bookname;
    }

    public String getColumn2() {
        return author;
    }

    public int getColumn3() {
        return price;
    }
}