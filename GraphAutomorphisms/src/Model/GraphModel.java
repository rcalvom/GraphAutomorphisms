package Model;

import DataStructures.Graphs.Graph;
import DataStructures.List.List;
import Singletons.Tabs;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class GraphModel {

    private final Graph MainGraph;
    private List<int[]> permutations;

    public GraphModel(){
        this.MainGraph = new Graph();
    }

    public Graph getMainGraph() {
        return MainGraph;
    }

    public List<int[]> getPermutations() {
        return this.permutations;
    }

    public void setPermutations(List<int[]> permutations) {
        this.permutations = permutations;
        String s = "";
        for(int[] a : permutations){
            s = s + "->" +this.permutationToString(a) + "\n";
        }
        ((TextArea)((GridPane) Tabs.getTabs().getResultTab().getContent()).getChildren().get(1)).setText(s);
    }

    private String permutationToString(int[] permutation){
        String s = "";
        boolean[] check = new boolean[permutation.length];
        int value = 0;
        int per = 0;
        while(!allCheck(check)){
            for(int i = 0; i< check.length; i++){
                if(!check[i]){
                    value = i;
                    per = permutation[value];
                    check[i] = true;
                    break;
                }
            }
            s = s + "(" + (value + 1) + ", ";
            while(per != value + 1){
                s = s + per + ", ";
                check[per - 1] = true;
                per = permutation[per - 1];
            }
            s = s.substring(0, s.length()-2);
            s = s + ")";
        }
        return s;
    }

    private boolean allCheck(boolean[] array){
        boolean flag = true;
        for(boolean b : array){
            flag &= b;
        }
        return flag;
    }

}
