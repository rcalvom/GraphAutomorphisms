package Views;

import Singletons.Tabs;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ResultsView {

    private Label LTitle1, LTitle2;
    private TextArea TAResults, TAExplication;

    public ResultsView() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        this.LTitle1 = new Label("Found elements of the group of automorphisms.");
        LTitle1.setStyle("-fx-font-size:16px; -fx-font-weight: bold;");
        gridPane.add(LTitle1,0,0,1,1);


        this.TAResults = new TextArea();
        this.TAResults.setEditable(false);
        TAResults.setStyle("-fx-font-size:12px; -fx-font-weight: bold; -fx-background-color: black;");
        gridPane.add(TAResults,0,1,1,1);

        Pane p = new Pane();
        p.minHeightProperty().bind(LTitle1.heightProperty());
        gridPane.add(p,0,2,1,1);

        this.LTitle2 = new Label("How does the algorithm work?");
        LTitle2.setStyle("-fx-font-size:16px; -fx-font-weight: bold;");
        gridPane.add(LTitle2,0,3,1,1);

        this.TAExplication = new TextArea();
        this.TAExplication.setEditable(false);
        this.TAExplication.setWrapText(true);
        this.TAExplication.setText("In this algorithm at the beginning, it finds all the possible permutations, that is, it calculates Sym (Number of nodes) to be able to iterate for each possible permutation of the graph. During this iteration, each edge on the original chart is verified to continue on the permuted graph. Finally, choose permutations that do not alter the original composition of the graph.");
        TAExplication.setStyle("-fx-font-size:13px; -fx-font-weight: bold; -fx-background-color: black;");
        gridPane.add(TAExplication,0,4,1,1);

        Tabs.getTabs().getResultTab().setContent(gridPane);

    }
}
