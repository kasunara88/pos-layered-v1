/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.service.custom.customerserviceimpl;

import java.util.ArrayList;
import pos.layered01.dao.DAOFactory;
import pos.layered01.dao.custom.ItemDAO;
import pos.layered01.dto.CustomerDTO;
import pos.layered01.dto.ItemDTO;
import pos.layered01.entity.CustomerEntity;
import pos.layered01.entity.ItemEntity;
import pos.layered01.service.custom.ItemService;

/**
 *
 * @author kasun
 */
public class ItemSrviceImpl implements ItemService{
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInsance().getDAO(DAOFactory.DAOType.ITEM);
    
    @Override
    public String addItem(ItemDTO itemDTO) throws Exception {
      ItemEntity ie = new ItemEntity(itemDTO.getItemCode(),
              itemDTO.getDescription(), itemDTO.getPacksize(), itemDTO.getUnitprice(), 
              itemDTO.getQtyOnHand());
      
        if (itemDAO.add(ie)) {
            return "Sucessfully Save";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateItem(ItemDTO itemDTO) throws Exception {
            ItemEntity ie = new ItemEntity(itemDTO.getItemCode(),
              itemDTO.getDescription(), itemDTO.getPacksize(), itemDTO.getUnitprice(), 
              itemDTO.getQtyOnHand());
      
        if (itemDAO.update(ie)) {
            return "Sucessfully Update";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteItem(String id) throws Exception {
      if (itemDAO.delete(id)) {
            return "Sucessfully Delete";
        } else {
            return "Fail";
        }
    }

    @Override
    public ItemDTO getItem(String id) throws Exception {
        ItemEntity ie = itemDAO.get(id);
        return new ItemDTO(ie.getItemCode(),
                ie.getDescription(),
                ie.getPacksize(),
                ie.getUnitprice(), ie.getQtyOnHand());
        
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {
       ArrayList<ItemDTO> itemDTOs = new ArrayList<>();
        ArrayList<ItemEntity> itemEntitys = itemDAO.getAll();

        for (ItemEntity entity : itemEntitys) {
            ItemDTO dto = new ItemDTO(entity.getItemCode(),
                    entity.getDescription(),
                    entity.getPacksize(),
                    entity.getUnitprice(),
                    entity.getQtyOnHand());
                   
            itemDTOs.add(dto);
        }
        return itemDTOs;
    }
    
}
