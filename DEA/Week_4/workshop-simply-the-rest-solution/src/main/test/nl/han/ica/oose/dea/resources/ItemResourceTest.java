package nl.han.ica.oose.dea.resources;

import nl.han.oose.dea.rest.resources.ItemResource;
import nl.han.oose.dea.rest.services.HardcodedItemService;
import nl.han.oose.dea.rest.services.ItemService;
import nl.han.oose.dea.rest.services.dto.ItemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ItemResourceTest {

    private static final String TEXT_ITEMS = "bread, butter";
    private static final int ITEM_ID = 1;
    private static final int HTTP_OK = 200;
    private static final int HTTP_CREATED = 201;

    private ItemResource sut;
    private ItemService mockedItemService;

    @BeforeEach
    void setup() {
        this.mockedItemService = Mockito.mock(HardcodedItemService.class);
        this.sut = new ItemResource();
        sut.setItemService(mockedItemService);
    }

    @Test
    void getTextItemsReturnsTextItems() {
        // Arrange


        // Act
        var textItems = sut.getTextItems();

        // Assert
        assertEquals(TEXT_ITEMS, textItems);
    }

    @Test
    void getJsonItemsCallsGetAll() {
        // Arrange

        // Act
        var response = sut.getJsonItems();

        // Assert
        Mockito.verify(mockedItemService).getAll();
    }

    @Test
    void getJsonReturnsObjectFromServiceAsEntity() {
        //Arrange

        //Act
        List<ItemDTO> itemsToReturn = new ArrayList<>();
        Mockito.when(mockedItemService.getAll()).thenReturn(itemsToReturn);

        Response response = sut.getJsonItems();

        //Assert
        Assertions.assertEquals(itemsToReturn, response.getEntity());
        Assertions.assertEquals(response.getStatus(), HTTP_OK);


    }

    @Test
    void addItemsAddsItem() {
        // Arrange
        ItemDTO item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        // Act
        var response = sut.addItem(item);

        // Assert
        Assertions.assertEquals(HTTP_CREATED, response.getStatus());
    }

    @Test
    void getItemGetsCorrectItem() {
        // Arrange

        // Act
        var response = sut.getItem(ITEM_ID);

        // Assert
        Assertions.assertEquals(HTTP_OK, response.getStatus());
        Assertions.assertTrue(response.getEntity() instanceof ItemDTO);

        if (response.getEntity() instanceof ItemDTO) {
            var item = (ItemDTO) response.getEntity();
            assertEquals(ITEM_ID, item.getId());
        } else {
            assertFalse(false);
        }
    }

    @Test
    void deleteItemDeletesItem() {
        // Arrange

        // Act
        var response = sut.deleteItem(ITEM_ID);

        // Assert
        Assertions.assertEquals(HTTP_OK, response.getStatus());
    }
}