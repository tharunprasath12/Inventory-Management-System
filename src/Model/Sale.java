package Model;

public class Sale {
    int id;
    int itemId;
    int quantity;
    String saleDate;

    public Sale(){
        id = quantity = itemId = 0;
        saleDate = "";
    }
    public Sale(int id, int itemId, int quantity, String saleDate) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

}
