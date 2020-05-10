package Main;

import Controllers.Controls;
import Controllers.MainArea;
import Model.GraphModel;
import Singletons.Stages;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        GraphModel graphModel = new GraphModel();

        Stages.getStages().setDrawAreaStage(PrimaryStage);
        Stages.getStages().setControlsStage(new Stage());

        MainArea mainArea = new MainArea(graphModel);
        mainArea.Show();

        Controls controls = new Controls(graphModel);
        controls.Show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
