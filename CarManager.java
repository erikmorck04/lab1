import java.util.ArrayList;

public class CarManager{
    private int nextYPos = 0;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final ArrayList<Workshop<?>> workshops = new ArrayList<>();

    //Inte en bil men ska vara här ändå
    public CarManager(){

    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setY(nextYPos);
        vehicles.add(vehicle);
        nextYPos += 100;
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

    public void addWorkshop(Workshop<?> workshop) {
        workshops.add(workshop);
    }

    public ArrayList<Workshop<?>> getWorkshops() {
        return workshops;
    }
}

