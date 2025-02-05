import java.awt.*;

public class Scania extends Truck{

    public Scania() {
        super(2,120,Color.white,"Scania R500 V8 XT 6x4 Euro 6",70,4.8);
    }

    @Override // lastbilar accelererar långsamt detta bör ändras
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
