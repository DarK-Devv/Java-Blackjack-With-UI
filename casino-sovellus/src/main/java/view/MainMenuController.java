package view;

import controller.BlackjackController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for MainMenu.fxml
 */

public class MainMenuController {

    private BlackjackController gameController;

    /** Menu's Play-Button loads to InGameView.fxml
     * @param actionEvent
     * @throws IOException
     */
    public void playButton(ActionEvent actionEvent) throws IOException {

        //gameController.nextRound();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GUImain.class.getResource("/InGameView.fxml"));
        Parent gameParent = loader.load();

        InGameViewController controller = loader.getController();
        controller.setGameController(gameController);
        gameController.setInGameViewController(controller);
        controller.init();
        Scene gameScene = new Scene(gameParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Blackjack");
        window.setScene(gameScene);
        window.show();

    }

    /** Menu's Settings-Button loads to Settings.fxml
     * @param actionEvent
     * @throws IOException
     */
    public void settingsButton(ActionEvent actionEvent) throws IOException {

        Parent settingsParent = FXMLLoader.load(getClass().getResource("/Settings.fxml"));
        Scene settingsScene = new Scene(settingsParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Settings");
        window.setScene(settingsScene);
        window.show();

    }

    /** Menu's Quit-Button closes the program
     */
    @FXML private javafx.scene.control.Button quitButton;
    public void quitButton(){

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public void setGameController(BlackjackController blackjackController) {
        gameController = blackjackController;
    }
}
