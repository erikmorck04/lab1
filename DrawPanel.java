import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ImageLoader imageLoader = new ImageLoader();
    private final List<Vehicle> vehicles;
    Point volvoWorkshopPoint = new Point(500,400);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles; // Store the reference
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Vehicle car : vehicles) {
                BufferedImage img = imageLoader.getVehicleImages().get(car.getClass());
                if (img != null) {
                    //car.setY(car.getY() + index);
                    g.drawImage(img, (int) car.getX(), (int) car.getY(), null);
                }
            }
            g.drawImage(imageLoader.volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }

    public abstract static class Truck extends Vehicle {

        private int flakAngle;
        private int maxAngle;
        public Truck(int nrDoors, double enginePower, Color color, String modelName, int max_angle,double length){
            super(nrDoors,enginePower,color,modelName,length);
            this.maxAngle = max_angle;
        }

        @Override //Gas-metod som tar hänsyn till om flaket är öppet
        public void gas(double amount) {
            if (flakAngle == 0) {
                super.gas(amount);
            }
        }
        @Override //Brake-metod som tar hänsyn till om flaket är öppet
        public void brake(double amount) {
            if (flakAngle == 0) {
                super.brake(amount);
            }
        }



        @Override
        public void startEngine(){
            if (flakAngle == 0) {
                super.startEngine();
            }
        }

        @Override
        public void move(){
            if(flakAngle == 0){
                super.move();
            }
        }

        public double getFlakAngle() {
            return flakAngle;
        }

        public void setFlakAngle(int angle) {
            if (angle >= 0 && getCurrentSpeed()<=0.001) { // Ensure the angle is within valid range
                flakAngle = Math.min(angle,maxAngle);
            } else {
                System.out.println(getCurrentSpeed());
                System.out.println(angle);
                System.out.println("Invalid flak angle or speed is not 0.");
            }
        }

        public void flakTippas(int amount) { //
            if(getCurrentSpeed() <= 0.001) {
                flakAngle = Math.max(flakAngle + amount, maxAngle);
            }
        }

        public void flakSankas(int amount) {
            if(getCurrentSpeed() <= 0.001) {
                flakAngle = Math.max(flakAngle - amount, 0);
            }
        }

        @Override // lastbilar accelererar långsamt detta bör ändras
        public double speedFactor() {
            return getEnginePower() * 0.01;
        }

    }
}
