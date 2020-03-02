package nl.han.ica.oose.dea.resources;

import nl.han.oose.dea.rest.resources.ItemResource;
import nl.han.oose.dea.rest.services.HardcodedItemService;
import nl.han.oose.dea.rest.services.ItemService;
import nl.han.oose.dea.rest.services.dto.ItemDTO;
import nl.han.oose.dea.rest.services.exceptions.IdAlreadyInUseException;
import nl.han.oose.dea.rest.services.exceptions.ItemNotAvailableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

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
    void addItemsCallsAddItem() {
        // Arrange
        ItemDTO item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        // Act
        sut.addItem(item);

        // Assert
        Mockito.verify(mockedItemService).addItem(item);
    }

    @Test
    void addItemsResponseStatusTest() {
        // Arrange
        ItemDTO item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        // Act
        Response response = sut.addItem(item);

        // Assert
        Assertions.assertEquals(HTTP_CREATED, response.getStatus());
    }

    @Test
    void addItemsThrowsException() {
        // Arrange
        ItemDTO item = new ItemDTO(1, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        doThrow(IdAlreadyInUseException.class).when(mockedItemService).addItem(item);
        // Act

        // Assert
        assertThrows(IdAlreadyInUseException.class, () -> {
            sut.addItem(item);
        });
    }

    @Test
    void getItemCallsGetItem() {
        // Arrange

        // Act
        var response = sut.getItem(ITEM_ID);

        // Assert
        Mockito.verify(mockedItemService).getItem(ITEM_ID);
    }

    @Test
    void getItemWithId() {
        // Arrange
        var item = new ItemDTO(ITEM_ID, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        Mockito.when(mockedItemService.getItem(ITEM_ID)).thenReturn(item);

        // Act
        Response response = sut.getItem(ITEM_ID);

        // Assert
        assertEquals(item, response.getEntity());
    }

    @Test
    void getItemThrowsException() {


        doThrow(ItemNotAvailableException.class).when(mockedItemService).getItem(9);
        // Act

        // Assert
        assertThrows(ItemNotAvailableException.class, () -> {
            sut.getItem(9);
        });
    }

    @Test
    void getItemReturnsHttp200() {
        // Arrange
        var item = new ItemDTO(ITEM_ID, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        Mockito.when(mockedItemService.getItem(ITEM_ID)).thenReturn(item);

        // Act
        Response response = sut.getItem(ITEM_ID);

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
    }


    @Test
    void deleteItemCallsDeleteItemOnService() {
        // Arrange

        // Act
        sut.deleteItem(ITEM_ID);

        // Assert
        verify(mockedItemService).deleteItem(ITEM_ID);
    }

    @Test
    void deleteItemsReturnsHttp200() {
        // Arrange

        // Act
        var response = sut.deleteItem(ITEM_ID);

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
    }

    @Test
    void deleteItemLetsItemNotAvailableExceptionPass() {
        // Arrange
        doThrow(ItemNotAvailableException.class).when(mockedItemService).deleteItem(ITEM_ID);

        // Act & Assert
        assertThrows(ItemNotAvailableException.class, () -> sut.deleteItem(ITEM_ID));
    }
}