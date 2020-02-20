package nl.oose.dea.opdrachtdrie;

import java.util.Scanner;

public class BlackJack {
    public static BlackJack bj = new BlackJack();

    public static void main(String[] args) {
        bj.init();
    }

    private void init() {
        var logger = new Logger();
        var scanner = new Scanner(System.in);
        logger.log("Do u want to play BlackJack.\nEnter:\nYes: Y\nNo: N");
        var choice = scanner.nextLine().trim();
        while ("Y".equalsIgnoreCase(choice)) {
            var playerHand = new Hand(logger);
            var dealerHand = new Hand(logger);

            var game = new Game(playerHand, dealerHand, logger, scanner);
            game.start();
            game.playBlackjack();

            logger.log("\n\n");
            logger.log("Do u want to play BlackJack.\nEnter:\nYes: Y\nNo: N");
            choice = scanner.nextLine().trim();
        }
    }

}

