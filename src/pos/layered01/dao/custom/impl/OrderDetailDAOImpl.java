/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao.custom.impl;

import java.util.ArrayList;
import pos.layered01.dao.CrudUtil;
import pos.layered01.dao.custom.OrderDetailDAO;
import pos.layered01.entity.OrderDetailEntity;

/**
 *
 * @author kasun
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean add(OrderDetailEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO OrderDetail VALUES (?,?,?,?)", t.getOrderID(),t.getItemCode(),t.getQty(),t.getDiscount());
   }

    @Override
    public boolean update(OrderDetailEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Object id) throws Exception {
        return false;
    }

    @Override
    public OrderDetailEntity get(Object id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws Exception {
        return null;
    }
    
}
