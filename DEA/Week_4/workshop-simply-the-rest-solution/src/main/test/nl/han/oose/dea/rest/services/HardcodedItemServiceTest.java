package nl.han.oose.dea.rest.services;

import nl.han.oose.dea.rest.services.dto.ItemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class HardcodedItemServiceTest {
    @Mock
    List<ItemDTO> items;
    @InjectMocks
    HardcodedItemService hardcodedItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddItem() {
        hardcodedItemService.addItem(new ItemDTO(0, null, null, null));
    }

    @Test
    void testGetItem() {
        ItemDTO result = hardcodedItemService.getItem(0);
        Assertions.assertEquals(new ItemDTO(0, null, null, null), result);
    }

    @Test
    void testDeleteItem() {
        hardcodedItemService.deleteItem(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme