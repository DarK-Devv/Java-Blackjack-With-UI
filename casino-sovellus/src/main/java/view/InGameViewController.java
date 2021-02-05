package view;

import controller.BlackjackController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Card;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * Controller class for the InGameView.fxml and Settings.fxml
 */

public class InGameViewController {

    public Text playerCard1;
    public Text playerCard2;
    public Text playerCard3;
    public Text playerCard4;
    public Text dealerCard1;
    public Text dealerCard2;
    public Text dealerCard3;
    public Text dealerCard4;
    public Text playerCurrency;
    public Text playerTotal;
    public Text dealerTotal;
    public TextField betField;
    public Button splitButton;
    public Button standButton;
    public Button hitButton;
    public Button dealButton;
    private BlackjackController gameController;
    private ArrayList<Card> playersCards;
    private ArrayList<Card> dealerCards;
    private Object winner;


    /**
     * Gamescreen's Menu-Button loads to MainMenu.fxml
     *
     * @param actionEvent
     * @throws IOException
     */
    public void menuButton(ActionEvent actionEvent) throws IOException {

        Parent menuParent = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        Scene menuScene = new Scene(menuParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("The Grand Myllypuro");
        window.setScene(menuScene);
        window.show();

    }


    /**
     * Settingscreen's Back-Button loads to MainMenu.fxml
     *
     * @param actionEvent
     * @throws IOException
     */
    public void settingsBackButton(ActionEvent actionEvent) throws IOException {

        Parent menuParent = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        Scene menuScene = new Scene(menuParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("The Grand Myllypuro");
        window.setScene(menuScene);
        window.show();

    }

    /**
     * Gamescreen's Instructions-Button loads to Instructions.fxml
     *
     * @param actionEvent
     * @throws IOException
     */
    public void instructionsButton(ActionEvent actionEvent) throws IOException {

        Parent insParent = FXMLLoader.load(getClass().getResource("/Instructions.fxml"));
        Scene insScene = new Scene(insParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Instructions");
        window.setScene(insScene);
        window.show();

    }

    /**
     * Instructionscreen's Back to game-Button loads to InGameView.fxml
     *
     * @param actionEvent
     * @throws IOException
     */
    public void backToGameButton(ActionEvent actionEvent) throws IOException {

        Parent gameParent = FXMLLoader.load(getClass().getResource("/InGameView.fxml"));
        Scene gameScene = new Scene(gameParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Blackjack");
        window.setScene(gameScene);
        window.show();

    }


    public void hit() throws InterruptedException {
        gameController.hit();
        /*
        this.playersCards = gameController.getPlayersCards();
        switch (playersCards.size()) {
            case 3:
                playerCard3.setText(playersCards.get(2).toString());
                break;
            case 4:
                playerCard3.setText(playersCards.get(2).toString());
                playerCard4.setText(playersCards.get(3).toString());
                break;
        }*/
        updateTotalResult();
    }

    public void deal() {
        setBet();
        gameController.nextRound();
        dealButton.setDisable(true);
        hitButton.setDisable(false);
        standButton.setDisable(false);
        this.playersCards = gameController.getPlayersCards();
        this.dealerCards = gameController.getDealersCards();
        playerCard1.setText(playersCards.get(0).toString());
        playerCard2.setText(playersCards.get(1).toString());
        dealerCard1.setText(dealerCards.get(0).toString());
        updateTotalResult();
    }

    public void stand() throws InterruptedException {
        gameController.stand();
        /*
        this.playersCards = gameController.getPlayersCards();
        this.dealerCards = gameController.getDealersCards();

        switch (dealerCards.size()) {
            case 2:
                dealerCard2.setText(dealerCards.get(1).toString());
                break;
            case 3:
                dealerCard2.setText(dealerCards.get(1).toString());
                dealerCard3.setText(dealerCards.get(2).toString());
                break;
            case 4:
                dealerCard2.setText(dealerCards.get(1).toString());
                dealerCard3.setText(dealerCards.get(2).toString());
                dealerCard4.setText(dealerCards.get(3).toString());
                break;
        }
*/
        updateTotalResult();
    }

    public void declareWinner() throws InterruptedException {
        this.winner = gameController.getWinner();
        System.out.println("Winner: " + this.winner);
        sleep(3000);
        clearTable();
    }

    public void updateTotalResult() {
        playerTotal.setText("" + gameController.getPlayer().calculateHand());
        dealerTotal.setText("" + gameController.getDealer().getHand().calculateTotal());
    }

    public void setGameController(BlackjackController blackjackController) {
        gameController = blackjackController;
    }

    public void showCurrency() {
        playerCurrency.setText("\uD83D\uDCB2" + gameController.getPlayer().getCurrency());
    }

    public void init() {
        showCurrency();
    }
    //

    public void setBet() {
        int bet = Integer.parseInt(betField.getText());
        gameController.setBet(bet);
    }

    public void setPlayersCards(ArrayList<Card> playersCards) {
        switch (playersCards.size()) {
            case 1:
                playerCard1.setText(playersCards.get(0).toString());
                break;
            case 2:
                playerCard1.setText(playersCards.get(0).toString());
                playerCard2.setText(playersCards.get(1).toString());
                break;
            case 3:
                playerCard1.setText(playersCards.get(0).toString());
                playerCard2.setText(playersCards.get(1).toString());
                playerCard3.setText(playersCards.get(2).toString());
                break;
            case 4:
                playerCard1.setText(playersCards.get(0).toString());
                playerCard2.setText(playersCards.get(1).toString());
                playerCard3.setText(playersCards.get(2).toString());
                playerCard4.setText(playersCards.get(3).toString());
                break;
        }

        updateTotalResult();
    }

    public void setDealersCards(ArrayList<Card> dealerCards) {
        switch (dealerCards.size()) {
            case 1:
                System.out.println("yksi kortti");
                dealerCard1.setText(dealerCards.get(0).toString());
                break;
            case 2:
                System.out.println("2 korttia" + dealerCards.get(1).toString());
                dealerCard1.setText(dealerCards.get(0).toString());
                dealerCard2.setText(dealerCards.get(1).toString());
                System.out.println(dealerCard2.getText());
                break;
            case 3:
                dealerCard1.setText(dealerCards.get(0).toString());
                dealerCard2.setText(dealerCards.get(1).toString());
                dealerCard3.setText(dealerCards.get(2).toString());
                break;
            case 4:
                dealerCard1.setText(dealerCards.get(0).toString());
                dealerCard2.setText(dealerCards.get(1).toString());
                dealerCard3.setText(dealerCards.get(2).toString());
                dealerCard4.setText(dealerCards.get(3).toString());
                break;
        }
        updateTotalResult();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearTable() {
        hitButton.setDisable(true);
        standButton.setDisable(true);
        dealButton.setDisable(false);
        dealerCard1.setText("");
        dealerCard2.setText("");
        dealerCard3.setText("");
        dealerCard4.setText("");
        playerCard1.setText("");
        playerCard2.setText("");
        playerCard3.setText("");
        playerCard4.setText("");
        dealerTotal.setText("");
        playerTotal.setText("");
    }
}

