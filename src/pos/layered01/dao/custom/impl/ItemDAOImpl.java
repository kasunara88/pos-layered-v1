/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pos.layered01.dao.CrudUtil;
import pos.layered01.dao.custom.ItemDAO;
import pos.layered01.entity.ItemEntity;

/**
 *
 * @author kasun
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?,?)",
                t.getItemCode(), t.getDescription(), t.getPacksize(), t.getUnitprice(), t.getQtyOnHand());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET Description=?,Packsize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?",
                t.getDescription(), t.getPacksize(), t.getUnitprice(), t.getQtyOnHand(), t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Item WHERE ItemCode=?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM Item WHERE ItemCode=?", id);

        while (result.next()) {
            ItemEntity ie = new ItemEntity(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getInt(5));

            return ie;
        }
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = new ArrayList<>();
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM Item");
        while (result.next()) {
            ItemEntity ie = new ItemEntity(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getInt(5));

            itemEntitys.add(ie);
        }
        return itemEntitys;
    }

}
