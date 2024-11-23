package DAO.Item;

import DAO.DbConnection;
import Model.Item;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImp implements ItemDAO {

    Connection con ;
    public ItemDAOImp(){
        con = DbConnection.getConnection();
    }
    @Override
    public boolean addItem(Item item) {
        String sql = "INSERT INTO ITEM (NAME, CATEGORY, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, item.getName());
            ps.setString(2, item.getCategory());
            ps.setInt(3,item.getPrice());
            ps.setInt(4,item.getQuantity());

            return ps.executeUpdate()>0;
        }
        catch (SQLException e){
            System.out.println("SQL exception" + e);
        }
        return false;
    }

    @Override
    public Item getItemById(int id) {
        String sql = "SELECT * FROM ITEM WHERE ID = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Item(rs.getInt("id"),rs.getString("name"),rs.getString("category"),rs.getInt("price"),rs.getInt("quantity"));
            }
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return null;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> al = new ArrayList<>();
        String sql =  "SELECT * FROM ITEM";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                al.add( new Item(rs.getInt("id"),rs.getString("name"),rs.getString("category"),rs.getInt("price"),rs.getInt("quantity")));
            }
        }
        catch(SQLException e){
            System.out.println("SQLException" + e);
        }

        return al;
    }

    @Override
    public boolean updateItem(Item item) {
        String sql = "UPDATE ITEM SET CATEGORY = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,item.getCategory());
            ps.setInt(2,item.getPrice());
            ps.setInt(3,item.getQuantity());
            ps.setInt(4,item.getId());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        String sql = "DELETE FROM ITEM WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    @Override
    public boolean updateItemQuantity(int id,int quantity){
        String sqlGet = "SELECT * FROM ITEM WHERE ID = ?";
        String sqlUpdate = "UPDATE ITEM SET QUANTITY = ? WHERE ID = ?";

        try(PreparedStatement psGet = con.prepareStatement(sqlGet) ;
            PreparedStatement psUpdate = con.prepareStatement(sqlUpdate)
        ){
            psGet.setInt(1,id);
            ResultSet rs = psGet.executeQuery();

            if(rs.next()){
                quantity = rs.getInt("quantity") + quantity;
            }

            psUpdate.setInt(1,quantity);
            psUpdate.setInt(2,id);

            return psUpdate.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }
}
