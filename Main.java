import java.awt.*;

public class Main {
    public static void main(String[] args){
        Saab95 saab = new Saab95();
        saab.startEngine();
        System.out.println(saab.getPos());
        System.out.println(saab.getNrDoors());
        System.out.println(saab.speedFactor());
        saab.incrementSpeed(200);
        System.out.println(saab.getCurrentSpeed());
        saab.move();
        saab.turnLeft();
        saab.move();
        System.out.println(saab.getPos());

    }
}
