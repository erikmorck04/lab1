import java.awt.*;


public class Main {
    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        CarTransport carTransport = new CarTransport(100,Color.gray,"car transporter 2000",10,2);
        CarTransport carTransport1 = new CarTransport(100,Color.gray,"car transporter 2001",10,2);
        Saab95 saab1 = new Saab95();
        Volvo240 volvo2402 = new Volvo240();
        volvo.startEngine();
        volvo2402.startEngine();
        saab1.startEngine();
        carTransport.startEngine();
        carTransport1.startEngine();


        carTransport.gas(1);
        carTransport.brake(1);
        carTransport.brake(1);
        System.out.println(carTransport.getCurrentSpeed());
        carTransport.rampOpen(); // 1
        carTransport.loadCar(carTransport1);
        carTransport.loadCar(volvo);
        carTransport.loadCar(saab1);
        carTransport.rampClose(); //0
        System.out.println(volvo.getPos());
        System.out.println(carTransport.getPos());
        carTransport.gas(1);
        carTransport.rampOpen();
        carTransport.brake(1);
        carTransport.brake(1);
        System.out.println(carTransport.getCurrentSpeed());
        System.out.println("Flak Angle before opening: " + carTransport.getFlakAngle());
        carTransport.unloadCar();
        carTransport.rampOpen();
        System.out.println("Flak Angle after opening: " + carTransport.getFlakAngle());
        carTransport.unloadCar();
        carTransport.unloadCar();
        carTransport.unloadCar();
        carTransport.gas(1);
        System.out.println(volvo.getPos());

    }
}
