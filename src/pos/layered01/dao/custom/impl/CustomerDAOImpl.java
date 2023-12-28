/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao.custom.impl;

import java.util.ArrayList;
import pos.layered01.dao.CrudUtil;
import pos.layered01.dao.custom.CustomerDAO;
import pos.layered01.entity.CustomerEntity;
import java.sql.ResultSet;

/**
 *
 * @author kasun
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)",
                t.getCustId(), t.getTitle(), t.getName(), t.getDob(), t.getSalary(),
                t.getAddress(), t.getCity(),
                t.getProvince(), t.getZip());
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Customer SET CustTitle=?,CustName =?,DOB =?,salary =?,CustAddress=?,City=?,Province=?,PostalCode=? WHERE CustID=?",
                t.getTitle(), t.getName(), t.getDob(), t.getSalary(), t.getAddress(), t.getCity(),
                t.getProvince(), t.getZip(), t.getCustId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE CustID=?",
                id);
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustID=?", id);

        while (result.next()) {
            CustomerEntity ce = new CustomerEntity(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9));
            return ce;
        }
        return null;

    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customerEntitys = new ArrayList<>();
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (result.next()) {
            CustomerEntity ce = new CustomerEntity(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9));
            customerEntitys.add(ce);
        }
        return customerEntitys;
    }

}
