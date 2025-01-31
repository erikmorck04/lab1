import org.junit.Test;
import java.lang.invoke.VarHandle;
import static org.junit.Assert.*;


public class CarTest {
    @Test
    public void testStartAndStopEngine(){
        Saab95 car = new Saab95();
        car.startEngine();
        assertEquals(0.1,car.getCurrentSpeed(),0); // delta är med hur mycket det kan vara fel
        car.stopEngine();
        assertEquals(0.0,car.getCurrentSpeed(),0);
    }

    @Test
    public void testCorrectDirection() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.setCurrentSpeed(100);
        volvo.move();
        assertEquals("0.0, 100.0", volvo.getPos());// 0.0, 250.1
    }
    @Test
    public void testSpeedFactorTrimAndTurbo() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.setTurboOn();
        assertEquals((1.3*0.01*125),saab.speedFactor(), 0.1);

        assertEquals((100*0.01*1.25), volvo.speedFactor(), 0.1);
    }

    @Test
    public void testIncDecSpeed() {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        saab.incrementSpeed(10);
        saab.decrementSpeed(5);
        assertEquals(((0.1 + 125 * 1 * 0.01 * 10)-125 * 0.01 * 1 * 5), saab.getCurrentSpeed(),0.1);

        volvo.incrementSpeed(150);
        volvo.decrementSpeed(10);

        assertEquals(87.5,volvo.getCurrentSpeed(),0.1);
    }
// tester
}