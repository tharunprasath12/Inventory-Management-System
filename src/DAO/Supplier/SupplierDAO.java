package DAO.Supplier;

import Model.Supplier;

import java.util.List;

public interface SupplierDAO {
    boolean addSupplier(Supplier supplier);
    Supplier getSupplier(int id,String Name);
    List<Supplier> getAllSupplier();
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id);
}
