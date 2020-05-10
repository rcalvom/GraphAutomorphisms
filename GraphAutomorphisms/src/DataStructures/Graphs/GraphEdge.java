package DataStructures.Graphs;

public class GraphEdge {

    private int Element1;
    private int Element2;

    public GraphEdge(int element1, int element2) {
        this.Element1 = element1;
        this.Element2 = element2;
    }

    public int getElement1() {
        return Element1;
    }

    public void setElement1(int element1) {
        Element1 = element1;
    }

    public int getElement2() {
        return Element2;
    }

    public void setElement2(int element2) {
        Element2 = element2;
    }

    public boolean ExistElement(int element){
        return element == this.Element1 || element == this.Element2;
    }

}
