import org.junit.Test;
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
        volvo.setCurrentSpeed(100);
        volvo.move();
        assertEquals("0.0, 100.0", volvo.getPos());// 0.0, 250.1
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
        scania.flakTippas();
        assertEquals(0,scania.getFlakAngle(),0.1);

    }
    @Test
    public void testMovingIfFlak() {
        Scania scania = new Scania();
        scania.flakTippas();
        scania.startEngine();
        scania.gas(1);
        assertEquals(0,scania.getCurrentSpeed(),0.01);
    }
// tester
}