/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dao;

import pos.layered01.dao.custom.impl.CustomerDAOImpl;
import pos.layered01.dao.custom.impl.ItemDAOImpl;
import pos.layered01.dao.custom.impl.OrderDAOImpl;
import pos.layered01.dao.custom.impl.OrderDetailDAOImpl;

/**
 *
 * @author kasun
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInsance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }

        return daoFactory;
    }

    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();

            default:
                return null;
        }
    }

    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDERDETAIL
    }
}
