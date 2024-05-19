package AnimatedDS;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Set event handlers for buttons
        view.getPushButton().setOnAction(new PushButtonHandler());
        view.getPopButton().setOnAction(new PopButtonHandler());
    }

    // Event handler for the push button
    private class PushButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Rectangle rectangle = new Rectangle(50, 20, Color.BLUE); // Create a new blue rectangle
            view.addRectangle(rectangle); // Add the rectangle to the view
        }
    }

    // Event handler for the pop button
    private class PopButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            view.removeTopRectangle(); // Remove the topmost rectangle from the view
        }
    }
}
