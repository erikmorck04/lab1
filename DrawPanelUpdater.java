import java.util.ArrayList;

public class DrawPanelUpdater {
    public DrawPanel drawPanel;

    public DrawPanelUpdater(DrawPanel panel) {
        drawPanel = panel;
    }
    public void update(ArrayList<Vehicle> vehicles){
        drawPanel.repaint();
    }
}
