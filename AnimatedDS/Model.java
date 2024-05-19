package AnimatedDS;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Stack;

public class Model {
    private Stack<Rectangle> stack; // Stack to hold rectangles

    public Model() {
        stack = new Stack<>();
    }

    public void push(Rectangle rectangle) {
        stack.push(rectangle);
    }

    public Rectangle pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            return null; // Return null if the stack is empty
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
