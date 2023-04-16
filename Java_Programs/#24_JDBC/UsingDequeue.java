package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

public class UsingDequeue {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            DatabaseUtil.createTable(conn);

            Deque<Data> dataList = new ArrayDeque<>();

            dataList.offer(new Data("JAVA Edition", "James Gosling", 300));
            dataList.offerLast(new Data("Maths", "Aryabhatta", 390));
            dataList.offerFirst(new Data("Wings of fire", "Abdul kalam", 450));

            //insert data
            DatabaseUtil.insertData(conn, dataList);

            //read data
            DatabaseUtil.readData(conn);

            //update data
            DatabaseUtil.updateData(conn,new Data("Wings of fire", "Abdul kalam", 950), 3);

            //delete data
            DatabaseUtil.deleteData(conn,1);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
