import java.awt.*;

public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private Direction direction;

    public enum Direction {
        North,
        East,
        South,
        West
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.North;
        stopEngine();
    }


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }


    public String getPos() {
        return x + ", " + y;
    }
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    @Override
    public void move(){
        switch (direction) {
            case North:
                y += currentSpeed;
                break;
            case West:
                x = x - currentSpeed;
                break;
            case East:
                x = x + currentSpeed;
                break;
            case South:
                y -= currentSpeed;
                break;
        }
    }
    @Override
    public void turnLeft(){
        switch (direction) {
            case North:
                direction = Direction.West;
                break;
            case East:
                direction = Direction.North;
                break;
            case West:
                direction = Direction.South;
                break;
            case South:
                direction = Direction.East;
                break;
        }
    }
    @Override
    public void turnRight(){
        switch (direction) {
            case North:
                direction = Direction.East;
                break;
            case East:
                direction = Direction.South;
                break;
            case West:
                direction = Direction.North;
                break;
            case South:
                direction = Direction.West;
                break;
        }
    }
    public abstract double speedFactor();
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void gas(double amount) {
        if (0 <= amount && 1 >= amount) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount) {
        if (0 <= amount && 1 >= amount) {
            decrementSpeed(amount);
        }
    }
}



//0
//0.5
//4
//2
//4
//6
//10
//14
//18





