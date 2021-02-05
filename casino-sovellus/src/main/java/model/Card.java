package model;
/**
 * Represents a playing card
 *
 * @author
 * @version
 */

public class Card {
    /**
     * Array of suits as String
     */
    public static final String[] suits = {null, "Club", "Diamond", "Spade", "Heart"};

    /**
     * Array of ranks as String
     */
    public static final String[] ranks =
            {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    /**
     * Represents the rank of a card. Rank is an integer between 1 and 13.
     */
    private int rank;

    /**
     * Represents the suit of a card. Suit is an integer between 1 and 4.
     */
    private int suit;

    /**
     * Initializes a new Card-object.
     * Note that this constructor takes all integers as parameters.
     * Only the constructor of the Deck-object ensures the values for rank and suit are appropriate.
     * @param rank sets the rank of the Card-object
     * @param suit sets the suit of the Card-object
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return ranks[this.rank]+" of "+suits[this.suit];
    }
}
