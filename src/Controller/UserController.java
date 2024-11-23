package Controller;

import DAO.User.UserDAO;
import DAO.User.UserDAOImp;
import Model.User;

import java.util.List;

public class UserController {
    private static UserDAO userDAOImp = new UserDAOImp();

    public static String checkLogin(User user){

        return userDAOImp.checkUser(user.getName(),user.getPassword());
    }

    public static boolean addUser(User user){
        return userDAOImp.addUser(user);
    }

    public static User getByName(String name){
        return userDAOImp.getByName(name);
    }

    public static List<User> getAllUsers(){
        return userDAOImp.getAllUsers();
    }

    public static boolean updateUser(User user){
        return userDAOImp.updateUser(user.getId(),user.getName(),user.getRole());
    }

    public static boolean deleteUser(int id){
        return userDAOImp.deleteUser(id);
    }
}
