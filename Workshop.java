import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class Workshop<T extends Vehicle> {
    private final int maxCars;
    private final Rectangle2D.Double hitbox;
    private final ArrayList<T> carList = new ArrayList<>();

   //Constructor för workshop
    public Workshop(int maxCars,double x, double y,double width, double height) {
        this.hitbox = new Rectangle2D.Double(x, y,width, height);
        this.maxCars = maxCars;
    }


    public boolean isInHitbox(Vehicle vehicle) {
        return hitbox.contains(vehicle.getX(), vehicle.getY());
    }

    // Returnerar alla bilar i workshoppen
    public ArrayList<T> getCarList() {
        return carList;
    }
    // Kollar om workshoppen kan ta emot fordon
    public void acceptCar(T car) {
        if (carList.size() >= maxCars) {
            System.out.println("Workshop is full");
        } else if (carList.contains(car)){
            System.out.println("Bil redan i verkstad");
        }
        else {
            carList.add(car);
            car.setLoaded(true);
        }
    }
    //Printar alla bilar som finns i workshoppen
    public void prints_cars(){
        for (T car : carList) {
            System.out.println(car);
        }
    }
    // Lämnar ut fordon från workshop
    public void removeCar(T car){
        if(carList.contains(car)){
            carList.remove(car);
            System.out.println("Vehicle has left the workshop");
            car.setLoaded(false);
        }else{
            System.out.println("Bil ej i verkstad");
        }
    }

}



