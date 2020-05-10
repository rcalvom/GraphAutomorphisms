package Views;

import Singletons.Tabs;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class DrawView {

    private final GraphicsContext gc;

    public DrawView() {
        Pane panel = new Pane();
        Canvas canvas = new Canvas(Screen.getPrimary().getBounds().getWidth()/2,Screen.getPrimary().getBounds().getHeight()/2);
        panel.getChildren().add(canvas);
        Tabs.getTabs().getDrawTab().setContent(panel);
        this.gc = canvas.getGraphicsContext2D();
    }

    public GraphicsContext getGc() {
        return gc;
    }
}
