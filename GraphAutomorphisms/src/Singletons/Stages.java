package Singletons;

import javafx.stage.Stage;

public class Stages {

    private static Stages stages = null;
    private Stage DrawAreaStage;
    private Stage ControlsStage;

    public static Stages getStages(){
        return (Stages.stages == null) ? Stages.stages = new Stages() : Stages.stages;
    }

    public Stage getDrawAreaStage() {
        return DrawAreaStage;
    }

    public void setDrawAreaStage(Stage drawAreaStage) {
        DrawAreaStage = drawAreaStage;
    }

    public Stage getControlsStage() {
        return ControlsStage;
    }

    public void setControlsStage(Stage controlsStage) {
        ControlsStage = controlsStage;
    }
}
