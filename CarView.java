import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.random.RandomGenerator;

public class CarView extends JFrame{

        private static final int X = 800;
        private static final int Y = 800;
        int gasAmount = 0;
        // The controller member
        CarController carC;
        DrawPanel drawPanel;

        public CarView(String frameName){
            this.carC = new CarController(this.drawPanel);
            this.drawPanel = carC.timerUpdate.drawPanelUpdater.drawPanel;
            //this.drawPanel = new DrawPanel(X, Y - 240, carC.carManager.getVehicles());
            initComponents(frameName);
        }

        private void initComponents(String title) {

            this.setTitle(title);
            this.setPreferredSize(new Dimension(X,Y));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            this.add(drawPanel);

            JPanel controlPanel = new JPanel();
            JPanel gasPanel = new JPanel();
            JSpinner gasSpinner = new JSpinner();
            JLabel gasLabel = new JLabel("Amount of gas");
            JButton gasButton = new JButton("Gas");
            JButton brakeButton = new JButton("Brake");
            JButton turboOnButton = new JButton("Saab Turbo on");
            JButton turboOffButton = new JButton("Saab Turbo off");
            JButton liftBedButton = new JButton("Open flak");
            JButton lowerBedButton = new JButton("Close flak");
            JButton unloadWorkshopButton = new JButton("Unload");
            JButton turnLeftButton = new JButton("turn left");
            JButton turnRightButton = new JButton("turn right");
            JButton startButton = new JButton("Start all cars");
            JButton stopButton = new JButton("Stop all cars");
            JButton addCarButton = new JButton("Add car");
            JButton removeCarButton = new JButton("Remove button");

            SpinnerModel spinnerModel =
                    new SpinnerNumberModel(0, //initial value
                            0, //min
                            100, //max
                            1);//step
            gasSpinner = new JSpinner(spinnerModel);
            gasSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                }
            });

            gasPanel.setLayout(new BorderLayout());
            gasPanel.add(gasLabel, BorderLayout.PAGE_START);
            gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

            this.add(gasPanel);

            controlPanel.setLayout(new GridLayout(2,6));

            controlPanel.add(gasButton, 0);
            controlPanel.add(brakeButton, 1);
            controlPanel.add(turnLeftButton, 2);
            controlPanel.add(turnRightButton, 3);
            controlPanel.add(turboOnButton, 4);
            controlPanel.add(turboOffButton, 5);
            controlPanel.add(liftBedButton, 6);
            controlPanel.add(lowerBedButton, 7);
            controlPanel.add(addCarButton,8);
            controlPanel.add(removeCarButton,9);


            controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
            this.add(controlPanel);
            controlPanel.setBackground(Color.CYAN);


            startButton.setBackground(Color.blue);
            startButton.setForeground(Color.green);
            startButton.setPreferredSize(new Dimension(X/5-15,200));
            this.add(startButton);


            stopButton.setBackground(Color.red);
            stopButton.setForeground(Color.black);
            stopButton.setPreferredSize(new Dimension(X/5-15,200));
            this.add(stopButton);

            // This actionListener is for the gas button only
            // TODO: Create more for each component as necessary
            gasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.gas(gasAmount);
                }
            });
            brakeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.brake(gasAmount);
                }
            });
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.startEngine();
                }
            });
            stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.stopEngine();
                }
            });
            turnLeftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.turnLeft();
                }
            });
            turnRightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.turnRight();
                }
            });
            turboOnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.turboOn();
                }
            });
            turboOffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.turboOff();
                }
            });
            liftBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.increaseAngle();
                }
            });
            lowerBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.decreaseAngle();
                }
            });
            addCarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.carManager.addRandomVehicle();
                    //carC.carManager.addVehicle();
                }
            });
            removeCarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carC.carManager.removeRandomVehicle();
                    //carC.carManager.removeVehicle();
                }
            });

            // Make the frame pack all it's components by respecting the sizes if possible.
            this.pack();

            // Get the computer screen resolution
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            // Center the frame
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            // Make the frame visible
            this.setVisible(true);
            // Make sure the frame exits when "x" is pressed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }