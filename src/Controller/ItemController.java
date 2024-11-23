package Controller;

import DAO.Item.ItemDAO;
import DAO.Item.ItemDAOImp;
import Model.Item;

import java.util.List;

public class ItemController {

    private static ItemDAO itemDAO = new ItemDAOImp();
    public static boolean addItem(Item item){
        return itemDAO.addItem(item);
    }

    public static List<Item> getAllItems(){
        return itemDAO.getAllItems();
    }

    public static Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    public static boolean updateItem(Item item){
        return itemDAO.updateItem(item);
    }

    public static boolean deleteItem(int id){
        return itemDAO.deleteItem(id);
    }

    public static boolean updateItemQuantity(int id,int quantity){
        return itemDAO.updateItemQuantity(id,quantity);
    }
}
