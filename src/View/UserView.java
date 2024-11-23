package View;

import Controller.ItemController;
import Controller.SaleController;
import Controller.UserController;
import Model.Sale;
import Model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserView {

    public static Scanner input = new Scanner(System.in);

    public static void staffMenu(){
        System.out.println("\n\t --- Staff Menu ---");
        System.out.println("\t 1. View all items");
        System.out.println("\t 2. View item");
        System.out.println("\t 3. Record a sale");
        System.out.println("\t 4. Logout");
        handleStaffInput();
    }

    private static void handleStaffInput() {
        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                ItemView.viewAllItem();
                staffMenu();
                break;
            case 2:
                ItemView.viewItem();
                staffMenu();
                break;
            case 3:
                SaleView.addSale();
                staffMenu();
                break;
            case 4:
                System.out.println("\t logged out");
                break;
            default:
                System.out.println("\t Invaild choice");
                staffMenu();
        }
    }

    public static void managerMenu(){
        System.out.println("\n\t --- Manager Menu ---");
        System.out.println("\t 1. View all items");
        System.out.println("\t 2. View item");
        System.out.println("\t 3. Manage sales");
        System.out.println("\t 4. Manage suppliers");
        System.out.println("\t 5. Logout");
        handleManagerInput();
    }

    private static void handleManagerInput() {

        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                ItemView.viewAllItem();
                managerMenu();
                break;
            case 2:
                ItemView.viewItem();
                managerMenu();
                break;
            case 3:
                SaleView.manageSales();
                managerMenu();
                break;
            case 4:
                SupplierView.manageSuppliers();
                managerMenu();
                break;
            case 5:
                System.out.println("\t logged out");
                break;
            default:
                System.out.println("\t Invaild choice");
                managerMenu();
        }
    }

    public static void adminMenu(){
        System.out.println("\n\t --- Admin Menu ---");
        System.out.println("\t 1. Manage users");
        System.out.println("\t 2. Manage items");
        System.out.println("\t 3. Manage sales");
        System.out.println("\t 4. Manage suppliers");
        System.out.println("\t 5. Logout");
        handleAdminInput();
    }

    private static void handleAdminInput() {

        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                manageUsers();
                adminMenu();
                break;
            case 2:
                ItemView.manageItems();
                adminMenu();
                break;
            case 3:
                SaleView.manageSales();
                adminMenu();
                break;
            case 4:
                SupplierView.manageSuppliers();
                adminMenu();
                break;
            case 5:
                System.out.println("\t logged out");
                break;
            default:
                System.out.println("\t Invaild choice");
                adminMenu();
        }
    }

    ///
    public static void manageUsers(){
        System.out.println("\n\t Manage users");
        System.out.println("\t 1. Add user");
        System.out.println("\t 2. View all users");
        System.out.println("\t 3. View user");
        System.out.println("\t 4. Update user");
        System.out.println("\t 5. Delete user");
        handleItemsInput();
    }

    private static void handleItemsInput(){

        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                UserView.addUser();
                break;
            case 2:
                UserView.viewAllUser();
                break;
            case 3:
                UserView.viewUser();
                break;
            case 4:
                UserView.updateUser();
                break;
            case 5:
                UserView.deleteUser();
                break;
            default:
                System.out.println("\t Invaild choice");
        }

    }
    public static void addUser() {
        User user = new User();

        System.out.print("\t Enter the name: ");
        user.setName(input.nextLine());
        System.out.print("\t Enter the password: ");
        user.setPassword(input.nextLine());
        System.out.print("\t Enter the role: ");
        user.setRole(input.nextLine());

        if(UserController.addUser(user)){
            System.out.println("\t User is added successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }


    private static void viewAllUser() {
        List<User> user = UserController.getAllUsers();

        if(user == null)
            System.out.println("\t No users till now");
        else{
            System.out.println("\t All the users are:");
            for(User i: user){
                System.out.println("\t "+i.getId()+" "+i.getName()+" "+i.getPassword()+" "+i.getRole());
            }
        }
    }

    private static void viewUser() {
        System.out.print("\t Enter the name: ");
        String name = input.nextLine();

        User user = UserController.getByName(name);
        if(user == null)
            System.out.println("Invaild user name");
        else
            System.out.println("\t "+user.getId()+" "+user.getName()+" "+user.getPassword()+" "+user.getRole());
    }

    private static void updateUser(){
        User user = new User();

        System.out.print("\t Enter the id: ");
        user.setId(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the name: ");
        user.setName(input.nextLine());
        System.out.print("\t Enter the role: ");
        user.setRole(input.nextLine());

        if(UserController.updateUser(user)){
            System.out.println("\t User is updated successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }

    private static void deleteUser() {
        System.out.print("\t Enter the user id: ");
        int id = Integer.valueOf(input.nextLine());

        if(UserController.deleteUser(id)){
            System.out.println("\t User is deleted successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }
}
