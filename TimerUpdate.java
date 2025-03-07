import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerUpdate {

    private final CarManager carManager;
    public final DrawPanelUpdater drawPanelUpdater;
    public TimerUpdate(CarManager carManager, DrawPanelUpdater carViewUpdater) {
        this.carManager = carManager;
        this.drawPanelUpdater = carViewUpdater;
        Timer timer = new Timer(50, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carManager.updateVehicles();
            for (Vehicle vehicle : carManager.getVehicles()) {
                if (!vehicle.isLoaded()){
                    for (Workshop<?> workshop : carManager.getWorkshops()) { // Iterate through all workshops
                        if (workshop.isInHitbox(vehicle)) {
                            workshop.acceptCar(vehicle); // Let the workshop handle the vehicle
                            break; // Stop checking other workshops for this vehicle
                        }
                    }
                }

            }
            drawPanelUpdater.update(carManager.getVehicles());
        }
    }
}
