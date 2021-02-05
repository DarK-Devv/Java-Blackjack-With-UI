package controller;

import model.*;
import view.InGameViewController;

import java.util.ArrayList;

public class BlackjackController {

    private BlackjackGame blackJackGame;
    private Player player;
    private Hand handObjectPlayer;
    private ArrayList<Card> handPlayer;
    private Dealer dealer;
    private Hand handObjectDealer;
    private ArrayList<Card> handDealer;
    private InGameViewController inGameViewController;
    private String winner;

    public BlackjackController() {
        this.blackJackGame = new BlackjackGame(this);
        this.player = blackJackGame.getPlayer();
        this.handObjectPlayer = player.getHand();
        this.handPlayer = handObjectPlayer.getHand();
        this.dealer = blackJackGame.getDealer();
        this.handObjectDealer = dealer.getHand();
        this.handDealer = handObjectDealer.getHand();
    }


    public void nextRound() {
        this.blackJackGame.initRound();

    }

    public void hit() throws InterruptedException {
        this.blackJackGame.playerHit();
    }
    public void stand() throws InterruptedException {
        this.blackJackGame.playerStay();
    }

    public void setBet(int b) { this.player.setBet(b);}

    public int getBet() { return player.getBet();}

    public ArrayList<Card> getPlayersCards() {
        return this.handPlayer;
    }

    public void setPlayersCardsToUI(ArrayList<Card> playersCards) {
        inGameViewController.setPlayersCards(playersCards);
    }

    public void setDealersCardsToUI(ArrayList<Card> dealersCards) {
        inGameViewController.setDealersCards(dealersCards);
    }

    public ArrayList<Card> getDealersCards() {
        return this.handDealer;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void setInGameViewController(InGameViewController inGameViewController) {
        this.inGameViewController = inGameViewController;
    }

    public void declareWinner() throws InterruptedException {
        inGameViewController.declareWinner();
    }

    public String getWinner() {
        this.winner = blackJackGame.whoWins();
        return this.winner;
    }

}
