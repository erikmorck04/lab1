import org.junit.Test;

import java.awt.*;
import java.util.Stack;

import static org.junit.Assert.*;


public class CarTest {
    // Testar att engine startar och stannar
    @Test
    public void testStartAndStopEngine(){
        Saab95 car = new Saab95();
        car.startEngine();
        assertEquals(0.1,car.getCurrentSpeed(),0); // delta är med hur mycket det kan vara fel
        car.stopEngine();
        assertEquals(0.0,car.getCurrentSpeed(),0);
    }
    // Testar att bilarna startar åt North
    @Test
    public void testCorrectDirection() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.move();
        assertEquals("0.0, 0.1", volvo.getPos());// 0.0, 250.1
    }
    // Checkar att speedFactor fungerar för båda
    @Test
    public void testSpeedFactorTrimAndTurbo() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.setTurboOn();
        assertEquals((1.3*0.01*125),saab.speedFactor(), 0.1);

        assertEquals((100*0.01*1.25), volvo.speedFactor(), 0.1);
    }
    // testar gas och break med olika värden
    @Test
    public void testGasBreak() {
        Car car = new Saab95();
        car.startEngine();
        car.gas(5);
        car.gas(1);
        car.brake(-2);
        car.brake(0);
        assertEquals(1.35,car.getCurrentSpeed(),0.1);
    }
    // Check if flak only moves when the car is stationary

    @Test
    public void testFlakIfMoving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.flakTippas(5);
        assertEquals(0,scania.getFlakAngle(),0.1);

    }
    @Test
    public void testMovingIfFlak() {
        Scania scania = new Scania();
        scania.flakTippas(5);
        scania.startEngine();
        scania.gas(1);
        assertEquals(0,scania.getCurrentSpeed(),0.01);
    }
    @Test
    public void testRampOpenClose() {
        CarTransport carTransport = new CarTransport(100, Color.red, "CarTransport2000", 10, 3);
        carTransport.rampOpen();
        assertEquals(1, carTransport.getFlakAngle(),0.01);
        carTransport.rampClose();
        assertEquals(0, carTransport.getFlakAngle(),0.01);
        carTransport.gas(1);
        carTransport.rampOpen();
        assertEquals(0, carTransport.getFlakAngle(),0.01);
    }
    @Test // går att loada bil, om den är för nära eller om den
    public void testLoadable() {
        CarTransport carTransport = new CarTransport(100, Color.red, "CarTransport2000", 10, 2);
        Volvo240 volvo = new Volvo240();
        carTransport.gas(1);
        carTransport.gas(1);
        carTransport.gas(1);
        carTransport.gas(1);
        carTransport.rampOpen();
        carTransport.loadCar(volvo);
        assertEquals(Stack,carTransport.getCarryList());
    }
    @Test
    public void testTransportPos() {
        CarTransport carTransport = new CarTransport(100, Color.red, "CarTransport2000", 10, 2);
        Volvo240 volvo = new Volvo240();
        carTransport.rampOpen();
        carTransport.loadCar(volvo);
        carTransport.gas(1);
        carTransport.gas(1);
        carTransport.gas(1);
    }
// tester: att bilar unloadas på i rätt ordning,
    @Test
    public void testFirstInLastOut() {
        CarTransport carTransport = new CarTransport(100, Color.red, "CarTransport2000", 10, 3);

        Volvo240 volvo = new Volvo240();
        Volvo240 volv = new Volvo240();
        Saab95 saab = new Saab95();

        carTransport.rampOpen();
        carTransport.loadCar(volvo);
        carTransport.loadCar(volv);

        System.out.println(carTransport.getCarryList());
        assertEquals(2.0, carTransport.getCarryList().size(),0.01);
        assertEquals(volv, carTransport.getCarryList().get(1));
        carTransport.loadCar(saab);
        assertEquals(3.0, carTransport.getCarryList().size(),0.01);
        carTransport.unloadCar();
        assertEquals(volv, carTransport.getCarryList().get(1));
        carTransport.unloadCar();
        assertEquals(volvo, carTransport.getCarryList().get(0));
    }
    @Test
    public void testWorkshop(){
        Workshop<Saab95> workshopSaab = new Workshop<Saab95>(3);
        Saab95 saab = new Saab95();
        assertEquals(0.0, workshopSaab.getCarList().size(),0.01);
        workshopSaab.acceptCar(saab);
        assertEquals(1.0, workshopSaab.getCarList().size(),0.01);
        workshopSaab.removeCar(s);
    }
}