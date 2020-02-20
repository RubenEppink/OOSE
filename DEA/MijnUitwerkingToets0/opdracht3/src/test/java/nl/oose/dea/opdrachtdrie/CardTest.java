package nl.oose.dea.opdrachtdrie;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CardTest {
    private static final String SUIT = "SUIT";
    private static final String RANK = "RANK";

    @Test
    public void dataStructureTest() {
        var card = new Card(SUIT, RANK);
        assertEquals(SUIT, card.getSuit());
        assertEquals(RANK, card.getRank());
    }

}
