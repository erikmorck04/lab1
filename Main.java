import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception{
        //int boardWidth = 800;
        //int boardHeight = 800;
        //JFrame frame = new JFrame("Cars");
        //frame.setSize(boardWidth,boardHeight);
        //frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.gray);
        //CarViz carViz = new CarViz();
        //Timer spawnTimer = new Timer(2000, e -> carViz.spawnPerson());
        //spawnTimer.start();
        //frame.add(carViz);
        //frame.setVisible(true);
        Volvo240 volvo = new Volvo240();
        CarTransport carTransport = new CarTransport(100,Color.gray,"car transporter 2000",10);
        volvo.startEngine();
        volvo.gas(1);
        volvo.gas(1);
        volvo.gas(1);

        carTransport.startEngine();
        carTransport.gas(1);
        carTransport.loadCar(volvo);
        carTransport.gas(1);
        carTransport.unloadCar();
        carTransport.gas(1);
        System.out.println(volvo.getPos());

    }
}
