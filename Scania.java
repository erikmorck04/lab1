import java.awt.*;

public class Scania extends Car{

    private double flakAngle = 0.0;

    public Scania() {
        super(2,120,Color.white,"Scania R500 V8 XT 6x4 Euro 6");
    }

    @Override // lastbilar accelererar långsamt detta bör ändras
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void flakTippas() { //
        if (getCurrentSpeed() == 0) {
            if (flakAngle < 70) {
                flakAngle += 5;
            }
        }
    }

    public void flakSankas() {
        if (flakAngle > 0) {
            flakAngle -= 5;
        }
    }

    public double getFlakAngle() {
        return flakAngle;
    }

    public void gas(double amount) {
        double old_speed = getCurrentSpeed();
        if (0 <= amount && 1 >= amount) {
            if (flakAngle == 0) {
                incrementSpeed(amount);
            }
        }
        //Checkar ifall gamla farten inte är snabbare
        if(old_speed>getCurrentSpeed()) {
            setCurrentSpeed(old_speed);
        }
    }

    public void startEngine(){
        if (flakAngle == 0) {
            setCurrentSpeed(0.1);
        }
    }
}
