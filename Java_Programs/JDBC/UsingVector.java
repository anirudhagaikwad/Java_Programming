package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

public class UsingVector {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?au" +
                    "toReconnect=true&useSSL=false","root","vaibhu");

            DatabaseUtil.createTable(conn);

            Collection<Data> dataList = new Vector<Data>();
            dataList.add(new Data("JAVA Edition", "James Gosling", 300));
            dataList.add(new Data("Maths", "Aryabhatta", 390));
            dataList.add(new Data("Wings of fire", "Abdul kalam", 450));

            Vector favbooks=new Vector<Data>();
            favbooks.add(new Data("Panipat","vishwas patil",230));
            favbooks.add(new Data("Mrityunjaya","shivaji sawant",230));
            dataList.addAll(favbooks);

            //insert data
            DatabaseUtil.insertData(conn, dataList);

            //read data
            DatabaseUtil.readData(conn);

            //update data
            DatabaseUtil.updateData(conn,new Data("Wings of fire", "Abdul kalam", 950), 3);

            //delete data
            DatabaseUtil.deleteData(conn,2);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

