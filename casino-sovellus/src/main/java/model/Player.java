package model;

import java.util.ArrayList;

/**
 * Represents a player of the game
 *
 */
public class Player {

    /**
     * Hand of a player
     */
    private Hand hand;

    private int amountOfWins = 0;

    private int currency;

    private int bet;

    /**
     * Initializes new Player-object
     *
     */
    public Player(int currency) {
        this.hand = new Hand();
        this.currency = currency;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    /**
     * Sets cards to players hand and prints the hand.
     * @param cardsToHand Array of cards
     *
     */
    public void setHand(Card [] cardsToHand) {
        hand.setHand(cardsToHand);
        Logger.log(Logger.LogLevel.DEV, "Players hand:");
        hand.printHand();
    }

    public void clearHand() {
        hand.clearHand();
    }

    public void printHand() {
        Logger.log(Logger.LogLevel.DEV, "Players hand:");
        hand.printHand();
    }

    public int calculateHand() { return hand.calculateTotal();}

    public void win() {
        amountOfWins++;
        currency += bet;
    }

    public void lose() {
        currency -= bet;
    }

    public int getWins() { return amountOfWins;}

    public Hand getHand() {
        return this.hand;
    }

    public int getCurrency() {
        return this.currency;
    }

    public void setBet(int b) {
        bet = b;
    }

    public int getBet() { return bet; }
}
