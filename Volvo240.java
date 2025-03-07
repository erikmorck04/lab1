    import java.awt.*;

    public class Volvo240 extends Car {

        private final static double trimFactor = 1.25;

        //Konstruktor
        public Volvo240(){
            super(4,100,Color.black,"Volvo240",4.8);
        }
        //Volvo240s speedfactor funkton
        @Override
        public double speedFactor(){
            return getEnginePower() * 0.01 * trimFactor;
        }


    }