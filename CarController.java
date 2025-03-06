
public class CarController{
    public final CarManager carManager = new CarManager();
    public TimerUpdate timerUpdate;
    // The frame that represents this instance View of the MVC pattern

    public CarController(){
        int index = 0;
        for (Vehicle car : carManager.getVehicles()){
            car.setY(car.getY() + index);
            index += 100;
        }
        // Start the timer
        timerUpdate = new TimerUpdate(carManager,new CarViewUpdater( new CarView("CarSim 1.0", this)));


    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : carManager.getVehicles()
        ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : carManager.getVehicles()) {
            car.brake(brake);
        }
    }void startEngine(){
        for (Vehicle car : carManager.getVehicles()){
            car.startEngine();
        }
    }void stopEngine(){
        for (Vehicle car : carManager.getVehicles()){
            car.stopEngine();
        }
    }
    void stopCars(){
        for (Vehicle car : carManager.getVehicles()){
            car.setCurrentSpeed(0);
        }
    }void turnLeft(){
        for (Vehicle car : carManager.getVehicles()){
            car.turnLeft();
        }
    }void turnRight(){
        for (Vehicle car : carManager.getVehicles()){
            car.turnRight();
        }
    }void turboOn() {
        for (Vehicle car : carManager.getVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }void turboOff() {
        for (Vehicle car : carManager.getVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }void increaseAngle(){
        for (Vehicle car : carManager.getVehicles()){
            if (car instanceof  Scania){
                ((Scania)car).setFlakAngle(90);
            }
        }
    }void decreaseAngle(){
        for (Vehicle car : carManager.getVehicles()){
            if (car instanceof Scania){
                ((Scania)car).setFlakAngle(0);
            }
        }
    }
}
