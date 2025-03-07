import java.awt.*;

public class Carsim {

    public static void main(String[] args) {
        CarView cv = new CarView("Carsim 1.01");
        //CarController cc = new CarController();

        Workshop<Volvo240> volvoWorkshop = new Workshop<>(3, 500, 400, 50, 50, Volvo240.class);
        cv.carC.carManager.addWorkshop(volvoWorkshop);
        //cc.carManager.addVehicle(Volvo240.createVolvo());
        //cc.carManager.addVehicle(Saab95.createSaab());
        //cc.carManager.addVehicle(Scania.createScania());
    }
}
