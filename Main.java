import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int boardWidth = 800;
        int boardHeight = 800;

        JFrame frame = new JFrame("Cars");
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.gray);

        CarViz carViz = new CarViz();



        Timer spawnTimer = new Timer(2000, e -> carViz.spawnPerson());
        spawnTimer.start();
        frame.add(carViz);
        frame.setVisible(true);

    }
}

// Om vilen direction, norr söder, west, east så kommer som flappy bird deras x och y värde åka med deras hastighet
// ha funktioner som car har
// gas
// spawnar snabbare desto fortare bilen går

// man ska lägga till en bil som ska ändra färg och hur snabbt den ska vara