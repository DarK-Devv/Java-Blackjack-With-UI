
import controller.BlackjackController;
import model.BlackjackGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class dummytest {

    BlackjackGame blackJack = new BlackjackGame(new BlackjackController());

    @Test
    public void blackjackisreal() {
        Assertions.assertTrue(blackJack != null);
    }
}
