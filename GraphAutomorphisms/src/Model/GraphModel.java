package Model;

import DataStructures.Graphs.Graph;
import DataStructures.List.List;
import Singletons.Tabs;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class GraphModel {

    private final Graph MainGraph;

    public GraphModel(){
        this.MainGraph = new Graph();
    }

    public Graph getMainGraph() {
        return MainGraph;
    }

    public void setPermutations(List<int[]> permutations) {
        StringBuilder s = new StringBuilder();
        for(int[] a : permutations){
            s.append("->").append(this.permutationToString(a)).append("\n");
        }
        ((TextArea)((GridPane) Tabs.getTabs().getResultTab().getContent()).getChildren().get(1)).setText(s.toString());
    }

    private String permutationToString(int[] permutation){
        StringBuilder s = new StringBuilder();
        boolean[] check = new boolean[permutation.length];
        int value = 0;
        int per = 0;
        while(!allCheck(check)){
            for (int i = 0; i < check.length; i++) {
                if (!check[i]) {
                    value = i;
                    per = permutation[value];
                    check[i] = true;
                    break;
                }
            }
            if (per != value + 1) {
                s.append("(").append(value + 1).append(", ");
                while (per != value + 1) {
                    s.append(per).append(", ");
                    check[per - 1] = true;
                    per = permutation[per - 1];
                }
                s = new StringBuilder(s.substring(0, s.length() - 2));
                s.append(")");
            }

        }
        return (s.toString().equals("")) ? "e" : s.toString();
    }

    private boolean allCheck(boolean[] array){
        boolean flag = true;
        for(boolean b : array){
            flag &= b;
        }
        return flag;
    }

}
