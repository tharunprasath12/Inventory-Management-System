package View;

import Controller.SupplierController;
import Model.Supplier;

import java.util.List;
import java.util.Scanner;

public class SupplierView {
    public static Scanner input = new Scanner(System.in);


    public static void manageSuppliers(){
        System.out.println("\n\t Manage Suppliers");
        System.out.println("\t 1. Add Suppliers");
        System.out.println("\t 2. View all Suppliers");
        System.out.println("\t 3. View Suppliers");
        System.out.println("\t 4. Update Suppliers");
        System.out.println("\t 5. Delete Suppliers");
        handleItemsInput();
    }

    private static void handleItemsInput(){
        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                SupplierView.addSupplier();
                break;
            case 2:
                SupplierView.viewAllSupplier();
                break;
            case 3:
                SupplierView.viewSupplier();
                break;
            case 4:
                SupplierView.updateSupplier();
                break;
            case 5:
                SupplierView.deleteSupplier();
                break;
            default:
                System.out.println("\t Invaild choice");
        }

    }
    public static void addSupplier() {
        Supplier supplier = new Supplier();

        System.out.print("\t Enter the name: ");
        supplier.setName(input.nextLine());
        System.out.print("\t Enter the contact no.: ");
        supplier.setContact(Long.valueOf(input.nextLine()));

        if(SupplierController.addSupplier(supplier)){
            System.out.println("\t Supplier is added successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }


    private static void viewAllSupplier() {
        List<Supplier> suppliers = SupplierController.getAllSuppliers();

        if(suppliers == null || suppliers.isEmpty())
            System.out.println("\t No Suppliers till now");
        else{
            System.out.println("\t All the suppliers are:");
            for(Supplier i: suppliers){
                System.out.println("\t "+i.getId()+" "+i.getName()+" "+i.getContact());
            }
        }
    }

    private static void viewSupplier() {
        System.out.print("\t Enter the supplier id: ");
        int id = Integer.valueOf(input.nextLine());
        System.out.print("\t Enter the supplier name: ");
        String name = input.nextLine();

        Supplier supplier = SupplierController.getSupplier(id,name);
        if(supplier == null)
            System.out.println("Invaild supplier id or name");
        else
            System.out.println("\t "+supplier.getId()+" "+supplier.getName()+" "+supplier.getContact());
    }

    private static void updateSupplier() {
        Supplier supplier = new Supplier() ;

        System.out.print("\t Enter the supplier id: ");
        supplier.setId(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the supplier name: ");
        supplier.setName(input.nextLine());
        System.out.print("\t Enter the supplier contact number: ");
        supplier.setContact(Long.valueOf(input.nextLine()));

        if(SupplierController.updateSupplier(supplier))
            System.out.println("\t Supplier is updated successfully");
        else
            System.out.println("Invaild supplier id and name");
    }

    private static void deleteSupplier() {
        System.out.print("\t Enter the id: ");
        int id = Integer.valueOf(input.nextLine());

        if(SupplierController.deleteSupplier(id)){
            System.out.println("\t Supplier is deleted successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }

}
