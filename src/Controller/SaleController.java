package Controller;

import DAO.Sale.SaleDAO;
import DAO.Sale.SaleDAOImp;
import Model.Sale;

import java.util.List;

public class SaleController {
    private static SaleDAO saleDAO = new SaleDAOImp();

    public static boolean addSales(Sale sale){
        return saleDAO.addSale(sale);
    }

    public static Sale getSale(int id){
        return saleDAO.getSaleById(id);
    }

    public static List<Sale> getAllSales(){
        return saleDAO.getAllSales();
    }

    public static boolean deleteSale(int id){
        return saleDAO.deleteSale(id);
    }

}
