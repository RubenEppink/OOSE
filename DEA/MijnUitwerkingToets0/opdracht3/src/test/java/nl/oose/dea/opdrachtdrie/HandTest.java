package nl.oose.dea.opdrachtdrie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class HandTest {

    private Hand hand;
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = Mockito.mock(Logger.class);
        hand = new Hand(logger);
    }

    @Test
    public void sumIsZeroWhenNoCardIsDrawn() {
        assertEquals(0, hand.totalSum());
    }

    @Test
    public void sumOfFullDeckIs340() {
        playFullDeck();
        assertEquals(340, hand.totalSum());
    }

    @Test
    public void afterOneHitTheSumIsGreaterThanZero() {
        hand.hit();
        assertTrue(hand.totalSum() > 0);
    }

    @Test
    public void loggerGetsCalledOnceWhenNoCardIsDrawnBeforeAPrint() {
        reset(logger);
        hand.printHands();
        verify(logger, times(1)).log(anyString());
    }

    @Test
    public void loggerGetsCalled53TimesWhenAllCardsAreDrawnBeforeAPrint() {
        reset(logger);
        playFullDeck();
        hand.printHands();
        verify(logger, times(53)).log(anyString());
    }

    @Test
    public void notBustedWhenGameStarts() {
        assertFalse(hand.busted());
    }

    @Test
    public void bustedWhenAllCardsArePlayed() {
        playFullDeck();
        assertTrue(hand.busted());
    }

    @Test
    public void whenOneAceIsDrawnTheTotalIs11() {
        Hand spyHand = spy(new Hand(logger));
        when(spyHand.dealCard()).thenReturn(new Card("SPADES", "A"));
        spyHand.hit();
        assertEquals(11, spyHand.totalSum());
    }

    private void playFullDeck() {
        for (int i = 0; i < 52; i++) {
            hand.hit();
        }
    }
}
