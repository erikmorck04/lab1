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

        Workshop verkstad = new Workshop(10);
        verkstad.addType("Volvo240");
        verkstad.acceptCar(volvo2402);
        verkstad.print_types();
        verkstad.prints_cars();


    }
}
