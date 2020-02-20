package nl.oose.dea.opdrachtdrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deckCards = new ArrayList<>();
    private CardsPrinter cp;

    private String[] suits = {"SPADES", "DIAMONDS", "HEARTS", "CLUBS"};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};

    protected HashMap<String, Integer> values = new HashMap<>();
    protected Logger logger;

    public Deck(Logger logger) {
        this.logger = logger;
        initializeDeck();
    }

    public Card dealCard() {
        var len = this.deckCards.size() - 1;
        var card = this.deckCards.get(len);
        this.deckCards.remove(len);
        return card;
    }

    protected void printDeck() {
        cp = new CardsPrinter();
       cp.printCards(deckCards, logger, values);
    }

    private void initializeDeck() {
        setValues();
        Card card;
        for (String suit : suits) {
            for (String rank : ranks) {
                card = new Card(suit, rank);
                this.deckCards.add(card);
            }
        }
        shuffle(this.deckCards);
        printDeck();
    }

    private void setValues() {
        for (int i = 0; i < value.length; i++) {
            values.put(ranks[i], value[i]);
        }
    }

    private void shuffle(ArrayList<Card> array) {
        int index;
        Card temp;
        var random = new Random();
        for (int i = array.size() - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array.get(index);
            array.set(index, array.get(i));
            array.set(i, temp);
        }
    }
}
