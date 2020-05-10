package DataStructures.Graphs;

import DataStructures.List.ArrayList;
import DataStructures.List.List;
import Model.PermutationList;

public class Graph{

    private List<GraphNode> nodes;
    private List<GraphEdge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int nodesNumber() {
        return this.nodes.Size();
    }

    public boolean addNode(int Element) {
        this.nodes.Add(new GraphNode(Element));
        return true;
    }

    public boolean addEdge(int StartNode, int EndNode) {
        for(GraphEdge ge : this.edges){
            if(ge.ExistElement(StartNode) && ge.ExistElement(EndNode)){
                return false;
            }
        }
        this.edges.Add(new GraphEdge(StartNode, EndNode));
        return true;
    }

    public boolean removeNode(int Element) {
        GraphNode node = this.getNode(Element);
        if(node == null) {
            return false;
        }
        this.RemoveEdges(Element);
        this.nodes.Remove(node);
        return true;
    }

    public boolean removeEdge(int StartNode, int EndNode) {
        for(GraphEdge ge : this.edges){
            if(ge.ExistElement(StartNode) && ge.ExistElement(EndNode)){
                this.edges.Remove(ge);
                return true;
            }
        }
        return false;
    }

    public boolean existEdge(int StartNode, int EndNode) {
        for(GraphEdge ge : this.edges){
            if(ge.ExistElement(StartNode) && ge.ExistElement(EndNode)){
                return true;
            }
        }
        return false;
    }

    public boolean existElement(int Element) {
        return this.getNode(Element) != null;
    }

    public GraphNode getNode(int Element){
        GraphNode node = null;
        for(GraphNode n : this.nodes){
            if(n.getElement() == Element){
                node = n;
                break;
            }
        }
        return node;
    }

    private boolean RemoveEdges(int Element){
        for(int i = 0; i< this.edges.Size(); i++){
            if(this.edges.Get(i).ExistElement(Element)){
                this.edges.Remove(i);
                i--;
            }
        }

        return true;
    }

    public Graph clone() {
        Graph c = new Graph();
        for(GraphNode gn : this.nodes){
            c.addNode(gn.getElement());
        }
        for(GraphEdge ge : this.edges){
            c.addEdge(ge.getElement1(),ge.getElement2());
        }
        return c;
    }

    public List<int[]> getAutomorphisms(){
        int[][] permutations = PermutationList.getPermutations(this.nodes.Size());
        List<int[]> automorphisms = new ArrayList<>();
        for(int i = 0; i < permutations.length; i++){
            boolean exist = true;
            Graph testGraph = this.clone();
            testGraph = SwapNodes(testGraph, permutations, i);
            for(GraphEdge gn : this.edges){
                if(!testGraph.existEdge(gn.getElement1(), gn.getElement2())){
                    exist = false;
                    break;
                }
            }
            if(exist){
                automorphisms.Add(permutations[i]);
            }
        }
        return automorphisms;
    }

    private Graph SwapNodes(Graph graph, int[][] permutations, int row){
        for(GraphEdge ge : graph.edges){
            ge.setElement1(permutations[row][ge.getElement1() - 1]);
            ge.setElement2(permutations[row][ge.getElement2() - 1]);
        }
        return graph;
    }

    public List<GraphNode> getNodes() {
        return this.nodes;
    }

    public List<GraphEdge> getEdges() {
        return this.edges;
    }

}
