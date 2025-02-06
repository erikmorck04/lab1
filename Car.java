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
    private boolean loadable;
    private double length;
    protected Car() {
    }

    //Enums för olika riktningar
    public enum Direction {
        North,
        East,
        South,
        West
    }
    //Konstruktor
    public Car(int nrDoors, double enginePower, Color color, String modelName,double length){
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.North;
        this.loadable = false;
        this.length = length;
    }

    //Getter för antal dörrar
    public int getNrDoors(){
        return nrDoors;
    }
    //Getter för enginePower
    public double getEnginePower(){
        return enginePower;
    }
    //Getter för fart
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public String getModelName(){return modelName;}
    //Getter för färg
    public Color getColor(){
        return color;
    }
    //Setter för färg
    public void setColor(Color clr){
        color = clr;
    }
    //Starta bilen
    public void startEngine(){
        currentSpeed = 0.1;
        System.out.println(modelName + " " + getPos());
    }
    //Stanna bilen
    public void stopEngine(){
        currentSpeed = 0;
    }

    //Getter för pos
    public String getPos() {
        return x + ", " + y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double new_x){
        x = new_x;
    }
    public void setY(double new_y){
        y = new_y;
    }
    //Setter för speed
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }
    //Ändrar ens x och y värde med ens riktning och fart
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
    //Ändrar riktning från en enum till en annan (tex north till west)
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
    //Ändrar riktning från en enum till en annan (tex north till east)
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
    //En abstract metod för speedfactor
    //Så att car inte behöver ha en egen speedfactor
    public abstract double speedFactor();
    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
    public double getLength(){
        return length;
    }
    public void gas(double amount) {
        double old_speed = currentSpeed;
        if (0 <= amount && 1 >= amount) {
            incrementSpeed(amount);

        }
        //Checkar ifall gamla farten inte är snabbare
        if(old_speed>currentSpeed) {
            currentSpeed = old_speed;
        }
        move();
        System.out.println(modelName + " " + getPos());
    }
    //Brake
    public void brake(double amount) {
        double old_speed = currentSpeed;
        if (0 <= amount && 1 >= amount) {
            decrementSpeed(amount);
        }
        //Checkar ifall gamla farten inte är långsammare
        if(old_speed<currentSpeed) {
            currentSpeed = old_speed;
        }
        move();
    }
}







