package Controllers;

import DataStructures.Graphs.GraphEdge;
import DataStructures.Graphs.GraphNode;
import Model.GraphModel;
import Views.DrawView;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class DrawArea extends AnimationTimer {

    private GraphModel graphModel;
    private GraphNode SelectedNode;
    private final GraphicsContext Gc;
    private final int DrawWidth;
    private final int DrawHeight;

    public DrawArea(GraphModel graphModel){
        this.graphModel = graphModel;
        DrawView drawView = new DrawView();
        this.SelectedNode = null;
        this.Gc = drawView.getGc();
        this.Gc.getCanvas().addEventFilter(MouseEvent.MOUSE_PRESSED, EnterNode);
        this.Gc.getCanvas().addEventFilter(MouseEvent.MOUSE_DRAGGED, DragNode);
        this.Gc.getCanvas().addEventFilter(MouseEvent.MOUSE_RELEASED, ExitNode);
        this.Gc.setLineWidth(3);
        this.DrawWidth = (int)Screen.getPrimary().getBounds().getWidth()/2;
        this.DrawHeight = (int)Screen.getPrimary().getBounds().getHeight()/2;
        Font font = new Font(20);
        this.Gc.setFont(font);
        this.start();
    }

    @Override
    public void handle(long now) {
        this.Gc.clearRect(0, 0, this.DrawWidth, this.DrawHeight);
        for (GraphEdge edge : this.graphModel.getMainGraph().getEdges()) {
            Circle circle1 = this.graphModel.getMainGraph().getNode(edge.getElement1()).getCircle();
            Circle circle2 = this.graphModel.getMainGraph().getNode(edge.getElement2()).getCircle();
            this.Gc.setStroke(Color.BLACK);
            this.Gc.strokeLine(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        }
        for (GraphNode node : this.graphModel.getMainGraph().getNodes()) {
            this.Gc.setFill(Color.DARKCYAN);
            this.Gc.fillOval(node.getCircle().getCenterX() - node.getCircle().getRadius(), node.getCircle().getCenterY() - node.getCircle().getRadius(), 2 * node.getCircle().getRadius(), 2 * node.getCircle().getRadius());

            if (node.isSelected()) {
                this.Gc.setStroke(Color.RED);
                this.Gc.setFill(Color.RED);
            } else {
                this.Gc.setStroke(Color.BLACK);
                this.Gc.setFill(Color.BLACK);
            }
            this.Gc.strokeOval(node.getCircle().getCenterX() - node.getCircle().getRadius(), node.getCircle().getCenterY() - node.getCircle().getRadius(), 2 * node.getCircle().getRadius(), 2 * node.getCircle().getRadius());
            this.Gc.fillText(node.getElement() + "", node.getCircle().getCenterX() - 7, node.getCircle().getCenterY() + 7);
        }
    }

    EventHandler<MouseEvent> EnterNode = e -> {
        for(GraphNode node: this.graphModel.getMainGraph().getNodes()){
            if(Math.pow((int)e.getX() - node.getCircle().getCenterX(),2) + Math.pow((int)e.getY() - node.getCircle().getCenterY(),2) <= Math.pow(node.getCircle().getRadius(),2)){
                this.SelectedNode = node;
                this.SelectedNode.setSelected(true);
                break;
            }
        }
    };

    EventHandler<MouseEvent> DragNode = e -> {
        if(this.SelectedNode != null){
            this.SelectedNode.getCircle().setCenterX(e.getX());
            this.SelectedNode.getCircle().setCenterY(e.getY());
        }
    };

    EventHandler<MouseEvent> ExitNode = e -> {
        if(this.SelectedNode != null) {
            this.SelectedNode.setSelected(false);
            this.SelectedNode = null;
        }
    };

}
