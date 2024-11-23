package DAO.Sale;

import Controller.ItemController;
import DAO.DbConnection;
import Model.Sale;
import Model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAOImp implements SaleDAO {
    Connection con;
    public SaleDAOImp(){
        con = DbConnection.getConnection();
    }
    @Override
    public boolean addSale(Sale sale) {
        String sql = "INSERT INTO SALE(ITEMID,QUANTITY,DATE) VALUES(?,?,?)";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,sale.getItemId());
            ps.setInt(2,sale.getQuantity());
            ps.setString(3,sale.getSaleDate());
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            System.out.print("Sql exception" + e);
        }
        return false;
    }

    @Override
    public Sale getSaleById(int id) {
        String sql = "SELECT * FROM SALE WHERE ID = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Sale(
                        rs.getInt("id"),
                        rs.getInt("itemid"),
                        rs.getInt("quantity"),
                        rs.getString("date")
                );
            }
        }
        catch (SQLException e){
            System.out.print("Sql exception");
        }
        return null;
    }

    @Override
    public List<Sale> getAllSales() {
        List<Sale> al = new ArrayList<>();
        String sql = "SELECT * FROM SALE";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                al.add(new Sale(
                        rs.getInt("id"),
                        rs.getInt("itemid"),
                        rs.getInt("quantity"),
                        rs.getString("date"))
                );
            }
        }
        catch (SQLException e){
            System.out.print("Sql exception"+e);
        }
        return al;
    }

    @Override
    public boolean deleteSale(int id) {
        String sql = "DELETE FROM SALE WHERE ID = ?";
        String sqlGet = "SELECT * FROM SALE WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement psGet = con.prepareStatement(sqlGet)
        ){
            psGet.setInt(1,id);
            ResultSet rs = psGet.executeQuery();

            if(rs.next()){
                ItemController.updateItemQuantity(rs.getInt("itemid"),rs.getInt("quantity"));
            }
            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }
        return false;
    }

}
