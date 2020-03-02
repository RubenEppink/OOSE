package nl.han.oose.dea.rest.services;


import nl.han.oose.dea.rest.services.dto.ItemDTO;

import javax.enterprise.inject.Alternative;
import java.util.List;

@Alternative
public class NewItemService implements ItemService {
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void addItem(ItemDTO itemDTO) {

    }

    @Override
    public ItemDTO getItem(int id) {
        return null;
    }

    @Override
    public void deleteItem(int id) {

    }
}
