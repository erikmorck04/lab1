import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Truck {
    private Stack<Car> carryList = new Stack<Car>();
    private int flakAngle;
    private int max_cars;
    public CarTransport(double enginePower, Color color, String modelName,double length, int maxcars) {
        super(2, enginePower, color, modelName, 1,length);
        flakAngle = 1;
        max_cars = maxcars;
    }

    public void rampOpen() {
        flakAngle = 0;
    }

    public void rampClose() {
        flakAngle = 1;
    }

    public void Move() {
        if (getFlakAngle() == 0) {
            super.move();
            //Uppdatera alla bilar inuti så att deras position är rätt
            for (int x = 0; x < carryList.size(); x++) {
                //Finns garanterat ett bättre sätt att göra det här på
                //Hämtar ett objekt, ändrar xy och sen skickar tillbaka den
                Car current = carryList.get(x);
                current.setY(getY());
                current.setX(getX());
                carryList.set(x, current);
            }
        }
    }
    public boolean carInRange (Car car){
        double xDistance = Math.abs(this.getX() - car.getX()); // ex(10,25) och (30,10) blir 20,15
        double yDistance = Math.abs(this.getY() - car.getY());
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return distance <= 10;
    }
    public void loadCar(Car car) {
        if (carInRange(car) && getFlakAngle() ==0 && carryList.size()!=max_cars) {
            if (!carryList.contains(car) && !(car instanceof CarTransport) && car.getLength()<=6) {
                carryList.push(car);
                System.out.println(car.getModelName() + "har loadats");
                System.out.println(carryList);
            }
        }
    }
    public void unloadCar() {
        if (getFlakAngle() == 0) {
            Car unloaded = carryList.getLast();
            carryList.pop();
            unloaded.setX(getX());
            unloaded.setY(getY());
            unloaded.move();
            System.out.println("Car " + unloaded.getModelName() + " has been unloaded.");
        }
    }
}

