package Singletons;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class Tabs {

    private static Tabs tabs = null;
    private Tab drawTab;
    private Tab resultTab;

    public static Tabs getTabs(){
        return (Tabs.tabs == null) ? Tabs.tabs = new Tabs() : Tabs.tabs;
    }

    public Tab getDrawTab() {
        return drawTab;
    }

    public void setDrawTab(Tab drawTab) {
        this.drawTab = drawTab;
    }

    public Tab getResultTab() {
        return resultTab;
    }

    public void setResultTab(Tab resultTab) {
        this.resultTab = resultTab;
    }

}
