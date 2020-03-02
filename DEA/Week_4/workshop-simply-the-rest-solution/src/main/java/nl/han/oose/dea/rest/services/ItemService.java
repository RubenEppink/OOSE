package nl.han.oose.dea.rest.services;

import nl.han.oose.dea.rest.services.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    List getAll();

    void addItem(ItemDTO itemDTO);

    ItemDTO getItem(int id);

    void deleteItem(int id);
}
