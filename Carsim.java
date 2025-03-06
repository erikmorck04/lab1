import java.awt.*;

public class Carsim {

    public static void main(String[] args) {
        CarController cc = new CarController();

        Workshop<Volvo240> volvoWorkshop = new Workshop<>(3, 500, 400, 50, 50, Volvo240.class);

        cc.carManager.addWorkshop(volvoWorkshop);

        cc.carManager.addVehicle(new Volvo240());
        cc.carManager.addVehicle(new Saab95());
        cc.carManager.addVehicle(new Scania());

    }

    public abstract static class Car extends Vehicle {
        public Car(int nrDoors, double enginePower, Color color, String modelName, double length){
            super(nrDoors, enginePower, color, modelName, length);
        }

    }
}
