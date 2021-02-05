package model;

import java.io.Serializable;

public class Dealer implements Serializable {

    private Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    /**
     * Determines if dealer has a blackjack
     */

    public boolean isBlackjack() {
        if (hand.calculateTotal() == 21) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints Dealers hand
     */
    public void printHand() {
        Logger.log(Logger.LogLevel.DEV, "Dealers hand:");
        hand.printHand();
    }

    /**
     * Adds a card o the dealer's hand
     */
    public void addCard(Card card) {
        hand.addCard(card);
    }

    /**
     * Calculates the dealer's hand total
     */
    public int calculateTotal() {
        return hand.calculateTotal();
    }

    /**
     * Clears the dealer's hand
     */
    public void clearHand() {
        hand.clearHand();
    }

    /**
     * Peeks the dealer's face-down card
     */
    public boolean peek() {
        return hand.dealerPeek();
    }

    public Hand getHand() {
        return this.hand;
    }

}
