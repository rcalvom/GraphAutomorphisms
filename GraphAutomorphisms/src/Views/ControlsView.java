package Views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ControlsView {

    private final Scene scene;
    private final ComboBox CBVertex, CBEdgeA, CBEdgeB;
    private final Button BCreateVertex, BRemoveVertex, BEdge, BGenerate;

    public ControlsView() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        Rectangle2D screen = Screen.getPrimary().getBounds();
        this.scene = new Scene(gridPane, screen.getWidth()/6, screen.getHeight()/2);

        Label LTitle = new Label("Controls");
        LTitle.setStyle("-fx-font-size:16px; -fx-font-weight: bold;");

        Label LVertex = new Label("Vertices");
        LVertex.setStyle("-fx-font-weight: bold;");

        Label LEdges = new Label("Edges");
        LEdges.setStyle("-fx-font-weight: bold;");

        this.CBVertex = new ComboBox();
        this.CBEdgeA = new ComboBox();
        this.CBEdgeB = new ComboBox();

        this.BCreateVertex = new Button("Create.");
        this.BRemoveVertex = new Button("Remove.");
        this.BEdge = new Button("Create.");
        this.BGenerate = new Button("Generate Automorphisms");

        Pane p1 = new Pane();
        p1.minHeightProperty().bind(LTitle.heightProperty());

        Pane p2 = new Pane();
        p2.minHeightProperty().bind(LTitle.heightProperty());

        Pane p3 = new Pane();
        p3.minHeightProperty().bind(LTitle.heightProperty());

        gridPane.add(LTitle, 0,0,3,1);
        GridPane.setFillWidth(LTitle, true);
        GridPane.setFillHeight(LTitle, true);
        gridPane.add(p1, 0,1,3,1);
        GridPane.setFillWidth(p1, true);
        GridPane.setFillHeight(p1, true);
        gridPane.add(LVertex, 0,2,2,1);
        GridPane.setFillWidth(LVertex, true);
        GridPane.setFillHeight(LVertex, true);
        gridPane.add(CBVertex, 0,3, 1,1);
        GridPane.setFillWidth(CBVertex, true);
        GridPane.setFillHeight(CBVertex, true);
        gridPane.add(BCreateVertex, 1,3,1 ,1);
        GridPane.setFillWidth(BCreateVertex, true);
        GridPane.setFillHeight(BCreateVertex, true);
        gridPane.add(BRemoveVertex, 2,3,1 ,1);
        GridPane.setFillWidth(BRemoveVertex, true);
        GridPane.setFillHeight(BRemoveVertex, true);
        gridPane.add(p2, 0,4,3,1);
        GridPane.setFillWidth(p2, true);
        GridPane.setFillHeight(p2, true);
        gridPane.add(LEdges, 0,5,2,1);
        GridPane.setFillWidth(LEdges, true);
        GridPane.setFillHeight(LEdges, true);
        gridPane.add(CBEdgeA, 0,6,1,1);
        GridPane.setFillWidth(CBEdgeA, true);
        GridPane.setFillHeight(CBEdgeA, true);
        gridPane.add(CBEdgeB, 1,6,1,1);
        GridPane.setFillWidth(CBEdgeB, true);
        GridPane.setFillHeight(CBEdgeB, true);
        gridPane.add(BEdge, 2,6,1,1);
        GridPane.setFillWidth(BEdge, true);
        GridPane.setFillHeight(BEdge, true);
        gridPane.add(p3, 0,7,3,1);
        GridPane.setFillWidth(p3, true);
        GridPane.setFillHeight(p3, true);
        gridPane.add(BGenerate, 0,8,3,1);
        GridPane.setFillWidth(BGenerate, true);
        GridPane.setFillHeight(BGenerate, true);
    }

    public void Show(Stage stage){
        stage.setScene(this.scene);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setTitle("Controls");
        stage.setX(Screen.getPrimary().getBounds().getMinX() + 4 * Screen.getPrimary().getBounds().getWidth()/6);
        stage.setY(Screen.getPrimary().getBounds().getMinY() + Screen.getPrimary().getBounds().getHeight()/4);
        stage.show();
        stage.setOnCloseRequest(( e) -> Platform.exit());
    }

    public ComboBox getCBVertex() {
        return CBVertex;
    }

    public ComboBox getCBEdgeA() {
        return CBEdgeA;
    }

    public ComboBox getCBEdgeB() {
        return CBEdgeB;
    }

    public Button getBCreateVertex() {
        return BCreateVertex;
    }

    public Button getBRemoveVertex() {
        return BRemoveVertex;
    }

    public Button getBEdge() {
        return BEdge;
    }

    public Button getBGenerate() {
        return BGenerate;
    }

}
