package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.helpers.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class StreamsTest {
    private Streams streams;

    @BeforeEach
    void setup() {
        streams = new Streams();
    }

    @Test
    void testRemoveStringsWithMoreThanThreeCharacters() {
        // Setup
        List<String> input = asList("Welcome", "to", "Java", "8", "Streams");

        // Test
        List<String> filteredStrings = streams.filterStringsLongerThanThreeCharacters(input);

        // Verify
        assertThat(filteredStrings, contains("to", "8"));
    }

    @Test
    void testRemoveNonNumeralStrings() {
        // Setup
        List<String> input = asList("Welcome", "to", "Java", "8", "Streams");

        // Test
        List<String> filteredStrings = streams.filterStringsThanContainOnlyNumerals(input);

        // Verify
        assertThat(filteredStrings, contains("8"));
    }

    @Test
    void testFindShortestString() {
        // Setup
        List<String> input = asList("Welcome", "to", "Java", "8", "Streams");

        // Test
        String foundString = streams.findShortestString(input);

        // Verify
        Assertions.assertEquals("8", foundString);
    }

    @Test
    void testCreateAFullSentenceFromTheList() {
        // Setup
        List<String> input = asList("Welcome", "to", "Java", "8", "Streams");

        // Test
        String foundString = streams.createAFullSentenceFromTheList(input);

        // Verify
        Assertions.assertEquals("Welcome to Java 8 Streams", foundString);
    }

    @Test
    void testCalculateTotalCostOfAllProducts() {
        // Setup
        final int PRICE_TV = 1200;
        final int PRICE_LAPTOP = 2300;
        final int PRICE_TABLET = 149;
        final int PRICE_PHONE = 237;

        var tv = new Product("TV", PRICE_TV);
        var laptop = new Product("Laptop", PRICE_LAPTOP);
        var tablet = new Product("tablet", PRICE_TABLET);
        var phone = new Product("phone", PRICE_PHONE);

        List<Product> input = asList(tv, laptop, tablet, phone);

        // Test
        int totalValue = streams.calculateTotalCostOfAllProducts(input);

        // Verify
        Assertions.assertEquals(PRICE_TV + PRICE_LAPTOP + PRICE_TABLET + PRICE_PHONE, totalValue);
    }
}
