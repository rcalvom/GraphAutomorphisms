package DataStructures.Graphs;

import javafx.scene.shape.Circle;

public class GraphNode {
    private int element;
    private final Circle circle;
    private boolean Selected;

    public GraphNode(int element){
        this.element = element;
        this.circle = new Circle(50,50,25);
        this.Selected = false;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Circle getCircle() {
        return this.circle;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }
}
