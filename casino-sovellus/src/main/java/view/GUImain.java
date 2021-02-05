package view;
import controller.BlackjackController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static javafx.application.Application.launch;

/**
 * Main class of the app. Initializes the views, variables and controller
 */
public class GUImain extends Application {
    public Stage primaryStage;
    private AnchorPane rootLayout;
    private BlackjackController ctrl = new BlackjackController();

    /**
     * main function to launch the app
     * @param args
     */
    public static void main(String[] args) {

        launch(args);
    }

    /**
     * Function that is called from launch. Sets the views and initializes the stage.
     * @param primaryStage is the primary stage set for the view
     */
    public void start(Stage primaryStage) {
        // Building the User Interface
        try {

            primaryStage.setOnCloseRequest(new EventHandler<>() {
                @Override
                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("The Grand Myllypuro");

            initRootLayout();

            // Set the application icon. (These can be used later)

            //Image icon = new Image(getClass().getResource("img/....png").toExternalForm());
            //this.primaryStage.getIcons().add(icon);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads up the root layout and sets the controller, shows the primary stage
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUImain.class.getResource("/MainMenu.fxml"));
            rootLayout = loader.load();
            MainMenuController controller = loader.getController();
            controller.setGameController(ctrl);
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
