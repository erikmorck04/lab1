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

        Workshop<Volvo240> saabVerkstad = new Workshop<>(2);
        saabVerkstad.acceptCar(volvo);
        saabVerkstad.acceptCar(volvo);
        saabVerkstad.prints_cars();

        System.out.println(carTransport.getCarryList());


        Workshop<Vehicle> verkstad = new Workshop<>(2);
        //System.out.println(verksta);
    }
}
