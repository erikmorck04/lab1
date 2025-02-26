import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:
    private boolean secondCarAdjusted = false;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    //methods:
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Saab95());

        int index = 0;
        for (Vehicle car : cc.vehicles){
            car.setY(car.getY() + index);
            index += 100;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Workshop<Volvo240> volvoWork = new Workshop<>(3);
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle car = vehicles.get(i);
                car.move();

                // Special handling for the second car (index 1)
                

                if (car instanceof Volvo240 && car.getX() > 250 && car.getX() < 300 && car.getY() > 250 && car.getY() > 300){
                    volvoWork.acceptCar((Volvo240)car);


                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }void startEngine(){
        for (Vehicle car : vehicles){
            car.startEngine();
        }
    }void stopEngine(){
        for (Vehicle car : vehicles){
            car.stopEngine();
        }
    }
    void stopCars(){
        for (Vehicle car : vehicles){
            car.setCurrentSpeed(0);
        }
    }void turnLeft(){
        for (Vehicle car : vehicles){
            car.turnLeft();
        }
    }void turnRight(){
        for (Vehicle car : vehicles){
            car.turnRight();
        }
    }void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }void increaseAngle(){
        for (Vehicle car : vehicles){
            if (car instanceof  Scania){
                ((Scania)car).setFlakAngle(90);
            }
        }
    }void decreaseAngle(){
        for (Vehicle car : vehicles){
            if (car instanceof Scania){
                ((Scania)car).setFlakAngle(0);
            }
        }
    }
    void unload() {

    }
}
