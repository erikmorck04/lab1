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

    private final int delay = 50;
    private final CarManager carManager = new CarManager();
    private final Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;


    public CarController(){
        int index = 0;
        for (Vehicle car : carManager.getVehicles()){
            car.setY(car.getY() + index);
            index += 100;
        }
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", this);

        // Start the timer
        timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Workshop<Volvo240> volvoWork = new Workshop<>(3);
            for (int i = 0; i < carManager.getVehicles().size(); i++) {
                Vehicle car = carManager.getVehicles().get(i);
                car.move();

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
