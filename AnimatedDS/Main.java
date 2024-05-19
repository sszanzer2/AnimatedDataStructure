package AnimatedDS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model(); // Create an instance of the Model class
        View view = new View(); // Create an instance of the View class
        Controller controller = new Controller(model, view); // Create an instance of the Controller class

        primaryStage.setTitle("Animated Stack");
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
