package AnimatedDS;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class View {
    private Scene scene;
    private StackPane stackPane;
    private Button pushButton;
    private Button popButton;
    private Button peekButton; // New button for peeking
    private List<Rectangle> rectangles;
    private double initialY = 150; // Initial Y-coordinate for the bottom of the stack
    private double spacingY = 30; // Spacing between stacked rectangles

    public View() {
        stackPane = new StackPane();
        pushButton = new Button("Push");
        popButton = new Button("Pop");
        peekButton = new Button("Peek"); // Initialize the peek button

        VBox buttonBox = new VBox(pushButton, popButton, peekButton); // Add peek button to button box
        stackPane.getChildren().addAll(buttonBox);

        scene = new Scene(stackPane, 400, 300);

        rectangles = new ArrayList<>(); // Initialize list of rectangles

        pushButton.setOnAction(e -> {
            Rectangle rectangle = createRectangle(); // Create a new rectangle
            addRectangle(rectangle); // Add the rectangle to the view
        });

        popButton.setOnAction(e -> {
            removeTopRectangle(); // Remove the topmost rectangle from the view
        });

        peekButton.setOnAction(e -> {
            peekAtTopRectangle(); // Peek at the topmost rectangle
        });
    }

    public Scene getScene() {
        return scene;
    }

    private Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle(50, 20, Color.BLUE); // Create a new blue rectangle
        return rectangle;
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle); // Add rectangle to list
        updateStack(); // Update the stack visualization
    }

    public void removeTopRectangle() {
        if (!rectangles.isEmpty()) {
            rectangles.remove(rectangles.size() - 1); // Remove the topmost rectangle from the list
            updateStack(); // Update the stack visualization
        }
    }

    private void updateStack() {
        stackPane.getChildren().clear(); // Clear previous elements
        double currentY = initialY; // Starting Y-coordinate for the bottom of the stack
        for (Rectangle rectangle : rectangles) {
            rectangle.setTranslateY(currentY - rectangle.getHeight()); // Set the Y translation
            stackPane.getChildren().add(rectangle); // Add rectangle to the stack pane
            currentY -= spacingY; // Decrement Y-coordinate for next rectangle (to stack on top)
        }
        VBox buttonBox = new VBox(pushButton, popButton, peekButton); // Re-add buttons
        stackPane.getChildren().add(buttonBox);
    }

    private void peekAtTopRectangle() {
        if (!rectangles.isEmpty()) {
            Rectangle topRectangle = rectangles.get(rectangles.size() - 1); // Get the topmost rectangle
            topRectangle.setFill(Color.RED); // Highlight the top rectangle temporarily
            // Reset the color after a short delay (e.g., 1 second)
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        topRectangle.setFill(Color.BLUE); // Reset color to blue
                    }
                },
                1000 // 1 second delay
            );
        }
    }
    
    public Button getPushButton() {
        return pushButton;
    }

    public Button getPopButton() {
        return popButton;
    }

    public Rectangle getPushedRectangle() {
        return getPushedRectangle();
    }

    public StackPane getStackPane() {
        return stackPane;
    }
}
