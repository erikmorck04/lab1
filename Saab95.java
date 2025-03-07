import java.awt.*;

public class Saab95 extends Car {
    //Varia
    private boolean turboOn;

    //Konstruktor
    public Saab95() {
        super(2, 125, Color.red, "Saab95",4.8);
        this.turboOn = false;

    }
    //Sätter på turbo
    public void setTurboOn() {
        turboOn = true;
    }
    //Stänger av turbo
    public void setTurboOff() {
        turboOn = false;
    }
    //Saab95s speedfactor funktion
    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

