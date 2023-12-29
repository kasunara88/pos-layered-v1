/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layered01.controller;

import java.util.ArrayList;
import pos.layered01.dto.ItemDTO;
import pos.layered01.service.ServiceFactory;
import pos.layered01.service.custom.ItemService;

/**
 *
 * @author kasun
 */
public class ItemController {
    ItemService itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
     public String addItem(ItemDTO itemDTO) throws Exception {
        return itemService.addItem(itemDTO);
    }

    public ArrayList<ItemDTO> getAllItem() throws Exception{
        return itemService.getAllItem();
    }

    public String updateItem(ItemDTO itemDTO) throws Exception{
        return itemService.updateItem(itemDTO);
    }

    public ItemDTO getITem(String itemID) throws Exception{
      return itemService.getItem(itemID);
    }

    public String deleteItem(String itemID) throws Exception {
        return itemService.deleteItem(itemID);
    }
}
