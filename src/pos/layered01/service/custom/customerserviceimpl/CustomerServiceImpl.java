/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.service.custom.customerserviceimpl;

import java.util.ArrayList;
import pos.layered01.dao.DAOFactory;
import pos.layered01.dao.custom.CustomerDAO;
import pos.layered01.dto.CustomerDTO;
import pos.layered01.entity.CustomerEntity;
import pos.layered01.service.custom.CustomerService;

/**
 *
 * @author kasun
 */
public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInsance().getDAO(DAOFactory.DAOType.CUSTOMER);
    
    
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        CustomerEntity ce = new CustomerEntity(customerDTO.getCustId(),
                customerDTO.getTitle(),
                customerDTO.getName(),
                customerDTO.getDob(),
                customerDTO.getSalary(),
                customerDTO.getAddress(),
                customerDTO.getCity(),
                customerDTO.getProvince(),
                customerDTO.getZip()
        );
       
        if(customerDAO.add(ce)){
            return "Sucessfully Save";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity ce = new CustomerEntity(customerDTO.getCustId(),
                customerDTO.getTitle(),
                customerDTO.getName(),
                customerDTO.getDob(),
                customerDTO.getSalary(),
                customerDTO.getAddress(),
                customerDTO.getCity(),
                customerDTO.getProvince(),
                customerDTO.getZip()
        );
       
        if(customerDAO.update(ce)){
            return "Sucessfully Updte";
        } else {
            return "Update Fail";
        }
    }

    @Override
    public String deleteCustomer(String id) {
           if(customerDAO.delete(id)){
            return "Sucessfully Delete";
        } else {
            return "Fail";
        }
    }

    @Override
    public CustomerDTO getCustomer(String id) {
       CustomerEntity entity = customerDAO.get(id);
       
       return new CustomerDTO(entity.getCustId(),
                entity.getTitle(),
                entity.getName(),
                entity.getDob(),
                entity.getSalary(),
                entity.getAddress(),
                entity.getCity(),
                entity.getProvince(),
                entity.getZip());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer(CustomerDTO customerDTO) {
       ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();
       ArrayList<CustomerEntity> customerEntitys = customerDAO.getAll();
       
       for(CustomerEntity entity : customerEntitys){
           CustomerDTO dto = new CustomerDTO(entity.getCustId(),
                entity.getTitle(),
                entity.getName(),
                entity.getDob(),
                entity.getSalary(),
                entity.getAddress(),
                entity.getCity(),
                entity.getProvince(),
                entity.getZip());
           customerDTOs.add(dto);
       }
       return customerDTOs;
    }

}
