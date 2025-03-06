import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerUpdate {

    private final CarManager carManager;
    private final CarViewUpdater carViewUpdater;
    public TimerUpdate(CarManager carManager, CarViewUpdater carViewUpdater) {
        this.carManager = carManager;
        this.carViewUpdater = carViewUpdater;
        Timer timer = new Timer(50, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carManager.updateVehicles();
            for (Vehicle vehicle : carManager.getVehicles()) {
                if (vehicle instanceof Volvo240 && carManager.volvoWork.isInHitbox(vehicle)) {
                    carManager.volvoWork.acceptCar((Volvo240) vehicle);
                }
            }
            carViewUpdater.update(carManager.getVehicles());
        }
    }
}
