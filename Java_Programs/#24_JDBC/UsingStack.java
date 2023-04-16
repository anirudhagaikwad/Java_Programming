package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class UsingStack {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            DatabaseUtil.createTable(conn);

            Stack<Data> dataList = new Stack<>();

            dataList.push(new Data("JAVA Edition", "James Gosling", 300));
            dataList.push(new Data("Maths", "Aryabhatta", 390));
            dataList.push(new Data("Wings of fire", "Abdul kalam", 450));

            dataList.pop();
            dataList.push(new Data("Shyamachi Aai", "sane guruji", 150));

            //insert data
            if(!dataList.empty()){
                DatabaseUtil.insertData(conn, dataList);
            }

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

