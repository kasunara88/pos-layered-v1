/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.service;

import pos.layered01.service.custom.customerserviceimpl.CustomerServiceImpl;
import pos.layered01.service.custom.customerserviceimpl.ItemSrviceImpl;
import pos.layered01.service.custom.customerserviceimpl.OrderServiceImpl;

/**
 *
 * @author kasun
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemSrviceImpl();
            case ORDER:
                return new OrderServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        CUSTOMER, ITEM, ORDER,ORDERDETAIL
    }
}
