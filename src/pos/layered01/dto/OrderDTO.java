/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.dto;

import java.util.List;

/**
 *
 * @author kasun
 */
public class OrderDTO {
    private String orderId;
    private String custId;
    private List<OrderDetailDTO> orderDetailDTOs;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String custId, List<OrderDetailDTO> orderDetailDTOs) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderDetailDTOs = orderDetailDTOs;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the orderDetailDTOs
     */
    public List<OrderDetailDTO> getOrderDetailDTOs() {
        return orderDetailDTOs;
    }

    /**
     * @param orderDetailDTOs the orderDetailDTOs to set
     */
    public void setOrderDetailDTOs(List<OrderDetailDTO> orderDetailDTOs) {
        this.orderDetailDTOs = orderDetailDTOs;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", custId=" + custId + ", orderDetailDTOs=" + orderDetailDTOs + '}';
    }
    
    
}
