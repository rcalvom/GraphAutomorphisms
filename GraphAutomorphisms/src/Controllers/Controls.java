package Controllers;

import DataStructures.List.List;
import Model.GraphModel;
import Singletons.Stages;
import Views.ControlsView;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Collections;

public class Controls {

    private final GraphModel graphModel;
    private final ControlsView view;

    public Controls(GraphModel graphModel) {
        this.graphModel = graphModel;
        this.view = new ControlsView();
        this.view.getBCreateVertex().setOnAction(new CreateVertex());
        this.view.getBRemoveVertex().setOnAction(new RemoveVertex());
        this.view.getBEdge().setOnAction(new Edge());
        this.view.getBGenerate().setOnAction(new Generate());
        this.view.getBRemoveVertex().setDisable(true);
        this.view.getCBVertex().setDisable(true);
        this.view.getCBEdgeA().setDisable(true);
        this.view.getCBEdgeB().setDisable(true);
        this.view.getBEdge().setDisable(true);
        this.view.getBGenerate().setDisable(true);
        this.view.getCBEdgeA().valueProperty().addListener((InvalidationListener) new EditComboBox());
        this.view.getCBEdgeB().valueProperty().addListener((InvalidationListener) new EditComboBox());
    }

    public void Show(){
        this.view.Show(Stages.getStages().getControlsStage());
    }

    public GraphModel getGraphModel() {
        return graphModel;
    }

    private class CreateVertex implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            int element = 0;
            while(true){
                if(!graphModel.getMainGraph().existElement(++element)){
                    break;
                }
            }
            graphModel.getMainGraph().addNode(element);
            view.getCBVertex().getItems().add(element);
            ObservableList<String> ol = view.getCBVertex().getItems();
            Collections.sort(ol);
            view.getCBVertex().setItems(ol);
            view.getCBEdgeA().setItems(ol);
            view.getCBEdgeB().setItems(ol);

            view.getBRemoveVertex().setDisable(false);
            view.getCBVertex().setDisable(false);
            view.getCBEdgeA().setDisable(false);
            view.getCBEdgeB().setDisable(false);
            view.getBEdge().setDisable(false);
            view.getBGenerate().setDisable(false);
        }

    }

    private class RemoveVertex implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int node = (int)view.getCBVertex().getSelectionModel().getSelectedItem();
            graphModel.getMainGraph().removeNode(node);
            view.getCBVertex().getItems().remove((Integer)node);
            view.getCBEdgeA().getItems().remove((Integer)node);
            view.getCBEdgeB().getItems().remove((Integer)node);
            if(graphModel.getMainGraph().nodesNumber() == 0){
                view.getBRemoveVertex().setDisable(true);
                view.getCBVertex().setDisable(true);
                view.getCBEdgeA().setDisable(true);
                view.getCBEdgeB().setDisable(true);
                view.getBEdge().setDisable(true);
                view.getBGenerate().setDisable(true);
            }
        }
    }

    private class Edge implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(view.getCBEdgeA().getSelectionModel().getSelectedItem() == view.getCBEdgeB().getSelectionModel().getSelectedItem()){
                return;
            }
            if(view.getBEdge().getText().equals("Create.")){
                graphModel.getMainGraph().addEdge((int) view.getCBEdgeA().getSelectionModel().getSelectedItem(), (int) view.getCBEdgeB().getSelectionModel().getSelectedItem());
                view.getBEdge().setText("Remove.");
            }else{
                graphModel.getMainGraph().removeEdge((int) view.getCBEdgeA().getSelectionModel().getSelectedItem(), (int) view.getCBEdgeB().getSelectionModel().getSelectedItem());
                view.getBEdge().setText("Create.");
            }
        }
    }

    private class EditComboBox implements javafx.beans.value.ChangeListener, javafx.beans.InvalidationListener {
        @Override
        public void invalidated(Observable observable) {
            if(view.getCBEdgeA().getSelectionModel().getSelectedItem() == null || view.getCBEdgeB().getSelectionModel().getSelectedItem() == null){
                return;
            }else if((int)view.getCBEdgeA().getSelectionModel().getSelectedItem() == (int) view.getCBEdgeB().getSelectionModel().getSelectedItem()){
                view.getBEdge().setDisable(true);
            }else{
                if(graphModel.getMainGraph().existEdge((int) view.getCBEdgeA().getSelectionModel().getSelectedItem(), (int) view.getCBEdgeB().getSelectionModel().getSelectedItem())){
                    view.getBEdge().setText("Remove.");
                }else{
                    view.getBEdge().setText("Create.");
                }
                view.getBEdge().setDisable(false);
            }
        }
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) { }
    }

    private class Generate implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            graphModel.setPermutations(graphModel.getMainGraph().getAutomorphisms());
        }
    }

}
