import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ImageLoader imageLoader = new ImageLoader();
    private final List<Vehicle> vehicles;
    Point volvoWorkshopPoint = new Point(300,300);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles; // Store the reference
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Vehicle car : vehicles) {
                BufferedImage img = imageLoader.getVehicleImages().get(car.getClass());
                if (img != null) {
                    //car.setY(car.getY() + index);
                    g.drawImage(img, (int) car.getX(), (int) car.getY(), null);
                }
            }
            g.drawImage(imageLoader.volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }
    }
