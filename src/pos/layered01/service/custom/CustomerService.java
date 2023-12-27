/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered01.service.custom;

import java.util.ArrayList;
import pos.layered01.dto.CustomerDTO;
import pos.layered01.service.SuperService;

/**
 *
 * @author kasun
 */
public interface CustomerService extends SuperService{

   String addCustomer(CustomerDTO customerDTO);
   String updateCustomer(CustomerDTO customerDTO);
   String deleteCustomer(String id);
   CustomerDTO getCustomer(String id);
   ArrayList<CustomerDTO> getAllCustomer(CustomerDTO customerDTO);
    
}
