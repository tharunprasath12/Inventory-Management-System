import Controller.UserController;
import DAO.User.UserDAOImp;
import Model.User;
import View.UserView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User();

        System.out.println("\t Welcome to IMS - Inventory Management System");
        System.out.println("\t please login");

        System.out.print("\t Enter username ");
        user.setName(input.nextLine());

        System.out.print("\t Enter password ");
        user.setPassword(input.nextLine());

        String result = UserController.checkLogin(user);

        if(result == null)
            System.out.println("\t Invalid username or password");
        else if(result.equals("staff"))
            UserView.staffMenu();
        else if(result.equals("manager"))
            UserView.managerMenu();
        else if(result.equals("admin"))
            UserView.adminMenu();
        else
            System.out.println("\t Invalid ! Exiting application.");
    }
}