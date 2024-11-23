package View;

import Controller.ItemController;
import Model.Item;

import java.util.List;
import java.util.Scanner;

public class ItemView {

    public static Scanner input = new Scanner(System.in);


    public static void manageItems(){
        System.out.println("\n\t Manage items");
        System.out.println("\t 1. Add item");
        System.out.println("\t 2. View all items");
        System.out.println("\t 3. View item");
        System.out.println("\t 4. Update item");
        System.out.println("\t 5. Delete item");
        handleItemsInput();
    }

    private static void handleItemsInput() {

        System.out.print("\t Enter your choice: ");
        int choice = Integer.valueOf(input.nextLine());

        switch (choice){
            case 1:
                ItemView.addItem();
                break;
            case 2:
                ItemView.viewAllItem();
                break;
            case 3:
                ItemView.viewItem();
                break;
            case 4:
                ItemView.updateItem();
                break;
            case 5:
                ItemView.deleteItem();
                break;
            default:
                System.out.println("\t Invaild choice");
        }

    }

    public static void viewAllItem(){
        List<Item> items = ItemController.getAllItems();
        if (items == null || items.isEmpty()) {
            System.out.println("\t No items available.");
        }
        else {
            System.out.println("\t All the items are:");
            for (Item i : items) {
                System.out.println("\t " + i.getId() + " " + i.getName() + " " + i.getCategory() + " " + i.getPrice() + " " + i.getQuantity());
            }
        }
    }

    public static void viewItem(){
        System.out.print("\t Enter the item id: ");

        Item item = ItemController.getItemById(Integer.valueOf(input.nextLine()));
        if(item == null)
            System.out.println("\t Invalid item id");
        else
            System.out.println("\t "+item.getId()+" "+item.getName()+" "+item.getCategory()+" "+item.getPrice()+" "+item.getQuantity());
    }

    private static void addItem() {
        Item item = new Item();

        System.out.print("\t Enter the name: ");
            item.setName(input.nextLine());
        System.out.print("\t Enter the category: ");
            item.setCategory(input.nextLine());
        System.out.print("\t Enter the price");
            item.setPrice(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the quantity: ");
            item.setQuantity(Integer.valueOf(input.nextLine()));

        if(ItemController.addItem(item))
            System.out.println("\t Item is added successfully");
        else
            System.out.println("\t some think went wrong");

    }

    private static void updateItem() {
        Item item = new Item();

        System.out.print("\t Enter the id: ");
        item.setId(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the category");
        item.setCategory(input.nextLine());
        System.out.print("\t Enter the price");
        item.setPrice(Integer.valueOf(input.nextLine()));
        System.out.print("\t Enter the quantity");
        item.setQuantity(Integer.valueOf(input.nextLine()));

        if(ItemController.updateItem(item))
            System.out.println("\t Item is updated successfully");
        else
            System.out.println("\t some think went wrong");

    }

    private static void deleteItem() {
        System.out.print("\t Enter the id: ");
        int id = Integer.valueOf(input.nextLine());

        if(ItemController.deleteItem(id))
            System.out.println("\t Item is deleted successfully");
        else
            System.out.println("\t some think went wrong");
    }

}
