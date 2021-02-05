import model.Logger;
import view.GUImain;

import static javafx.application.Application.launch;

/**
 * Main class of the app. Initializes the views, variables and controller
 */
public class main {


    /**
     * main function to launch the app
     * @param args
     */
    public static void main(String[] args) {
        Logger.setLogLevel(Logger.LogLevel.ALL);
        GUImain.main(args);
    }

}
