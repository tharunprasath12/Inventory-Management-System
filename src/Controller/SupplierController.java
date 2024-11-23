package Controller;

import DAO.Supplier.SupplierDAO;
import DAO.Supplier.SupplierDAOImp;
import Model.Supplier;

import java.util.List;

public class SupplierController {
    private static SupplierDAO supplierDAO = new SupplierDAOImp();

    public static boolean addSupplier(Supplier supplier){
        return supplierDAO.addSupplier(supplier);
    }

    public static Supplier getSupplier(int id,String name){
        return supplierDAO.getSupplier(id,name);
    }

    public static List<Supplier> getAllSuppliers(){
        return supplierDAO.getAllSupplier();
    }

    public static boolean updateSupplier(Supplier supplier){
        return supplierDAO.updateSupplier(supplier);
    }

    public static boolean deleteSupplier(int id){
        return supplierDAO.deleteSupplier(id);
    }
}
