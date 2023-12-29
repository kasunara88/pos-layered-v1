/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao.custom.impl;

import java.util.ArrayList;
import pos.layered01.dao.CrudUtil;
import pos.layered01.dao.custom.OrderDAO;
import pos.layered01.entity.OrderEntity;

/**
 *
 * @author kasun
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public boolean add(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES (?,?,?)", t.getOrderID(),t.getDate(),t.getCustID());
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
         return null;
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
        return null;
    }
    
}
