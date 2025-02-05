import java.awt.*;

public class Scania extends Car{

    private double flakAngle;

    public Scania() {
        super(2,120,Color.white,"Scania R500 V8 XT 6x4 Euro 6");
        this.flakAngle = 0.0;
    }

    @Override // lastbilar accelererar långsamt detta bör ändrass
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
}
