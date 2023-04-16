package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class UsingHashmap {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            DatabaseUtil.createTable(conn);

            HashMap<int,Data> dataList = new HashMap<int,Data>();

            dataList.put(1,new Data("JAVA Esdition", "James Gosling", 300));
            dataList.put(2,new Data("Maths", "Aryabhatta", 390));
            dataList.put(3,new Data("Wings of fire", "Abdul kalam", 450));

            dataList.put(4,new Data("Panipat","vishwas patil",230));
            dataList.put(5,new Data("Mrityunjaya","shivaji sawant",230));


            //insert data
            //here convert hashmap values to the arraylist
            DatabaseUtil.insertData(conn,new ArrayList<>(dataList.values()));

            //read data
            DatabaseUtil.readData(conn);

            //update data
            DatabaseUtil.updateData(conn,new Data("Wings of fire", "Abdul kalam", 950), 3);

            //delete data
            DatabaseUtil.deleteData(conn,3);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

