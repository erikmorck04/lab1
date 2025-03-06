import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Carsim {

    public static void main(String[] args) {
        CarController cc = new CarController();

        Workshop<Volvo240> volvoWorkshop = new Workshop<>(3, 300, 300, 50, 50);

        cc.carManager.addVehicle(new Volvo240());
        cc.carManager.addVehicle(new Saab95());
        cc.carManager.addVehicle(new Scania());
    }
}
