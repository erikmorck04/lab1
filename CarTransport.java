import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {
    private Stack<Vehicle> carryList = new Stack<Vehicle>();
    private int max_cars;
    public CarTransport(double enginePower, Color color, String modelName, double length, int maxcars) {
        super(2, enginePower, color, modelName, 1, length);
        this.max_cars = maxcars;

    }
    public Stack<Vehicle> getCarryList(){
        return carryList;
    }

    public void rampOpen() {
        if (getCurrentSpeed() <= 0.001) { // Ensure the truck is not moving
            setFlakAngle(1);
            System.out.println("Ramp opened.");
        } else {
            System.out.println("Cannot open ramp while moving.");
        }
    }

    // Close the ramp (set flakAngle to 0)
    public void rampClose() {
        if (getCurrentSpeed() <= 0.001) { // Ensure the truck is not moving
            setFlakAngle(0);
            System.out.println("Ramp closed.");
        } else {
            System.out.println("Cannot close ramp while moving.");
        }
    }



    public void gas(double amount) {
        super.gas(amount);
        for (int x = 0; x < carryList.size(); x++) {
                //Finns garanterat ett bättre sätt att göra det här på
                //Hämtar ett objekt, ändrar xy och sen skickar tillbaka den
            Vehicle current = carryList.get(x);
            current.setY(getY());
            current.setX(getX());
            carryList.set(x, current);
                //Uppdatera alla bilar inuti så att deras position är rätt
        }
    }

    public boolean carInRange(Vehicle car) { // phytagoras för att räkna ut distans från CarTransport til car
        double xDistance = Math.abs(this.getX() - car.getX());
        double yDistance = Math.abs(this.getY() - car.getY());
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return distance <= 10;
    }

    public void loadCar(Vehicle car) {
        if (carInRange(car) && getFlakAngle() == 1 && carryList.size() != max_cars) {
            if (!carryList.contains(car) && !(car instanceof CarTransport) && car.getLength() <= 6) {
                carryList.push(car);
                System.out.println(car.getModelName() + "har loadats");
            }
        }
    }

    public void unloadCar() {
        if (getFlakAngle() == 1 && getCurrentSpeed() == 0 && !carryList.isEmpty()) {
            Vehicle unloaded = carryList.getLast();
            carryList.pop();
            unloaded.setX(getX());
            unloaded.setY(getY());
            System.out.println(unloaded.getModelName() + " unloaded");
        }
    }
}
