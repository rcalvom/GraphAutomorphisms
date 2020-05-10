package Controllers;

import Model.GraphModel;
import Singletons.Stages;
import Views.MainView;
import Views.ResultsView;

public class MainArea {

    private final GraphModel graphModel;
    private final MainView view;
    private final DrawArea drawArea;
    private final Results results;

    public MainArea(GraphModel graphModel) {
        this.graphModel = graphModel;
        this.view = new MainView();
        this.drawArea = new DrawArea(this.graphModel);
        this.results = new Results(this.graphModel);
    }

    public void Show(){
        this.view.Show(Stages.getStages().getDrawAreaStage());
    }

}
