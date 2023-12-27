/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.controller;

import pos.layered01.dto.CustomerDTO;
import pos.layered01.service.ServiceFactory;
import pos.layered01.service.custom.CustomerService;

/**
 *
 * @author kasun
 */
public class CustomerController {

    CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String addCustomer(CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }
}
