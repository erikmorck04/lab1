import java.awt.*;

public class Volvo240 extends Car implements Movable{

    private final static double trimFactor = 1.25;
    public double currentSpeed; // The current speed of the car
    
    public Volvo240(){
        super(4,100,Color.black,"Volvo240");
        stopEngine();
    }
    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
