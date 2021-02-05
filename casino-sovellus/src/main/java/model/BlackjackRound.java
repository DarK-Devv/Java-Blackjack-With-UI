package model;

import controller.BlackjackController;

public class BlackjackRound extends Thread{

    private static int roundNumber = 0;

    private BlackjackController gameController;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private boolean playerBusted = false;


    public BlackjackRound(BlackjackController gameController, Deck deck, Player player, Dealer dealer) {
        Logger.log(Logger.LogLevel.PROD, String.format("Round %d started", ++roundNumber));
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.gameController = gameController;

        deck.shuffleDeck();

        this.player.addCard(deck.nextCard());
        this.player.addCard(deck.nextCard());
        this.dealer.addCard(deck.nextCard());
        player.printHand();
        System.out.println("");
        dealer.printHand();
        this.gameController.setPlayersCardsToUI(this.player.getHand().getHand());
        this.gameController.setDealersCardsToUI(this.dealer.getHand().getHand());
    }

    public void playerHit() throws InterruptedException {
        player.addCard(deck.nextCard());
        player.printHand();
        gameController.setPlayersCardsToUI(this.player.getHand().getHand());


        int total = player.calculateHand();
        if (total > 21) {
            playerBusted = true;
            System.out.println(this.getState());
            this.start();
        }
    }

    public void playerStay() {
        playerBusted = false;
        System.out.println(this.getState());
        this.start();
    }

    public String whoWins() {
        String winner = "";

        int playerTotal = player.calculateHand();
        int dealerTotal = dealer.calculateTotal();
        boolean playerWins = false;

        if (playerTotal == dealerTotal) { //Even if they both get a blackjack
            Logger.log(Logger.LogLevel.PROD, "No one wins");
            winner = "nobody";
        } else if (playerTotal <= 21 && (playerTotal > dealerTotal || dealerTotal > 21)) {
            playerWins = true;
            winner = "player";
            Logger.log(Logger.LogLevel.PROD, "Player wins");
        }
        else {
            playerWins = false;
            winner = "dealer";
            Logger.log(Logger.LogLevel.PROD, "Dealer wins");
        }

        if (playerWins == true) {
            player.win();
        } else {
            player.lose();
        }
        return winner;
    }


    public void run()  {
        if (!playerBusted) {
            System.out.println("Dealer plays\n");
            while (dealer.calculateTotal() <= 16) {
                System.out.println("Dealer has " + dealer.calculateTotal() + " and hits");
                dealer.addCard(deck.nextCard());
                gameController.setDealersCardsToUI(dealer.getHand().getHand());
                //System.out.println("Dealer " + this.getHandString(true, false));

            }
            if (dealer.calculateTotal() > 21) {
                System.out.println("Dealer busts. ");// + this.getHandString(true, false));
            } else {
                System.out.println("Dealer stands at " + dealer.calculateTotal());// + this.getHandString(true, false));
            }
        }
        try {
            gameController.declareWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.log(Logger.LogLevel.PROD, "Round ended");
        player.printHand();
        System.out.println("");
        dealer.printHand();

        String winner = whoWins();
        System.out.println("The winner is: "+winner.toString());

        System.out.println("Your saldo: "+player.getCurrency());

        Logger.log(Logger.LogLevel.PROD, "The amount of wins: "+player.getWins());
    }
}
