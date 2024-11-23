package DAO.Item;

import Model.Item;

import java.util.List;

public interface ItemDAO {
    boolean addItem(Item item);
    Item getItemById(int id);
    List<Item> getAllItems();
    boolean updateItem(Item item);
    boolean deleteItem(int id);
    boolean updateItemQuantity(int id,int quantity);
}
