package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url="jdbc:mysql:///ims";
    private static final String name="tharun";
    private static final String password="Tharun@123";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,name,password);
        }
        catch (SQLException e){
            System.out.print("SQL Exception"+e);
        }
        return null;
    }
    public static void closeConnection(Connection con){
        try{
            con.close();
        }
        catch(SQLException e){
            System.out.print("SQL Exception"+e);
        }
    }
}
