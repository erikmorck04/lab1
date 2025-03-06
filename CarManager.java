import java.util.ArrayList;

public class CarManager{

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public CarManager(){

    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void updateVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
