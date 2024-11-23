package DAO.User;

import Model.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    User getByName(String name);
    List<User> getAllUsers();
    boolean updateUser(int id,String name,String role);
    boolean deleteUser(int id);
    boolean updatePassword(String password,int id);

    String checkUser(String name,String password);
}
