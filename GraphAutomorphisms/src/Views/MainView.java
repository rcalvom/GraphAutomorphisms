package Views;

import Singletons.Tabs;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainView {

    private final Scene scene;

    public MainView(){
        TabPane tabPane = new TabPane();

        Tab DrawTab = new Tab("Draw a graph");
        DrawTab.setClosable(false);
        Tab ResultTab = new Tab("Automorphisms found");
        ResultTab.setClosable(false);

        tabPane.getTabs().add(DrawTab);
        Tabs.getTabs().setDrawTab(DrawTab);

        tabPane.getTabs().add(ResultTab);
        Tabs.getTabs().setResultTab(ResultTab);

        VBox panel = new VBox(tabPane);
        this.scene = new Scene(panel,Screen.getPrimary().getBounds().getWidth()/2, Screen.getPrimary().getBounds().getHeight()/2, Color.LIGHTGREY);

    }

    public void Show(Stage stage){
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setTitle("Graph Automorphisms.");
        stage.setScene(scene);
        stage.setX(Screen.getPrimary().getBounds().getMinX() + Screen.getPrimary().getBounds().getWidth()/6);
        stage.setY(Screen.getPrimary().getBounds().getMinY() + Screen.getPrimary().getBounds().getHeight()/4);
        stage.show();
        stage.setOnCloseRequest(( e) -> Platform.exit());
    }

}
