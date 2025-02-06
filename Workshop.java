import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class Workshop {
    private final int maxCars;
    private ArrayList<Car> carList = new ArrayList<Car>();
    private ArrayList<String> allowedTypes = new ArrayList<String>();

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
    }

    public void addType(String type){
        allowedTypes.add(type);
    }

    public void removeType(String type){
        allowedTypes.remove(type);
    }

    public void acceptCar(Car car){
        if(allowedTypes.contains(car.getModelName())){
            if(carList.size() < maxCars) {
                carList.add(car);
                System.out.println("Vehicle has entered the workshop");
            }
        }
        //else {
        //    throw new Exception("Fel sorts bil");
        //}
    }
    //Printar ut alla typer som är accepterade
    public void print_types() {
        for (String allowedType : allowedTypes) {
            System.out.println(allowedType);
        }
    }
    //Printar
    public void prints_cars(){
        for (Car car : carList) {
            System.out.println(car);
        }
    }
    public void removeCar(Car car){
        if(carList.contains(car)){
            carList.remove(car);
            System.out.println("Vehicle has left the workshop");
        }
    }

}



