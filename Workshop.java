import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class Workshop<T extends Car> {
    private final int maxCars;
    private final ArrayList<T> carList = new ArrayList<>();

   //Constructor för workshop
    public Workshop(int maxCars) {
        this.maxCars = maxCars;
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
        }else{
            System.out.println("Bil ej i verkstad");
        }
    }

}



