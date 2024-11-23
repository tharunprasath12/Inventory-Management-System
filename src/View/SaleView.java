package View;

import Controller.ItemController;
import Controller.SaleController;
import Model.Item;
import Model.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class SaleView {
    public static Scanner input = new Scanner(System.in);


    public static void manageSales(){
        System.out.println("\n\t Manage sales");
        System.out.println("\t 1. Add sales");
        System.out.println("\t 2. View all sales");
        System.out.println("\t 3. View sales");
        System.out.println("\t 4. Delete sales");
        handleItemsInput();
    }

    private static void handleItemsInput(){
        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                SaleView.addSale();
                break;
            case 2:
                SaleView.viewAllSale();
                break;
            case 3:
                SaleView.viewSale();
                break;
            case 4:
                SaleView.deleteSale();
                break;
            default:
                System.out.println("\t Invaild choice");
        }

    }
    public static void addSale() {
        Sale sale = new Sale();

        System.out.print("\t Enter the item id: ");
            sale.setItemId(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the quantity: ");
            sale.setQuantity(Integer.valueOf(input.nextLine()));

        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            sale.setSaleDate(formattedDateTime);

        if(SaleController.addSales(sale)){
            System.out.println("\t Sales is added successfully");
            ItemController.updateItemQuantity(sale.getItemId(), -sale.getQuantity());
        }
        else
            System.out.println("\t some think went wrong");
    }


    private static void viewAllSale() {
        List<Sale> sales = SaleController.getAllSales();

        if(sales == null || sales.isEmpty())
            System.out.println("\t No sales till now");
        else{
            System.out.println("\t All the sales are:");
            for(Sale i: sales){
                System.out.println("\t "+i.getId()+" "+i.getItemId()+" "+i.getQuantity()+" "+i.getSaleDate());
            }
        }
    }

    private static void viewSale() {
        System.out.print("\t Enter the sale id: ");
            int id = Integer.valueOf(input.nextLine());

        Sale sale = SaleController.getSale(id);
        if(sale == null)
            System.out.println("Invaild sale id");
        else
            System.out.println("\t "+sale.getId()+" "+sale.getItemId()+" "+sale.getQuantity()+" "+sale.getSaleDate());
    }

    private static void deleteSale() {
        System.out.print("\t Enter the id: ");
        int id = Integer.valueOf(input.nextLine());

        if(SaleController.deleteSale(id)){
            System.out.println("\t Sale is deleted successfully");
        }
        else
            System.out.println("\t some think went wrong");
    }

}
