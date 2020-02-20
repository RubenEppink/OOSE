package nl.oose.dea.opdrachtdrie;

import java.util.ArrayList;

class Hand extends Deck {
    final int BLACKJACK = 21;
    final int TEN = 10;
    private ArrayList<Card> cards = new ArrayList<>();
    private CardsPrinter cp;

    public Hand(Logger logger) {
        super(logger);
    }

    public int totalSum() {
        int score = 0;
        for (Card card : this.cards) {
            score += getValue(card);
        }
        if (countAces() == 0) {
            return score;
        } else {
            if (score + TEN > BLACKJACK)
                return score;
            else {
                return score + TEN;
            }
        }
    }

    public void hit() {
        addCard(dealCard());
    }

    public void printHands() {
        cp = new CardsPrinter();
        cp.printCards(cards, logger, values);
        logger.log("Total Sum: " + totalSum());
    }

    public boolean busted() {

        if (totalSum() > BLACKJACK) {
            logger.log("Busted!!!");
            return true;
        }
        return false;
    }

    private int getValue(Card card) {
        return values.get(card.getRank());
    }

    private void addCard(Card card) {
        this.cards.add(card);
    }

    private int countAces() {
        int aces = 0;
        for (Card card : this.cards) {
            if ("A".equalsIgnoreCase(card.getRank()))
                ++aces;
        }
        return aces;
    }
}
