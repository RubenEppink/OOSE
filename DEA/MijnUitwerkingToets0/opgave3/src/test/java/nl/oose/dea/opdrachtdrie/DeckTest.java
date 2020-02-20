package nl.oose.dea.opdrachtdrie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class DeckTest {
    private Logger logger;

    @BeforeEach
    void setup() {
        logger = mock(Logger.class);
    }

    @Test
    public void afterInitializationLoggerIsCalled52Time() {
        var deck = new Deck(logger);
        verify(logger, times(52)).log(anyString());
        assertEquals(13, deck.values.size());
    }

}
