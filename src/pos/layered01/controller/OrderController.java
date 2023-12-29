/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.controller;

import pos.layered01.dto.OrderDTO;
import pos.layered01.service.ServiceFactory;
import pos.layered01.service.custom.OrderService;

/**
 *
 * @author kasun
 */
public class OrderController {
    OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    
    public String placeOrder(OrderDTO orderDTO) throws Exception {
        return orderService.placeOrder(orderDTO);
    }
    
}
