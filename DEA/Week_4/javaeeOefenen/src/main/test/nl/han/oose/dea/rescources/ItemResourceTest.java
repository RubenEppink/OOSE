package nl.han.oose.dea.rescources;

import nl.han.oose.dea.rescources.services.ItemService;
import nl.han.oose.dea.rescources.services.dto.ItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ItemResourceTest {

    private ItemResource itemResourceUnderTest;

    @BeforeEach
    void setUp() {
        itemResourceUnderTest = new ItemResource();
        itemResourceUnderTest.itemService = mock(ItemService.class);
    }

    @Test
    void testGetTextItems() {
        // Setup

        // Run the test
        final String result = itemResourceUnderTest.getTextItems();

        // Verify the results
        assertEquals("Bread and butter", result);
    }

    @Test
    void testGetJSONItems() {
        // Setup

        // Configure ItemService.getAll(...).
        final List<ItemDTO> itemDTOS = Arrays.asList(new ItemDTO(0, "name", new String[]{"value"}, "title"));
        when(itemResourceUnderTest.itemService.getAll()).thenReturn(itemDTOS);

        // Run the test
        final List<ItemDTO> result = itemResourceUnderTest.getJSONItems();

        // Verify the results
    }

    @Test
    void testGetJSONItemsResponse() {
        // Setup

        // Configure ItemService.getAll(...).
        final List<ItemDTO> itemDTOS = Arrays.asList(new ItemDTO(0, "name", new String[]{"value"}, "title"));
        when(itemResourceUnderTest.itemService.getAll()).thenReturn(itemDTOS);

        // Run the test
        final Response result = itemResourceUnderTest.getJSONItemsResponse();

        // Verify the results
        assertEquals(200, result.getStatus());
        assertEquals(itemDTOS, result.getEntity());
    }

    @Test
    void testGetJSONItemsById() {
        // Setup

        // Configure ItemService.getItem(...).
        final ItemDTO itemDTO = new ItemDTO(6, "name", new String[]{"value"}, "title");
        when(itemResourceUnderTest.itemService.getItem(6)).thenReturn(itemDTO);

        // Run the test
        final Response result = itemResourceUnderTest.getJSONItemsById(6);

        // Verify the results
        verify(itemResourceUnderTest.itemService).getItem(6);
    }

    @Test
    void testPostItem() {
        // Setup
        final ItemDTO itemDTO = new ItemDTO(0, "name", new String[]{"value"}, "title");

        // Run the test
        final Response result = itemResourceUnderTest.postItem(itemDTO);

        // Verify the results
        verify(itemResourceUnderTest.itemService).addItem(any(ItemDTO.class));
    }

    @Test
    void testPostItem1() {
        // Setup

        // Run the test
        final Response result = itemResourceUnderTest.postItem(0);

        // Verify the results
        verify(itemResourceUnderTest.itemService).deleteItem(0);
    }
}
