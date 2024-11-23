package DAO.Sale;

import Model.Sale;

import java.util.List;

public interface SaleDAO {
    boolean addSale(Sale sale);
    Sale getSaleById(int id);
    List<Sale> getAllSales();
    boolean deleteSale(int id);

}
