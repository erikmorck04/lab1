import java.awt.*;

public abstract class Truck extends Car {

    private int flakAngle;
    private int maxAngle;
    public Truck(int nrDoors, double enginePower, Color color, String modelName, int max_angle,double length){
        super(nrDoors,enginePower,color,modelName,length);
        flakAngle = 0;
        maxAngle = max_angle;
    }

    @Override
    public void gas(double amount) {
        if (flakAngle == 0) {
            super.gas(amount);
        }
    }
    @Override
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

    public void flakTippas(int amount) { //
        if(getCurrentSpeed() == 0) {
            flakAngle = Math.max(flakAngle + amount, maxAngle);
        }
    }

    public void flakSankas(int amount) {
        if(getCurrentSpeed() == 0) {
            flakAngle = Math.max(flakAngle - amount, 0);
        }
    }

    @Override // lastbilar accelererar långsamt detta bör ändras
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
