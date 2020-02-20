package nl.oose.dea.opdrachtdrie;

import java.util.HashMap;
import java.util.List;

public class CardsPrinter {

    public void printCards(List<Card> cardList, Logger logger, HashMap<String, Integer> values) {
        cardList.forEach(
                card -> logger.log("Card: " + card.getSuit() + " " + card.getRank() + " : " + values.get(card.getRank())));

    }
}
