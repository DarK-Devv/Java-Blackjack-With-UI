package model;

import controller.BlackjackController;

import static java.lang.Thread.sleep;

/**
 *
 *  Logic of Blackjack game
 *
 */

public class BlackjackGame extends Thread {

    private BlackjackRound round;

    /**
     * Deck used in a blackjack game
     *
     */
    private Deck deck;

    /**
     * Player playing in a blackjack game
     *
     */
    private Player player;

    private Dealer dealer;

    private BlackjackController gameController;
    private String winner;



    /**
     *
     * Initializes new Blackjack game
     *
     */
    public BlackjackGame(BlackjackController gameController) {
        Logger.log(Logger.LogLevel.DEV, "Blackjack game started");
        this.deck = new Deck();
        this.player = new Player(2500);
        this.dealer = new Dealer();
        this.gameController = gameController;

    }


    /**
     * Initializes new round in a blackjack game:
     * Shuffles deck and deals two cards for player and one for dealer.
     *
     */
    public void initRound() {
        player.clearHand();
        dealer.clearHand();

        this.round = new BlackjackRound(this.gameController, this.deck, this.player, this.dealer);

    }

    public void playerHit() {
        try {
            round.playerHit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void playerStay() {
        round.playerStay();
    }


    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public String whoWins() {
        return round.whoWins();
    }

}
