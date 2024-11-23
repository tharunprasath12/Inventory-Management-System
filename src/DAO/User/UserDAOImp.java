package DAO.User;

import DAO.DbConnection;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {

    private Connection con;

    public UserDAOImp(){
        con = DbConnection.getConnection();
    }
    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO USER(NAME,PASSWORD,ROLE) VALUES(?,?,?)";
        int status = 0;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getRole());

            status = ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("SQL exception" + e);
        }
        return status > 0;
    }

    @Override
    public User getByName(String name) {
        String sql = "SELECT * FROM USER WHERE NAME = ?";
        User user = null;
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getString("role"));
            }
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> al = new ArrayList<>();
        String sql =  "SELECT * FROM USER";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                al.add( new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        }
        catch(SQLException e){
            System.out.println("SQLException" + e);
        }

        return al;
    }

    @Override
    public boolean updateUser(int id,String name,String role) {
        String sql = "UPDATE USER SET NAME = ?, ROLE = ? WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,name);
            ps.setString(2,role);
            ps.setInt(3,id);

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM USER WHERE ID = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    public boolean updatePassword(String password,int id){
        String sql = "UPDATE USER SET PASSWORD = ? WHERE ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, password);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
        }

        return false;
    }

    public String checkUser(String name,String password){
        String sql = "SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,name);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getString("role");
            }
        }catch(SQLException e){
            System.out.println("SQL Exception" + e);
        }

        return null;
    }
}
