package nl.oose.dea.opdrachtdrie;

import java.util.Scanner;

public class Game {
    private Hand playerHand;
    private Hand dealerHand;
    private Logger logger;
    private Scanner scanner;
    private Boolean playing = true;

    public Game(Hand playerHand, Hand dealerHand, Logger logger, Scanner scanner) {
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.logger = logger;
        this.scanner = scanner;
    }

    public void hit() {
        if (!playerHand.busted()) {
            playerHand.hit();
            playerHand.printHands();
        }
        if (playerHand.busted()) {
            logger.log("\nDealer hand:");
            dealerHand.printHands();
            logger.log("Dealer wins");
            playing = false;
        }
    }

    public void stand() {
        logger.log("Player STAND!");
        if (playing) {
            if (!playerHand.busted()) {
                while (dealerHand.totalSum() < 17) {
                    dealerHand.hit();
                }
                logger.log("\nDealer hand:");
                dealerHand.printHands();
                if (dealerHand.busted()) {
                    logger.log("Dealer busted. You win");
                } else {

                    if (dealerHand.totalSum() < playerHand.totalSum()) {
                        logger.log("\nYou Win");
                    } else if (dealerHand.totalSum() == playerHand.totalSum()) {
                        logger.log("\nDraw (PUSH)!!!");
                    } else {
                        logger.log("\nDealer Wins");
                    }
                }
                playing = false;
            }
        }
    }

    public void start() {
        playerHand.hit();
        playerHand.hit();

        logger.log("Player hand:");
        playerHand.printHands();

        dealerHand.hit();
        dealerHand.hit();
    }


    public void playBlackjack() {
        while (playing) {
            int choice;
            logger.log("\nDo you want to Hit or Stand.\nEnter:\n1. Hit\n2. Stand");
            choice = scanner.nextInt();

            if (choice == 1) {
                hit();
            } else if (choice == 2) {
                stand();
            }
        }
    }
}

