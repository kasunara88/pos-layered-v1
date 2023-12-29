/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layered01.service.custom;

import java.util.ArrayList;
import pos.layered01.dto.ItemDTO;
import pos.layered01.service.SuperService;

/**
 *
 * @author kasun
 */
public interface ItemService extends SuperService {

    String addItem(ItemDTO itemDTO) throws Exception;

    String updateItem(ItemDTO itemDTO) throws Exception;

    String deleteItem(String id) throws Exception;

    ItemDTO getItem(String id) throws Exception;

    ArrayList<ItemDTO> getAllItem() throws Exception;
}
