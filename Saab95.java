import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    public double currentSpeed; // The current speed of the car

    public Saab95(){
        super(2,125,Color.red,"Saab95");
	    turboOn = false;
        stopEngine();
    }
    private void setTurboOn(){
	    turboOn = true;
    }
    private void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }


    }

