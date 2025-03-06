import java.util.ArrayList;

public class CarViewUpdater {
    private final CarView frame;

    public CarViewUpdater(CarView carView) {
        frame = carView;
    }
    public void update(ArrayList<Vehicle> vehicles){
        frame.drawPanel.repaint();
    }
}
