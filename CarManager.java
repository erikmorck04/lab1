import java.util.ArrayList;
import java.util.Random;

public class CarManager{
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final ArrayList<Workshop<?>> workshops = new ArrayList<>();

    //Inte en bil men ska vara här ändå
    public CarManager(){

    }

    public void addVehicle(Vehicle vehicle) {
        if(vehicles.size()<10){
            vehicle.setY(0);
            vehicle.setX(0);
            vehicles.add(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void updateVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }


    public void addRandomVehicle(){
        Random rng = new Random();
        int i = rng.nextInt(3);
        switch (i){
            case 0:
                addVehicle(Volvo240.createVolvo());
                break;
            case 1:
                addVehicle(Saab95.createSaab());
                break;
            case 2:
                addVehicle(Scania.createScania());
                break;
        }

    }
    public void removeRandomVehicle(){
        if(!vehicles.isEmpty()){
            Random rng = new Random();
            vehicles.remove(rng.nextInt(vehicles.size()));
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

