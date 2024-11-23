package DAO.Supplier;

import DAO.DbConnection;
import Model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImp implements SupplierDAO {

    Connection con;
    public SupplierDAOImp(){
        con = DbConnection.getConnection();
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        String sql = "INSERT INTO SUPPLIER(NAME,CONTACT) VALUES(?,?)";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,supplier.getName());
            ps.setLong(2,supplier.getContact());
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            System.out.print("Sql exception");
        }
        return false;
    }

    @Override
    public Supplier getSupplier(int id, String name) {
        String sql = "SELECT * FROM SUPPLIER WHERE ID = ? AND NAME = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.setString(2,name);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Supplier(rs.getInt("id"),rs.getString("name"),rs.getLong("contact"));
            }
        }
        catch (SQLException e){
            System.out.print("Sql exception");
        }
        return null;
    }

    @Override
    public List<Supplier> getAllSupplier() {
        List<Supplier> al = new ArrayList<>();
        String sql = "SELECT * FROM SUPPLIER";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                al.add(new Supplier(rs.getInt("id"),rs.getString("name"),rs.getLong("contact")));
            }
        }
        catch (SQLException e){
            System.out.print("Sql exception");
        }
        return al;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        String sql ="UPDATE SUPPLIER SET CONTACT = ? WHERE ID = ? AND NAME = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setLong(1,supplier.getContact());
            ps.setInt(2,supplier.getId());
            ps.setString(3,supplier.getName());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        String sql = "DELETE FROM SUPPLIER WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }
        return false;
    }
}
