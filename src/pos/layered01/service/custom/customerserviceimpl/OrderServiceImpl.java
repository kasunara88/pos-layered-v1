/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.service.custom.customerserviceimpl;

import pos.layered01.dao.DAOFactory;
import pos.layered01.dao.custom.ItemDAO;
import pos.layered01.dao.custom.OrderDAO;
import pos.layered01.dao.custom.OrderDetailDAO;
import pos.layered01.dto.OrderDTO;
import pos.layered01.service.custom.OrderService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import pos.layered01.db.DBConnection;
import pos.layered01.dto.OrderDetailDTO;
import pos.layered01.entity.ItemEntity;
import pos.layered01.entity.OrderDetailEntity;
import pos.layered01.entity.OrderEntity;

/**
 *
 * @author kasun
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = (OrderDAO) DAOFactory.getInsance().getDAO(DAOFactory.DAOType.ORDER);
    private OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInsance().getDAO(DAOFactory.DAOType.ORDERDETAIL);
    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getInsance().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public String placeOrder(OrderDTO orderDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (orderDAO.add(new OrderEntity(orderDTO.getOrderId(), sdf.format(new Date()),
                    orderDTO.getCustId()))) {

                boolean isOrderSave = true;
                for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailDTOs()) {
                    if (!orderDetailDAO.add(new OrderDetailEntity(orderDTO.getOrderId(),
                            orderDetailDTO.getItemCode(),
                            orderDetailDTO.getOrderQty(), orderDetailDTO.getDiscount()))) {

                        isOrderSave = false;
                    }
                }

                if (isOrderSave) {
                    boolean isItemUpdate = true;
                    for (OrderDetailDTO ordrDetailDTO : orderDTO.getOrderDetailDTOs()) {
                        ItemEntity itemEntity = itemDAO.get(ordrDetailDTO.getItemCode());
                        itemEntity.setQtyOnHand(itemEntity.getQtyOnHand() - ordrDetailDTO.getOrderQty());
                        if (!itemDAO.update(itemEntity)) {
                            isItemUpdate = false;
                        }
                    }
                    if (isItemUpdate) {
                        connection.setAutoCommit(true);
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
