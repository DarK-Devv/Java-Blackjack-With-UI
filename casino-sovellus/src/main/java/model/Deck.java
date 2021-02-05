package model;

import java.util.ArrayList;

/**
 * Represents a deck of cards
 *
 * @author
 * @version
 */
public class Deck {

    /**
     * An array of cards which represents the deck.
     * Can contain maximum of 52 objects.
     */
    private ArrayList<Card> deck;

    /**
     * Initializes a new Deck-object and creates 52 Card-objects for the deck.
     */
    public Deck() {
        int rank = 1;
        int suit = 1;
        this.deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            this.deck.add(new Card(rank, suit));
            rank++;
            if (rank > 13) {
                rank = 1;
                suit++;
            }
        }
    }

    /**
     * Returns cards in deck
     * @return array of cards
     */

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Returns the first Card-object and removes it from the ArrayList
     * @return the first card of the deck-array
     */
    public Card nextCard(){
        return this.deck.remove(0);
    }

    /**
     * Shuffles cards in deck
     *
     */
    public void shuffleDeck() {
        for (int i=0;i<deck.size();i++) {
            int rnd = (int) (Math.random() * deck.size());
            Card cardToMove = deck.get(i);
            deck.set(i, deck.get(rnd));
            deck.set(rnd, cardToMove);

        }
    }

    /**
     * Prints all Card-objects in the deck by calling the toString()-method from the Card-class
     */
    public void printCardsInDeck() {
        for (Card card: deck) {
            System.out.println(card.toString());
        }
    }
}

