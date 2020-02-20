package nl.oose.dea.opdrachtdrie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class GameTest {

    private Hand playerHand;
    private Hand dealerHand;
    private Logger logger;
    private Game game;

    @BeforeEach
    public void setup() {
        playerHand = Mockito.mock(Hand.class);
        dealerHand = Mockito.mock(Hand.class);
        logger = Mockito.mock(Logger.class);

        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        var scanner = new Scanner(in);
        game = new Game(playerHand, dealerHand, logger, scanner);
    }

    @Test
    public void startHitsBothHandsTwoTimesAndPrintsPlayersHand() {
        game.start();
        verify(playerHand, times(2)).hit();
        verify(dealerHand, times(2)).hit();
        verify(logger).log("Player hand:");
        verify(playerHand, times(1)).printHands();
    }

    @Test
    public void whenPlayerChoosesOneAndPlayersHandIsBustedLoggerGetsCalledFourTimes() {
        Mockito.when(playerHand.busted()).thenReturn(true);
        game.start();
        game.playBlackjack();
        verify(logger, times(4)).log(anyString());
    }

    @Test
    public void whenPlayerChoosesTwoAndPlayersHandIsNotBustedLoggerGetsCalledFourTimes() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(in);
        Game game = new Game(playerHand, dealerHand, logger, scanner);

        Mockito.when(playerHand.busted()).thenReturn(false);
        Mockito.when(dealerHand.totalSum()).thenReturn(22);
        Mockito.when(dealerHand.busted()).thenReturn(true);
        game.start();
        game.playBlackjack();
    }

    @Test
    public void whenPlayerHandIsHitAndNotBustedThePlayerIsHitAgainAndHisHandIsPrinted() {
        Mockito.when(playerHand.busted()).thenReturn(false);
        game.hit();
        verify(playerHand).hit();
        verify(playerHand).printHands();
    }

    @Test
    public void whenPlayerHandIsHitAndBustedTheDealerWins() {
        Mockito.when(playerHand.busted()).thenReturn(true);
        game.hit();
        verify(dealerHand).printHands();
        verify(logger, times(2)).log(anyString());
    }

    @Test
    public void whenPlayerHandsStandsAndNotBustedTheDealerHitsUntilOver17() {
        Mockito.when(playerHand.busted()).thenReturn(false);
        Mockito.when(dealerHand.totalSum()).thenReturn(10, 18);
        Mockito.when(dealerHand.busted()).thenReturn(true);
        game.stand();
        verify(dealerHand).hit();
        verify(logger).log("\nDealer hand:");
        verify(dealerHand).printHands();
    }

    @Test
    public void whenPlayerHandsStandsAndBothAreNotBustedTheDealerWinswhenSumIsMoreThanThePlayersSum() {
        Mockito.when(playerHand.busted()).thenReturn(false);
        Mockito.when(dealerHand.totalSum()).thenReturn(18);
        Mockito.when(dealerHand.busted()).thenReturn(false);
        Mockito.when(playerHand.totalSum()).thenReturn(17);
        game.stand();
        verify(logger).log("\nDealer Wins");
    }

    @Test
    public void whenPlayerHandsStandsAndBothAreNotBustedThePlayerWinswhenSumIsMoreThanTheDealersSum() {
        Mockito.when(playerHand.busted()).thenReturn(false);
        Mockito.when(dealerHand.totalSum()).thenReturn(17);
        Mockito.when(dealerHand.busted()).thenReturn(false);
        Mockito.when(playerHand.totalSum()).thenReturn(18);
        game.stand();
        verify(logger).log("\nYou Win");
    }

    @Test
    public void whenPlayerHandsStandsAndBothAreNotBustedTheGameEndsInADrawWhenTotalSumsAreEqual() {
        Mockito.when(playerHand.busted()).thenReturn(false);
        Mockito.when(dealerHand.totalSum()).thenReturn(18);
        Mockito.when(dealerHand.busted()).thenReturn(false);
        Mockito.when(playerHand.totalSum()).thenReturn(18);
        game.stand();
        verify(logger).log("\nDraw (PUSH)!!!");
    }
}
